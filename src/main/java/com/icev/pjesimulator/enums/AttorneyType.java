package com.icev.pjesimulator.enums;

public enum AttorneyType {

    ADVOGADO("Advogado");


    private String descricao;


    private AttorneyType(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static AttorneyType getTypeByName(String name) {
        AttorneyType[] values = AttorneyType.values();
        for (AttorneyType type : values) {
            if(type.getDescricao().equals(name)) {
                return type;
            }
        }

        return null;
    }

    public static String toString(AttorneyType type) {
        return type.getDescricao();
    }
}
