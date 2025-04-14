package br.com.m4rc310.cb.db.models.documents;

import java.io.Serializable;

import br.com.m4rc310.cb.db.models.person.Person;
import br.com.m4rc310.cb.messages.IConst;
import io.leangen.graphql.annotations.GraphQLIgnore;
import io.leangen.graphql.annotations.GraphQLQuery;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Embeddable
public class DocumentId implements Serializable, IConst {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = NUMBER$cpfcnpj )
	@GraphQLIgnore
	private Person company;
	
	@Column(name = KIND$document )
	@Enumerated(EnumType.ORDINAL)
	@GraphQLQuery(name=KIND$document, description=DESC$kind_document)
	private EDocumentKind kind;
	
	@Column(name = NUMBER$document, length = 20)
	@GraphQLQuery(name=NUMBER$document, description=DESC$number_document)
	private Long number;
	
	@Column(name = NUMBER$serie, length = 10)
	@GraphQLQuery(name=NUMBER$serie, description=DESC$number_serie)
	private String serie;	
}
