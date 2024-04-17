package com.icev.pjesimulator.enums;

public enum PersonType {

    PESSOAFISICA("Pessoa Física"),
    PESSOAJURIDICA("Pessoa Jurídica");

    private String descricao;


    private PersonType(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
        return descricao;
    }

    public static PersonType getTypeByName(String name) {
    	PersonType[] values = PersonType.values();
		for (PersonType type : values) {
			if(type.getDescricao().equals(name)) {
				return type;
			}
		}
		
		return null;
	}
    
    public static String toString(PersonType type) {
    	return type.getDescricao();
    }
}