package com.icev.pjesimulator.dto;

import java.io.Serial;
import java.io.Serializable;

import com.icev.pjesimulator.models.Telephone;

public class TelephoneDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    
    private String type;
    private String number;
	private Long person_id;
	
    public TelephoneDto() {

	}

	public TelephoneDto(Telephone telephone) {
		this.type = telephone.getType();
		this.number = telephone.getNumber();
		this.person_id = telephone.getPerson().getId();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Long getPerson_id() {
		return person_id;
	}

	public void setPerson_id(Long person_id) {
		this.person_id = person_id;
	}
}
