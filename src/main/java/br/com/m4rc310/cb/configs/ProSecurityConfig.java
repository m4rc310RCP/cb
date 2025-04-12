package br.com.m4rc310.cb.configs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;

import br.com.m4rc310.cb.constants.ILocalConst;
import br.com.m4rc310.cb.db.models.auth.user.IUserRepository;
import br.com.m4rc310.cb.db.models.auth.user.User;
import br.com.m4rc310.core.graphql.configurations.security.IMAuthUserProvider;
import br.com.m4rc310.core.graphql.configurations.security.dtos.MUser;
import br.com.m4rc310.core.graphql.configurations.security.impls.MGraphQLJwtService;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableCaching
@EnableScheduling
@Profile(ILocalConst.VALUE_PROFILE_PROD)
public class ProSecurityConfig {
	
	@Autowired
	private IUserRepository userRepository;
	
	public static final String CLIENT_SUBSCRIPTION_KEY = "${client_subscription_key:${AUTH_SECURITY_SIGNING}}";
	
	public static final String BASIC = "basic";
	public static final String AUTH = "auth";
	public static final String ADMIN = "admin";
	
	@PostConstruct
	private void init() {
		log.info("****** Loading PROD config's ******");
	}
	
	
	@Bean
	IMAuthUserProvider getAuthUserProviderForProd(ApplicationContext applicationContext, TaskScheduler taskScheduler) {
		return new IMAuthUserProvider() {

			@Override
			@Cacheable(value = "authUserCache", key = "#username")
			public MUser authUser(String username, Object password) throws Exception {
				MUser user = getUserFromUsername(username);
				assertEquals(user.getPassword(), password);
				assertFalse("Invalid user", isValidUser(user));				
				return user;
			}

			@Override
			public MUser getUserFromUsername(String username) {
				try {
					User u = userRepository.findById(username).orElseThrow(()->new Exception());
					MUser user = new MUser();
					user.setUsername(u.getUsername());
					user.setPassword(u.getPassword());
					return user;
				} catch (Exception e) {					
					return null;
				}
			}

			@Override
			public boolean isValidUser(MUser user) {
				return false;
			}

			@Override
			@Cacheable(value = "authUserCache", key = "#token")
			public MUser authUser(String token, MGraphQLJwtService jwt) throws Exception {
				String sauth = jwt.decrypt(token);
				int i = sauth.indexOf(":");
				String username = sauth.substring(0, i);
				String key = sauth.substring(i + 1);

				MUser user = new MUser();
				user.setUsername(username);
				user.setRoles(AUTH.split(";"));

				System.setProperty(CLIENT_SUBSCRIPTION_KEY, key);

				Date now = new Date();

				Calendar cal = new GregorianCalendar();
				cal.setTime(now);
				cal.add(Calendar.MINUTE, 5);

				taskScheduler.schedule(() -> {
					ProSecurityConfig config = applicationContext.getBean(ProSecurityConfig.class);
					config.clearCache(token);
				}, cal.toInstant());

				return user;
			}
			
		};
	}

	@CacheEvict(value = "authUserCache", key = "#token")
	public void clearCache(String token) {
		log.info("Removed cashe for token: {}", token);
	}
}
