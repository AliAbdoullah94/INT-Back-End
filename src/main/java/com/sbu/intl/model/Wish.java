package com.sbu.intl.model;

public class Wish {
    private String faculty;
    private String department;

    public Wish(String faculty, String department) {
        this.faculty = faculty;
        this.department = department;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
