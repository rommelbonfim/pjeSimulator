package com.icev.pjesimulator.dto;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

import com.icev.pjesimulator.models.Document;

public class DocumentDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String type;
    private int number;
    private Date expedition_date;
    private String expeditor;
    private String state;
    private String nome;
	private Long person_id;
	
    public DocumentDto() {

	}

	public DocumentDto(Document document) {
		this.type = document.getType();
		this.number = document.getNumber();
		this.expedition_date = document.getExpedition_date();
		this.expeditor = document.getExpeditor();
		this.state = document.getState();
		this.nome = document.getNome();
		this.person_id = document.getPerson().getId();
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

	public Date getExpedition_date() {
		return expedition_date;
	}

	public void setExpedition_date(Date expedition_date) {
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
