package com.sbu.intl.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@Data
public class Form {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    private Applicant applicant;
    @OneToOne
    private Response response;
    private String applyFor;
    private Date dateCreated;
    private String aboutApplicant;

    public Form(Applicant applicant, String applyFor, Date dateCreated, String aboutApplicant) {
        this.applicant = applicant;
        this.applyFor = applyFor;
        this.dateCreated = dateCreated;
        this.aboutApplicant = aboutApplicant;
    }

    public Form(Applicant applicant, Response response, String applyFor, Date dateCreated, String aboutApplicant) {
        this.applicant = applicant;
        this.response = response;
        this.applyFor = applyFor;
        this.dateCreated = dateCreated;
        this.aboutApplicant = aboutApplicant;
    }
}
