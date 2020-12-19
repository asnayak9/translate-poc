package com.shree.poc;

import java.util.Optional;

public enum TaxType {

	REQUIRED(1,"REQUIRED"), RECEIVED(2,"RECEIVED"), REQUIRED_BALANCE(3,"REQUIRED_BALANCE");
	
	int typeId;
	String typeName;
	
	TaxType(int tId, String tName){
		this.typeId = tId;
		this.typeName = tName;
	}
	
	public static Optional<TaxType> fromString(String nm) {
		for(TaxType tt : values()) {
			if(tt.typeName.equalsIgnoreCase(nm)) {
				return Optional.of(tt);
			}
		}
		
		return null;
	}

	public int getTypeId() {
		return typeId;
	}

	public String getTypeName() {
		return typeName;
	}
	
	
}
