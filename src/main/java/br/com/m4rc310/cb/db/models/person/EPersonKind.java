package br.com.m4rc310.cb.db.models.person;

import lombok.Getter;

@Getter
public enum EPersonKind {
	PF(1), PJ(2);
	
	private int kindPerson;

	private EPersonKind(int kindPerson){
		this.kindPerson = kindPerson;
	}
}
