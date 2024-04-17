package com.icev.pjesimulator.dto;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import com.icev.pjesimulator.models.JudiciaryClasses;
import com.icev.pjesimulator.models.Matter;

public class MatterDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private final Long id;
    private final String description;


	public MatterDto(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public MatterDto(Matter entity) {
        this.id = entity.getId();
        this.description = entity.getDescription();
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
    

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatterDto entity = (MatterDto) o;
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
