package com.icev.pjesimulator.dto;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import com.icev.pjesimulator.models.Jurisdiction;

public class JurisdictionDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
	private final Long id;
    private final String description;
//    private List<Long> judiciaryClasses;

    public JurisdictionDto(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public JurisdictionDto(Jurisdiction entity) {
        this.id = entity.getId();
        this.description = entity.getDescription();
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
    
//	public List<Long> getJudiciaryClasses() {
//		return judiciaryClasses;
//	}
//
//	public void setJudiciaryClasses(List<Long> judiciaryClasses) {
//		this.judiciaryClasses = judiciaryClasses;
//	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JurisdictionDto entity = (JurisdictionDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.description, entity.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "description = " + description + ")";
    }
}
