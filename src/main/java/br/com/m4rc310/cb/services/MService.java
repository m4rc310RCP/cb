package br.com.m4rc310.cb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.m4rc310.cb.db.models.auth.user.IUserRepository;
import br.com.m4rc310.cb.db.models.documents.IDocumentItemRepository;
import br.com.m4rc310.cb.db.models.documents.IDocumentRepository;
import br.com.m4rc310.cb.db.models.person.IPersonRepository;
import br.com.m4rc310.cb.messages.IConst;
import br.com.m4rc310.core.graphql.configurations.security.impls.MGraphQLJwtService;
import br.com.m4rc310.core.weather.services.MWeatherService;

public class MService extends br.com.m4rc310.core.graphql.services.MService implements IConst {
	
	@Autowired
	protected IUserRepository userRepository;
	
	@Autowired
	protected IDocumentRepository documentRepository;

	@Autowired
	protected IPersonRepository personRepository;

	@Autowired
	protected IDocumentItemRepository documentItemRepository;
	
	@Autowired
	protected MWeatherService weatherService;
	
	@Autowired
	protected MGraphQLJwtService jwt;
	
	@Autowired
	protected ApplicationContext applicationContext;
	
	@Autowired
	private ObjectMapper mapper;
	
	

	protected <T> T jsonToObject(String json, Class<T> type) throws JsonProcessingException, JsonMappingException {
		return mapper.readValue(json, type);
	}
}
