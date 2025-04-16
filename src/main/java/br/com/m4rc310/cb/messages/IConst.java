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
	// ********** CODE **********
	//--------------------------------------------------
	// @GraphQLQuery(name=CODE$product, description=DESC$code_product)
	public static final String CODE$product = "${code.product}";

	//--------------------------------------------------
	// ********** DESC **********
	//--------------------------------------------------
	public static final String DESC$alias_user = "${desc.alias.user}";
	public static final String DESC$argument_user = "${desc.argument.user}";
	public static final String DESC$code_product = "${desc.code.product}";
	public static final String DESC$description_product = "${desc.description.product}";
	public static final String DESC$enum_kind_document_fiscal_receipt = "${desc.enum.kind.document.fiscal.receipt}";
	public static final String DESC$kind_document = "${desc.kind.document}";
	public static final String DESC$kind_person = "${desc.kind.person}";
	public static final String DESC$list_authorities = "${desc.list.authorities}";
	public static final String DESC$mutation_generate_token = "${desc.mutation.generate.token}";
	public static final String DESC$mutation_register_nfe = "${desc.mutation.register.nfe}";
	public static final String DESC$number_control = "${desc.number.control}";
	public static final String DESC$number_cpfcnpj = "${desc.number.cpfcnpj}";
	public static final String DESC$number_document = "${desc.number.document}";
	public static final String DESC$number_document_item = "${desc.number.document.item}";
	public static final String DESC$number_key_nfe = "${desc.number.key.nfe}";
	public static final String DESC$number_serie = "${desc.number.serie}";
	public static final String DESC$number_version = "${desc.number.version}";
	public static final String DESC$query_test = "${desc.query.test}";
	public static final String DESC$type_auth_user = "${desc.type.auth.user}";
	public static final String DESC$type_document = "${desc.type.document}";
	public static final String DESC$type_document_item = "${desc.type.document.item}";
	public static final String DESC$type_person = "${desc.type.person}";
	public static final String DESC$type_product = "${desc.type.product}";
	public static final String DESC$value_password = "${desc.value.password}";

	//--------------------------------------------------
	// ********** DESCRIPTION **********
	//--------------------------------------------------
	// @GraphQLQuery(name=DESCRIPTION$product, description=DESC$description_product)
	public static final String DESCRIPTION$product = "${description.product}";

	//--------------------------------------------------
	// ********** ENUM **********
	//--------------------------------------------------
	// @GraphQLQuery(name=ENUM$kind_document_fiscal_receipt, description=DESC$enum_kind_document_fiscal_receipt)
	public static final String ENUM$kind_document_fiscal_receipt = "${enum.kind.document.fiscal.receipt}";

	//--------------------------------------------------
	// ********** ERROR **********
	//--------------------------------------------------
	// @GraphQLQuery(name=ERROR$invalid_credentials, description=DESC$error_invalid_credentials)
	public static final String ERROR$invalid_credentials = "${error.invalid.credentials}";
	// @GraphQLQuery(name=ERROR$invalid_user, description=DESC$error_invalid_user)
	public static final String ERROR$invalid_user = "${error.invalid.user}";

	//--------------------------------------------------
	// ********** KIND **********
	//--------------------------------------------------
	// @GraphQLQuery(name=KIND$document, description=DESC$kind_document)
	public static final String KIND$document = "${kind.document}";
	// @GraphQLQuery(name=KIND$person, description=DESC$kind_person)
	public static final String KIND$person = "${kind.person}";

	//--------------------------------------------------
	// ********** LIST **********
	//--------------------------------------------------
	// @GraphQLQuery(name=LIST$authorities, description=DESC$list_authorities)
	public static final String LIST$authorities = "${list.authorities}";

	//--------------------------------------------------
	// ********** MUTATION **********
	//--------------------------------------------------
	// @GraphQLMutation(name=MUTATION$generate_token, description=DESC$mutation_generate_token)
	public static final String MUTATION$generate_token = "${mutation.generate.token}";
	// @GraphQLMutation(name=MUTATION$register_nfe, description=DESC$mutation_register_nfe)
	public static final String MUTATION$register_nfe = "${mutation.register.nfe}";

	//--------------------------------------------------
	// ********** NUMBER **********
	//--------------------------------------------------
	// @GraphQLQuery(name=NUMBER$control, description=DESC$number_control)
	public static final String NUMBER$control = "${number.control}";
	// @GraphQLQuery(name=NUMBER$cpfcnpj, description=DESC$number_cpfcnpj)
	public static final String NUMBER$cpfcnpj = "${number.cpfcnpj}";
	// @GraphQLQuery(name=NUMBER$document, description=DESC$number_document)
	public static final String NUMBER$document = "${number.document}";
	// @GraphQLQuery(name=NUMBER$document_item, description=DESC$number_document_item)
	public static final String NUMBER$document_item = "${number.document.item}";
	// @GraphQLQuery(name=NUMBER$key_nfe, description=DESC$number_key_nfe)
	public static final String NUMBER$key_nfe = "${number.key.nfe}";
	// @GraphQLQuery(name=NUMBER$serie, description=DESC$number_serie)
	public static final String NUMBER$serie = "${number.serie}";
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
	// @GraphQLType(name=IConst.TYPE$document, description=IConst.DESC$type_document)
	public static final String TYPE$document = "${type.document}";
	// @GraphQLType(name=IConst.TYPE$document_item, description=IConst.DESC$type_document_item)
	public static final String TYPE$document_item = "${type.document.item}";
	// @GraphQLType(name=IConst.TYPE$person, description=IConst.DESC$type_person)
	public static final String TYPE$person = "${type.person}";
	// @GraphQLType(name=IConst.TYPE$product, description=IConst.DESC$type_product)
	public static final String TYPE$product = "${type.product}";

	//--------------------------------------------------
	// ********** VALUE **********
	//--------------------------------------------------
	// @GraphQLQuery(name=VALUE$password, description=DESC$value_password)
	public static final String VALUE$password = "${value.password}";


}
