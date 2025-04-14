package br.com.m4rc310.cb.db.models.documents;

import lombok.Getter;

@Getter
public enum EDocumentKind {
	
//	@GraphQLEnumValue(name = )
	FISCAL_RECEIPT (1);
	
	private int code;

	private EDocumentKind(int code) {
		this.code = code;
	}
}
