package com.icev.pjesimulator.dto;

import java.io.Serial;
import java.io.Serializable;

import com.icev.pjesimulator.models.Address;

public class AddressDto implements Serializable {

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
	
    public AddressDto() {
	
    }

	public AddressDto(Address address) {
		this.cep = address.getCep();
		this.state = address.getState();
		this.city = address.getCity();
		this.district = address.getDistrict();
		this.street = address.getStreet();
		this.number = address.getNumber();
		this.complement = address.getComplement();
		this.useInProcess = address.isUseInProcess();
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
}
