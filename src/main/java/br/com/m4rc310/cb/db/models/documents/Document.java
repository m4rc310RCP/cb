package br.com.m4rc310.cb.db.models.documents;

import java.io.Serializable;

import br.com.m4rc310.cb.messages.IConst;
import io.leangen.graphql.annotations.types.GraphQLType;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = IConst.TYPE$document)
@GraphQLType(name=IConst.TYPE$document, description=IConst.DESC$type_document)
public class Document implements Serializable, IConst{

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private DocumentId id;
}
