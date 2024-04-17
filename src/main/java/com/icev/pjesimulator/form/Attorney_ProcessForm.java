package com.icev.pjesimulator.form;

public class Attorney_ProcessForm {

    private Long attorneyId;
    private Long processId;

    public Attorney_ProcessForm() {

    }

    public Attorney_ProcessForm(Long attorneyId, Long processId) {
        super();
        this.attorneyId = attorneyId;
        this.processId = processId;

    }

    public Long getAttorneyId() {
        return attorneyId;
    }

    public void setAttorneyId(Long attorneyId) {
        this.attorneyId = attorneyId;
    }

    public Long getProcessId() {
        return processId;
    }

    public void setProcessId(Long processId) {
        this.processId = processId;
    }
}
