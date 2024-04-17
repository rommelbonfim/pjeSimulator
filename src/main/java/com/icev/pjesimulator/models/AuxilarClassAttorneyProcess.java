package com.icev.pjesimulator.models;

import javax.persistence.*;

@Entity
public class AuxilarClassAttorneyProcess {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "attorney_id")
    private Attorney attorney;

    @OneToOne
    @JoinColumn(name = "process_id")
    private Process process;

    public AuxilarClassAttorneyProcess(Attorney attorney, Process process) {
        this.attorney = attorney;
        this.process = process;
    }

    public AuxilarClassAttorneyProcess() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Attorney getAttorney() {
        return attorney;
    }

    public void setAttorney(Attorney attorney) {
        this.attorney = attorney;
    }

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }
}


