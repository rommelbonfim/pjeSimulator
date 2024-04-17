package com.icev.pjesimulator.dto;

import com.icev.pjesimulator.models.Matter;
import com.icev.pjesimulator.models.Subjects;

import java.io.Serializable;
import java.util.Objects;

public class SubjectsDto implements Serializable {
    private final Long id;
    private final Long codigo;
    private final String complement;

    public SubjectsDto(Long id, Long codigo, String complement) {
        this.id = id;
        this.codigo = codigo;
        this.complement = complement;
    }
    public SubjectsDto(Subjects entity) {
        this.id = entity.getId();
        this.codigo = entity.getCodigo();
        this.complement = entity.getComplement();
    }

    public Long getId() {
        return id;
    }

    public Long getCodigo() {
        return codigo;
    }

    public String getComplement() {
        return complement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubjectsDto entity = (SubjectsDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.codigo, entity.codigo) &&
                Objects.equals(this.complement, entity.complement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codigo, complement);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "codigo = " + codigo + ", " +
                "complement = " + complement + ")";
    }
}
