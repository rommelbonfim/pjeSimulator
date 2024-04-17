package com.icev.pjesimulator.form;

import java.io.Serial;
import java.io.Serializable;

public class TelephoneForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    
    private String type;
    private String number;
	private Long person_id;
	
    public TelephoneForm() {

	}

	public TelephoneForm(String type, String number, Long person_id) {
		this.type = type;
		this.number = number;
		this.setPerson_id(person_id);
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
