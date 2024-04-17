package com.icev.pjesimulator.models;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class JudiciaryClasses {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "matter_id")
    @JsonIgnore
    private Matter matter;
    

    public JudiciaryClasses() {
    }

    public JudiciaryClasses(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
	public Matter getMatter() {
		return matter;
	}

	public void setMatter(Matter matter) {
		this.matter = matter;
	}
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JudiciaryClasses judiciaryClasses)) return false;
        return id.equals(judiciaryClasses.id) && description.equals(judiciaryClasses.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description);
    }
}
