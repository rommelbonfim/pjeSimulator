package com.icev.pjesimulator.models;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Process {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String numProcess;

    @OneToOne
    @JoinColumn(name = "competence_id")
    private Competence competence;

    public Process() {
    }

    public Process(Long id, String numProcess, Competence competence) {
        this.id = id;
        this.numProcess = numProcess;
        this.competence = competence;
    }

    public Process(Long id, String numProcess, Competence competence, List<Subjects> subjects) {
        this.id = id;
        this.numProcess = numProcess;
        this.competence = competence;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumProcess() {
        return numProcess;
    }

    public void setNumProcess(String numProcess) {
        this.numProcess = numProcess;
    }

    public Competence getCompetence() {
        return competence;
    }

    public void setCompetence(Competence competence) {
        this.competence = competence;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Process process)) return false;
        return Objects.equals(id, process.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}