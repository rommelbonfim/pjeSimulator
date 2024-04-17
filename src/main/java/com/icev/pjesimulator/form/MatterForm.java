package com.icev.pjesimulator.form;

import com.icev.pjesimulator.models.JudiciaryClasses;
import com.icev.pjesimulator.models.Matter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class MatterForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private final Long id;
    private final String description;
    private List<JudiciaryClasses> judiciaryClasses;


	public MatterForm(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public MatterForm(Matter entity) {
        this.id = entity.getId();
        this.description = entity.getDescription();
        this.judiciaryClasses = entity.getJudiciaryClasses();
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
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
        if (o == null || getClass() != o.getClass()) return false;
        MatterForm entity = (MatterForm) o;
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
