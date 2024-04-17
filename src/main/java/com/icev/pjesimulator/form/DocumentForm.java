package com.icev.pjesimulator.form;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

public class DocumentForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String type;
    private int number;
    private String expedition_date;
    private String expeditor;
    private String state;
    private String nome;
	private Long person_id;
	
    public DocumentForm() {

	}

	public DocumentForm(String type, int number, String expedition_date, String expeditor, String state, String nome, Long person_id) {
		super();
		this.type = type;
		this.number = number;
		this.expedition_date = expedition_date;
		this.expeditor = expeditor;
		this.state = state;
		this.nome = nome;
		this.setPerson_id(person_id);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getExpedition_date() {
		return expedition_date;
	}

	public void setExpedition_date(String expedition_date) {
		this.expedition_date = expedition_date;
	}

	public String getExpeditor() {
		return expeditor;
	}

	public void setExpeditor(String expeditor) {
		this.expeditor = expeditor;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getPerson_id() {
		return person_id;
	}

	public void setPerson_id(Long person_id) {
		this.person_id = person_id;
	}
}
