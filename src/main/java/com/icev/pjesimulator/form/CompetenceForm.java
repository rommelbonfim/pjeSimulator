package com.icev.pjesimulator.form;

public class CompetenceForm {

    private Long jurisdictionId;
    private Long judiciaryClassId;

    public CompetenceForm() {

    }

    public CompetenceForm(Long jurisdictionId, Long judiciaryClassId, Long process) {
        super();
        this.jurisdictionId = jurisdictionId;
        this.judiciaryClassId = judiciaryClassId;

    }

    public Long getJurisdictionId() {
        return jurisdictionId;
    }

    public void setJurisdictionId(Long jurisdictionId) {
        this.jurisdictionId = jurisdictionId;
    }

    public Long getJudiciaryClassId() {
        return judiciaryClassId;
    }

    public void setJudiciaryClassId(Long judiciaryClassId) {
        this.judiciaryClassId = judiciaryClassId;
    }


}
