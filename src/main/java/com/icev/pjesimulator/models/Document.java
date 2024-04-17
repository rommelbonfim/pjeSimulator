package com.icev.pjesimulator.models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Document {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private int number;
    private Date expedition_date;
    private String expeditor;
    private String state;
    private String nome;
	@ManyToOne
	private Person person;
    
  
    public Document() {
    
    }
    
    
    public Document(String type, int number, Date expedition_date, String expeditor, String state, String nome) {
		super();
		this.type = type;
		this.number = number;
		this.expedition_date = expedition_date;
		this.expeditor = expeditor;
		this.state = state;
		this.nome = nome;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}