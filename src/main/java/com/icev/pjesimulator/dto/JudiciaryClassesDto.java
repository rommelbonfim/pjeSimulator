package com.icev.pjesimulator.dto;

import com.icev.pjesimulator.models.JudiciaryClasses;


import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class JudiciaryClassesDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private final Long id;
    private final String description;
    private Long matter_id;



	public JudiciaryClassesDto(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public JudiciaryClassesDto(JudiciaryClasses entity) {
        this.id = entity.getId();
        this.description = entity.getDescription();
        this.matter_id = entity.getMatter().getId();
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
        JudiciaryClassesDto entity = (JudiciaryClassesDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.description, entity.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description);
    }
}
