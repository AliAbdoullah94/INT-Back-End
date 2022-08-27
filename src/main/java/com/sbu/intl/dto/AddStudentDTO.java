package com.sbu.intl.dto;

public class AddStudentDTO {
    private long applicantId;
    private String stId;



    public long getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(long applicantId) {
        this.applicantId = applicantId;
    }

    public String getStId() {
        return stId;
    }

    public void setStId(String stId) {
        this.stId = stId;
    }
}
