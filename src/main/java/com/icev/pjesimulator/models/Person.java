package com.icev.pjesimulator.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.icev.pjesimulator.enums.PersonType;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private boolean estrangeiro;
    private String cpf;
    private String cnpj;
    
    @Enumerated(EnumType.STRING)
    private PersonType type;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "address_id")
    private List<Address> addresses = new ArrayList<>();

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "document_id")
    private List<Document> documents = new ArrayList<>();

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "telephone_id")
    private List<Telephone> telephones = new ArrayList<>();


    public Person() {

    }

    public Person(Long id, boolean estrangeiro, String cpf, String cnpj, PersonType type, List<Address> addresses, List<Document> documents, List<Telephone> telephones) {
        this.id = id;
        this.estrangeiro = estrangeiro;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.setType(type);
        this.addresses = addresses;
        this.documents = documents;
        this.telephones = telephones;
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

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public List<Telephone> getTelephones() {
        return telephones;
    }

    public void setTelephones(List<Telephone> telephones) {
        this.telephones = telephones;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return estrangeiro == person.estrangeiro && Objects.equals(id, person.id) && Objects.equals(cpf, person.cpf) && Objects.equals(cnpj, person.cnpj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, estrangeiro, cpf, cnpj);
    }

	public PersonType getType() {
		return type;
	}

	public void setType(PersonType type) {
		this.type = type;
	}
}

