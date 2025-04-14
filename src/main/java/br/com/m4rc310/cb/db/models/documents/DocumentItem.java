package br.com.m4rc310.cb.db.models.documents;

import java.io.Serializable;

import br.com.m4rc310.cb.messages.IConst;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.annotations.types.GraphQLType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = IConst.TYPE$document_item)
@EntityListeners(PrePersistListener.class)
@IdClass(DocumentItemId.class)
@GraphQLType(name=IConst.TYPE$document_item, description=IConst.DESC$type_document_item)
public class DocumentItem implements Serializable, IConst{

	private static final long serialVersionUID = 1L;
	
	@Id
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = NUMBER$cpfcnpj, insertable = false, updatable = false),
		@JoinColumn(name = KIND$document, insertable = false, updatable = false),
		@JoinColumn(name = NUMBER$document, insertable = false, updatable = false),
		@JoinColumn(name = NUMBER$serie, insertable = false, updatable = false),
	})
	private Document document;

	@Id
	@Column(name = NUMBER$document_item)
	@GraphQLQuery(name=NUMBER$document_item, description=DESC$number_document_item)
	private Integer item;
	
}
