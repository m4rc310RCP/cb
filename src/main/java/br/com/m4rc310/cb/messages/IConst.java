package br.com.m4rc310.cb.messages;


import br.com.m4rc310.core.graphql.messages.annotations.MConstants;

@MConstants
public interface IConst {
	//--------------------------------------------------
	// ********** ALIAS **********
	//--------------------------------------------------
	// @GraphQLQuery(name=ALIAS$user, description=DESC$alias_user)
	public static final String ALIAS$user = "${alias.user}";

	//--------------------------------------------------
	// ********** ARGUMENT **********
	//--------------------------------------------------
	// @GraphQLArgument(name=ARGUMENT$user, description=DESC$argument_user)
	public static final String ARGUMENT$user = "${argument.user}";

	//--------------------------------------------------
	// ********** DESC **********
	//--------------------------------------------------
	public static final String DESC$alias_user = "${desc.alias.user}";
	public static final String DESC$argument_user = "${desc.argument.user}";
	public static final String DESC$mutation_generate_token = "${desc.mutation.generate.token}";
	public static final String DESC$number_version = "${desc.number.version}";
	public static final String DESC$query_test = "${desc.query.test}";
	public static final String DESC$type_auth_user = "${desc.type.auth.user}";
	public static final String DESC$value_password = "${desc.value.password}";

	//--------------------------------------------------
	// ********** MUTATION **********
	//--------------------------------------------------
	// @GraphQLMutation(name=MUTATION$generate_token, description=DESC$mutation_generate_token)
	public static final String MUTATION$generate_token = "${mutation.generate.token}";

	//--------------------------------------------------
	// ********** NUMBER **********
	//--------------------------------------------------
	// @GraphQLQuery(name=NUMBER$version, description=DESC$number_version)
	public static final String NUMBER$version = "${number.version}";

	//--------------------------------------------------
	// ********** QUERY **********
	//--------------------------------------------------
	// @GraphQLQuery(name=QUERY$test, description=DESC$query_test)
	public static final String QUERY$test = "${query.test}";

	//--------------------------------------------------
	// ********** TYPE **********
	//--------------------------------------------------
	// @GraphQLType(name=IConst.TYPE$auth_user, description=IConst.DESC$type_auth_user)
	public static final String TYPE$auth_user = "${type.auth.user}";

	//--------------------------------------------------
	// ********** VALUE **********
	//--------------------------------------------------
	// @GraphQLQuery(name=VALUE$password, description=DESC$value_password)
	public static final String VALUE$password = "${value.password}";


}
