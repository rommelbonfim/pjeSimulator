package com.icev.pjesimulator.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import com.icev.pjesimulator.models.Process;
import com.icev.pjesimulator.models.Subjects;

public class ProcessDto implements Serializable {
    private static final long serialVersionUID = 1L;
	private final Long id;
    private final String numProcess;
    private final Long competence;

    public ProcessDto(Long id, String numProcess, Long competence) {
        this.id = id;
        this.numProcess = numProcess;
        this.competence = competence;
    }

    public ProcessDto(Process entity) {
        this.id = entity.getId();
        this.numProcess = entity.getNumProcess();
        this.competence = entity.getCompetence().getId();
    }

    public ProcessDto(Process entity, Set<Subjects> subjects) {
        this(entity);
    }

    public Long getId() {
        return id;
    }

    public String getNumProcess() {
        return numProcess;
    }

    public Long getCompetence() {
        return competence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProcessDto entity = (ProcessDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.numProcess, entity.numProcess);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numProcess);
    }

    @Override
    public String toString() {
        return "ProcessDto{" +
                "id=" + id +
                ", numProcess=" + numProcess +
                ", competence=" + competence +
                '}';
    }
}
