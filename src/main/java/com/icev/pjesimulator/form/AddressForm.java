package com.icev.pjesimulator.form;

import com.icev.pjesimulator.models.JudiciaryClasses;
import com.icev.pjesimulator.models.Matter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class AddressForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
   
    private String cep;
    private String state;
    private String city;
    private String district;
    private String street;
    private Integer number;
    private String complement;
    private boolean useInProcess;
	private Long person_id;
	
    public AddressForm() {
	
    }

	public AddressForm(String cep, String state, String city, String district, String street, Integer number,
			String complement, boolean useInProcess, Long person_id) {
		this.cep = cep;
		this.state = state;
		this.city = city;
		this.district = district;
		this.street = street;
		this.number = number;
		this.complement = complement;
		this.useInProcess = useInProcess;
		this.setPerson_id(person_id);
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

	public Long getPerson_id() {return person_id;}

	public void setPerson_id(Long person_id) {this.person_id = person_id;}
}
