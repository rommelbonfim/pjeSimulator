package com.icev.pjesimulator.form;

public class AttorneyForm {

    private long personId;
    private String type;

    public AttorneyForm() {
    }

    public AttorneyForm( Long personId, String type) {
        this.personId = personId;
        this.type = type;
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
