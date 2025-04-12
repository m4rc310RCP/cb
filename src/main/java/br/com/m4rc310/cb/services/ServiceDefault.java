package br.com.m4rc310.cb.services;

import org.springframework.stereotype.Service;

import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;

@Service
@GraphQLApi
public class ServiceDefault extends MService{
	
	@GraphQLQuery(name=QUERY$test, description=DESC$query_test)
	public String testApi() {
		return "OK";
	}
}
