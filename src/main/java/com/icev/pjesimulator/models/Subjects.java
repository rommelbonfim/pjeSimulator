package com.icev.pjesimulator.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Subjects {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long codigo;
    private String complement;

    public Subjects() {
    }

    public Subjects(Long id, Long codigo, String complement) {
        this.id = id;
        this.codigo = codigo;
        this.complement = complement;
    }

    public Subjects(Long id, Long codigo, String complement, List<Process> process) {
        this.id = id;
        this.codigo = codigo;
        this.complement = complement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }
}