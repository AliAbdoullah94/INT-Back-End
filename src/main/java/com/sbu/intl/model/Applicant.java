package com.sbu.intl.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
@NoArgsConstructor
@Data
public class Applicant extends User {

    private Long id;

    @OneToOne
    private Form form;
    private Date birth;
    private String gender;
    private String nationality;
    private String degree;
    private String applyFor;
    private String job;
    private String aboutApplicant;

    public Applicant(Long id, String email, String password, String firstName, String lastName, Form form, Date birth, String gender, String nationality, String degree, String applyFor, String job, String aboutApplicant) {
        super(id, email, password, firstName, lastName);
        this.form = form;
        this.birth = birth;
        this.gender = gender;
        this.nationality = nationality;
        this.degree = degree;
        this.applyFor = applyFor;
        this.job = job;
        this.aboutApplicant = aboutApplicant;
    }
}
