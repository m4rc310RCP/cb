package br.com.m4rc310.cb.configs;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;

import br.com.m4rc310.core.graphql.configurations.security.IMAuthUserProvider;
import br.com.m4rc310.core.graphql.configurations.security.dtos.MUser;
import br.com.m4rc310.core.graphql.configurations.security.impls.MGraphQLJwtService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableCaching
@EnableScheduling
public class SecurityConfig implements IMAuthUserProvider {

	public static final String BASIC = "basic";
	public static final String AUTH = "auth";
	public static final String ADMIN = "admin";
	public static final String CLIENT_SUBSCRIPTION_KEY = "${client_subscription_key:${AUTH_SECURITY_SIGNING}}";
	
	@Autowired
	protected ApplicationContext applicationContext;

	@Autowired
	protected TaskScheduler taskScheduler;
	

	@Override
	@Cacheable(value = "authUserCache", key = "#username")
	public MUser authUser(String username, Object password) throws Exception {
		MUser user;
		if ("auth".equals(username)) {
			user = new MUser();
			user.setUsername(username);
			user.setPassword(String.valueOf(password));

			String[] roles = new String[] { BASIC, AUTH };
			user.setRoles(roles);

			return user;
		}

		user = new MUser();
		user.setUsername(username);
		user.setPassword(String.valueOf(password));
		user.setRoles("ADMIN".split(";"));
		return user;
	}

	@Override
	public MUser getUserFromUsername(String username) {
		MUser user = new MUser();
		user.setUsername(username);
		user.setRoles(new String[] { ADMIN });
		return user;
	}

	@Override
	public boolean isValidUser(MUser user) {
		return true;
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
			SecurityConfig config = applicationContext.getBean(SecurityConfig.class);
			config.clearCache(token);
		}, cal.toInstant());

		return user;
	}

	@CacheEvict(value = "authUserCache", key = "#token")
	public void clearCache(String token) {
		log.info("Removed cashe for token: {}", token);
	}

}
