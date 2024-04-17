package com.icev.pjesimulator.dto;

import com.icev.pjesimulator.enums.PersonType;
import com.icev.pjesimulator.models.Address;
import com.icev.pjesimulator.models.Document;
import com.icev.pjesimulator.models.Person;
import com.icev.pjesimulator.models.Telephone;

import java.util.List;
import java.util.Objects;

public class PersonDto {

    private Long id;
    private boolean estrangeiro;
    private String cpf;
    private String cnpj;
    private String type;
    private List<Address> addressList;
    private List<Document> documentList;
    private List<Telephone> telephoneList;

    public PersonDto() {
    	
    }

    public PersonDto(Person entity) {
        this.id = entity.getId();
        this.estrangeiro = entity.isEstrangeiro();
        this.cpf = entity.getCpf();
        this.cnpj = entity.getCnpj();
        this.type = PersonType.toString(entity.getType());
        this.addressList = entity.getAddresses();
        this.documentList = entity.getDocuments();
        this.telephoneList = entity.getTelephones();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public List<Document> getDocumentList() {
        return documentList;
    }

    public void setDocumentList(List<Document> documentList) {
        this.documentList = documentList;
    }

    public List<Telephone> getTelephoneList() {
        return telephoneList;
    }

    public void setTelephoneList(List<Telephone> telephoneList) {
        this.telephoneList = telephoneList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonDto personDto = (PersonDto) o;
        return estrangeiro == personDto.estrangeiro && Objects.equals(id, personDto.id) && Objects.equals(cpf, personDto.cpf) && Objects.equals(cnpj, personDto.cnpj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, estrangeiro, cpf, cnpj);
    }

    @Override
    public String toString() {
        return "PersonDto{" +
                "id=" + id +
                ", estrangeiro=" + estrangeiro +
                ", cpf='" + cpf + '\'' +
                ", cnpj='" + cnpj + '\'' +
                '}';
    }
}
