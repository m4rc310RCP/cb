package br.com.m4rc310.cb.db.models.auth.user;

import java.io.Serializable;

import br.com.m4rc310.cb.db.models.person.Person;
import br.com.m4rc310.cb.messages.IConst;
import io.leangen.graphql.annotations.GraphQLIgnore;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.annotations.types.GraphQLType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity(name = IConst.TYPE$auth_user)
@GraphQLType(name=IConst.TYPE$auth_user, description=IConst.DESC$type_auth_user)
public class User implements Serializable, IConst{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = ALIAS$user)
	@GraphQLQuery(name=ALIAS$user, description=DESC$alias_user)
	private String username;
	
	@OneToOne()
	@JoinColumn(name = NUMBER$cpfcnpj)
	@GraphQLIgnore	
	private Person pessoa;
	
	@Column(name = VALUE$password)
	@GraphQLQuery(name=VALUE$password, description=DESC$value_password)
	private String password;
	
	@Column(name = LIST$authorities)
	@GraphQLQuery(name=LIST$authorities, description=DESC$list_authorities)
	private String listAuthorities;
}
