package com.icev.pjesimulator.form;

import com.icev.pjesimulator.models.Jurisdiction;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class JurisdictionForm implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
	private final Long id;
    private final String description;
    private List<Long> judiciaryClasses;

    public JurisdictionForm(Long id, String description, List<Long> judiciaryClasses) {
        this.id = id;
        this.description = description;
        this.setJudiciaryClasses(judiciaryClasses);
    }

    public JurisdictionForm(Jurisdiction entity) {
        this.id = entity.getId();
        this.description = entity.getDescription();
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
    
	public List<Long> getJudiciaryClasses() {
		return judiciaryClasses;
	}

	public void setJudiciaryClasses(List<Long> judiciaryClasses) {
		this.judiciaryClasses = judiciaryClasses;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JurisdictionForm entity = (JurisdictionForm) o;
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
