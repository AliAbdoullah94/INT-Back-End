package com.sbu.intl.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Applicant {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    private String email;
    private String password;
    private String firstName;
    private String lastName;


    @OneToOne
    private Form form;
    private Date birth;
    private String gender;
    private String nationality;
    private String degree;
    private String applyFor;
    private String job;
    private String aboutApplicant;

    public Applicant(String email, String password, String firstName, String lastName) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void update(Applicant applicant) {
        this.setBirth(applicant.getBirth());
        this.setGender(applicant.getGender());
        this.setNationality(applicant.getNationality());
        this.setDegree(applicant.getDegree());
        this.setApplyFor(applicant.getAboutApplicant());
        this.setJob(applicant.getJob());
        this.setAboutApplicant(applicant.getAboutApplicant());
    }

    public Applicant(String email, String password, String firstName, String lastName, Form form, Date birth, String gender, String nationality, String degree, String applyFor, String job, String aboutApplicant) {
        this(email, password, firstName, lastName);
        this.form = form;
        this.birth = birth;
        this.gender = gender;
        this.nationality = nationality;
        this.degree = degree;
        this.applyFor = applyFor;
        this.job = job;
        this.aboutApplicant = aboutApplicant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getApplyFor() {
        return applyFor;
    }

    public void setApplyFor(String applyFor) {
        this.applyFor = applyFor;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getAboutApplicant() {
        return aboutApplicant;
    }

    public void setAboutApplicant(String aboutApplicant) {
        this.aboutApplicant = aboutApplicant;
    }
}
