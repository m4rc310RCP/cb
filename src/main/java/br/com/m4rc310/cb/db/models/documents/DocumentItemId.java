package br.com.m4rc310.cb.db.models.documents;

import br.com.m4rc310.cb.messages.IConst;
import io.leangen.graphql.annotations.GraphQLQuery;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;

public class DocumentItemId implements IConst{
	
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
