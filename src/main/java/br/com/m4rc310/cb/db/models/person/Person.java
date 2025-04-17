package br.com.m4rc310.cb.db.models.person;

import java.io.Serializable;

import br.com.m4rc310.cb.messages.IConst;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.annotations.types.GraphQLType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = IConst.TYPE$person)
@GraphQLType(name=IConst.TYPE$person, description=IConst.DESC$type_person)
public class Person implements Serializable, IConst{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = NUMBER$cpfcnpj, length = 18)
	@GraphQLQuery(name=NUMBER$cpfcnpj, description=DESC$number_cpfcnpj)
	private String cpfcnpj;

	@Enumerated(EnumType.STRING)
	@Column(name = KIND$person)
	@GraphQLQuery(name=KIND$person, description=DESC$kind_person)
	private EPersonKind kind;
}
