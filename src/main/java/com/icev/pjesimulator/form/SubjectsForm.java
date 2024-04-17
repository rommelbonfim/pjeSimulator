package com.icev.pjesimulator.form;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class SubjectsForm implements Serializable {
    private final Long id;
    private final Long codigo;
    private final String complement;
    private List<Long> process;

    public SubjectsForm(Long id, Long codigo, String complement, List<Long> process) {
        this.id = id;
        this.codigo = codigo;
        this.complement = complement;
        this.process = process;
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

    public List<Long> getProcess() {
        return process;
    }

    public void setProcess(List<Long> process) {
        this.process = process;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubjectsForm that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
