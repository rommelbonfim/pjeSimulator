package com.icev.pjesimulator.models;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.icev.pjesimulator.enums.AttorneyType;
import com.icev.pjesimulator.enums.PersonType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Attorney {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @Enumerated(EnumType.STRING)
    private AttorneyType type;

    public Attorney(){

    }

    public Attorney(Long id, Person person, AttorneyType type) {
        this.id = id;
        this.person = person;
        this.setType(type);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public AttorneyType getType() {
        return type;
    }

    public void setType(AttorneyType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attorney attorney = (Attorney) o;
        return Objects.equals(id, attorney.id);
    }

}

