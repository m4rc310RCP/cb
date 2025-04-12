package br.com.m4rc310.cb.services.auth.dev;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import br.com.m4rc310.cb.constants.ILocalConst;
import br.com.m4rc310.cb.db.models.auth.user.IUserRepository;
import br.com.m4rc310.cb.db.models.auth.user.User;
import br.com.m4rc310.cb.services.MService;
import br.com.m4rc310.core.graphql.configurations.security.dtos.MUser;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;

@Service
@GraphQLApi
@Profile(ILocalConst.VALUE_PROFILE_STAGE)
public class ServiceDefault extends MService{

    private final IUserRepository userRepository;

    ServiceDefault(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }
	
	@GraphQLQuery(name=QUERY$test, description=DESC$query_test)
	public String testApi() {
		return "OK";
	}
	
	@GraphQLMutation(name=MUTATION$generate_token, description=DESC$mutation_generate_token)
	public String getToken(
			@GraphQLArgument(name=ARGUMENT$user, description=DESC$argument_user)
			User user) throws Exception {
		
		MUser u = new MUser();
		u.setUsername(user.getUsername());
		u.setPassword(user.getPassword());
		
		return jwt.generateToken(u);
	}
	
	
	public User loadUserFromUsername(String username) {
		return userRepository.findById(username).orElse(null);
	}
	
}
