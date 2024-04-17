package com.icev.pjesimulator.models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class Address {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cep;
    private String state;
    private String city;
    private String district;
    private String street;
    private Integer number;
    private String complement;
    private boolean useInProcess;
	@ManyToOne
	private Person person;

    public Address() {
    
    }
    
    
    public Address(String cep, String state, String city, String district, String street, Integer number,
			String complement, boolean useInProcess) {
		super();
		this.cep = cep;
		this.state = state;
		this.city = city;
		this.district = district;
		this.street = street;
		this.number = number;
		this.complement = complement;
		this.useInProcess = useInProcess;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getDistrict() {
		return district;
	}


	public void setDistrict(String district) {
		this.district = district;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public Integer getNumber() {
		return number;
	}


	public void setNumber(Integer number) {
		this.number = number;
	}


	public String getComplement() {
		return complement;
	}


	public void setComplement(String complement) {
		this.complement = complement;
	}


	public boolean isUseInProcess() {
		return useInProcess;
	}


	public void setUseInProcess(boolean useInProcess) {
		this.useInProcess = useInProcess;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}