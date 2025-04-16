package br.com.m4rc310.cb.db.models.documents;

import java.io.Serializable;

import br.com.m4rc310.cb.db.models.listeners.DocumentListener;
import br.com.m4rc310.cb.messages.IConst;
import io.leangen.graphql.annotations.GraphQLIgnore;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.annotations.types.GraphQLType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import lombok.Data;

@Data
@Entity(name = IConst.TYPE$document)
@EntityListeners(DocumentListener.class)
@GraphQLType(name=IConst.TYPE$document, description=IConst.DESC$type_document)
public class Document implements Serializable, IConst{

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	@GraphQLIgnore
	private DocumentId id;
	
	@Column(name = NUMBER$control)
	@GraphQLQuery(name=NUMBER$control, description=DESC$number_control)
	private Long numberControl;
}
