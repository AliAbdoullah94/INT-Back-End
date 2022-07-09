package com.sbu.intl.model;

public class Response {
    private User creator;
    private Form onForm;
    private Applicant applicant;
    private boolean accepted;
    private String responseText;

    public Response(User creator, Form onForm, Applicant applicant, boolean accepted, String responseText) {
        this.creator = creator;
        this.onForm = onForm;
        this.applicant = applicant;
        this.accepted = accepted;
        this.responseText = responseText;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Form getOnForm() {
        return onForm;
    }

    public void setOnForm(Form onForm) {
        this.onForm = onForm;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public String getResponseText() {
        return responseText;
    }

    public void setResponseText(String responseText) {
        this.responseText = responseText;
    }
}
