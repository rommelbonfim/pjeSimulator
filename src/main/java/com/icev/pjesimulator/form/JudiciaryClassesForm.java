package com.icev.pjesimulator.form;

import com.icev.pjesimulator.models.JudiciaryClasses;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class JudiciaryClassesForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private final Long id;
    private final String description;
    private Long matter_id;



	public JudiciaryClassesForm(Long id, String description, Long matter_id) {
        this.id = id;
        this.description = description;
        this.setMatter_id(matter_id);
    }



    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
    
	public Long getMatter_id() {
		return matter_id;
	}

	public void setMatter_id(Long matter_id) {
		this.matter_id = matter_id;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JudiciaryClassesForm entity = (JudiciaryClassesForm) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.description, entity.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description);
    }
}
