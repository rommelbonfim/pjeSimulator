package com.icev.pjesimulator.models;

import java.util.Objects;

import javax.persistence.*;

@Entity
public class Competence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "judiciary_class_id")
    private JudiciaryClasses judiciaryClass;

    @OneToOne
    @JoinColumn(name = "jurisdiction_id")
    private Jurisdiction jurisdiction;


    public Competence() {

    }

    public Competence(Long id, JudiciaryClasses judiciaryClass, Jurisdiction jurisdiction) {
        super();
        this.id = id;
        this.judiciaryClass = judiciaryClass;
        this.jurisdiction = jurisdiction;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public JudiciaryClasses getJudiciaryClass() {
        return judiciaryClass;
    }

    public void setJudiciaryClass(JudiciaryClasses judiciaryClass) {
        this.judiciaryClass = judiciaryClass;
    }

    public Jurisdiction getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(Jurisdiction jurisdiction) {
        this.jurisdiction = jurisdiction;
    }
    

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Competence other = (Competence) obj;
        return Objects.equals(id, other.id);
    }
}
