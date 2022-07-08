package com.sbu.intl.model;

import com.sbu.intl.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Student extends User {

    private long st_ID;
    private String section;
    private String degree;
    private String nationality;

    public Student(String email, String password, long st_ID, String section, String degree, String nationality) {
        super(email, password);
        this.st_ID = st_ID;
        this.section = section;
        this.degree = degree;
        this.nationality = nationality;
    }

    public long getSt_ID() {
        return st_ID;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
