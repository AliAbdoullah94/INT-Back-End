package com.sbu.intl.dto;

import com.sbu.intl.model.Applicant;
import com.sbu.intl.model.Response;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

public class FormDTO {

    private Long id;

    private Long applicant;

    private Response response;
    private String applyFor;
    private Date dateCreated;
    private String notes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public FormDTO(Long applicant, String applyFor, Date dateCreated, String notes) {
        this.applicant = applicant;
        this.applyFor = applyFor;
        this.dateCreated = dateCreated;
        this.notes = notes;
    }

    public Long getApplicant() {
        return applicant;
    }

    public void setApplicant(Long applicant) {
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
