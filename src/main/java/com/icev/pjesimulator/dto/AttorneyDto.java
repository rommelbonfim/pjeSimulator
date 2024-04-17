package com.icev.pjesimulator.dto;


import com.icev.pjesimulator.enums.AttorneyType;
import com.icev.pjesimulator.models.Attorney;
import com.icev.pjesimulator.models.Person;
import com.icev.pjesimulator.models.Process;
import com.icev.pjesimulator.models.Subjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AttorneyDto {

    private long id;

    private long personId;
    private String type;

    public AttorneyDto(Long id){

    }

    public AttorneyDto(Attorney entity) {
        this.id = entity.getId();
        this.personId = entity.getPerson().getId();
        this.type = AttorneyType.toString(entity.getType());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
