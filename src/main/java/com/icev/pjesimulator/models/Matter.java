package com.icev.pjesimulator.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Matter {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    
    @OneToMany(mappedBy = "matter")
    @JsonIgnore
    private List<JudiciaryClasses> judiciaryClasses = new ArrayList<>();

    public Matter() {
    }

    public Matter(Long id, String description) {
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
    
	public List<JudiciaryClasses> getJudiciaryClasses() {
		return judiciaryClasses;
	}

	public void setJudiciaryClasses(List<JudiciaryClasses> judiciaryClasses) {
		this.judiciaryClasses = judiciaryClasses;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Matter matter)) return false;
        return id.equals(matter.id) && description.equals(matter.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description);
    }

    @Override
    public String toString() {
        return "Matter{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}