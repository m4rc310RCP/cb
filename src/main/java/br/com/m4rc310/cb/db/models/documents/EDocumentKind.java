package br.com.m4rc310.cb.db.models.documents;

import br.com.m4rc310.cb.messages.IConst;
import io.leangen.graphql.annotations.GraphQLEnumValue;
import lombok.Getter;

@Getter
public enum EDocumentKind implements IConst{
	
	@GraphQLEnumValue(name=ENUM$kind_document_fiscal_receipt, description=DESC$enum_kind_document_fiscal_receipt)
	FISCAL_RECEIPT (1);
	
	private int code;

	private EDocumentKind(int code) {
		this.code = code;
	}
}
