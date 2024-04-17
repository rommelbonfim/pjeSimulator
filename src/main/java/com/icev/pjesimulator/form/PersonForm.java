package com.icev.pjesimulator.form;

import java.util.List;

import com.icev.pjesimulator.enums.PersonType;
import com.icev.pjesimulator.models.Address;
import com.icev.pjesimulator.models.Person;

public class PersonForm {

    private boolean estrangeiro;
    private String cpf;
    private String cnpj;
    private String type;

    public PersonForm(Long id, boolean estrangeiro, String cpf, String cnpj, String type, List<Address> addresses) {
        this.estrangeiro = estrangeiro;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.type = type;
    }

    public Person toPerson(PersonForm form) {
    	Person person = new Person();
    	person.setEstrangeiro(estrangeiro);
    	person.setCpf(cpf);
    	person.setCnpj(cnpj);
    	person.setType(PersonType.getTypeByName(type));
        return person;
    }

    public boolean isEstrangeiro() {
        return estrangeiro;
    }

    public void setEstrangeiro(boolean estrangeiro) {
        this.estrangeiro = estrangeiro;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
