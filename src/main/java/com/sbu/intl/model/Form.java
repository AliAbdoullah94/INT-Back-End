package com.sbu.intl.model;

import java.util.Date;

public class Form {
    private Applicant applicant;
    private Response response;
    private String applyFor;
    private Date dateCreated;
    private String notes;

    public Form(Applicant applicant, String applyFor, Date dateCreated, String notes) {
        this.applicant = applicant;
        this.applyFor = applyFor;
        this.dateCreated = dateCreated;
        this.notes = notes;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public String getApplyFor() {
        return applyFor;
    }

    public void setApplyFor(String applyFor) {
        this.applyFor = applyFor;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
