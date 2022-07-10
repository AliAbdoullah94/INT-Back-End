package com.sbu.intl.model;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@NoArgsConstructor
public class Applicant extends User {

    private Long id;

//    private Form form;
    private Date date;
    private Gender gender;
    private String nationality;

    public Applicant(String email, String password, String nationality) {
        super(email, password);
        this.nationality = nationality;
    }

    //    public Applicant(String email, String password, Form form, Date date, Gender gender, String nationality) {
//        super(email, password);
//        this.form = form;
//        this.date = date;
//        this.gender = gender;
//        this.nationality = nationality;
//    }
//
//    public Form getForm() {
//        return form;
//    }
//
//    public void setForm(Form form) {
//        this.form = form;
//    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}

enum Gender {
    MALE,FEMALE
}
