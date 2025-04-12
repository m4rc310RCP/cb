package br.com.m4rc310.cb.messages;


import br.com.m4rc310.core.graphql.messages.annotations.MConstants;

@MConstants
public interface IConst {
	//--------------------------------------------------
	// ********** DESC **********
	//--------------------------------------------------
	public static final String DESC$query_test = "${desc.query.test}";

	//--------------------------------------------------
	// ********** QUERY **********
	//--------------------------------------------------
	// @GraphQLQuery(name=QUERY$test, description=DESC$query_test)
	public static final String QUERY$test = "${query.test}";


}
