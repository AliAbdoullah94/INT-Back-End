package com.sbu.intl.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Builder
@AllArgsConstructor
public class Student {

    @Id
    @Column(name = "st_id", nullable = false)
    private String stID;

    @OneToMany
    @JoinColumn(name = "st_id")
    @JsonIgnore
    @ToString.Exclude
    private List<Grade> grades=List.of();

    private Date entranceYear;
    @Transient
    private int unitsPassed = 0;
    private boolean limited;
    @Transient
    private double gpa;

    private long applicantId;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String mobile;
    private String gender;

    private String passCountry;
    private String passNumber;
    private Date passExpiry;

    public void addGrade(Grade grade){
        grades.add(grade);
    }

    public Student(Applicant applicant, String stID) {
        this.stID = stID;
        this.applicantId = applicant.getId();
        this.email = applicant.getEmail();
        this.password = applicant.getPassword();
        this.firstName = applicant.getFirstName();
        this.lastName = applicant.getLastName();
        this.mobile = applicant.getMobile();
        this.gender = applicant.getGender();
        this.passCountry = applicant.getPassCountry();
        this.passNumber = applicant.getPassNumber();
        this.passExpiry = applicant.getPassExpiry();
    }

    public int getUnitsPassed() {
        int sum = 0;
        for (Grade grade : grades) {
            if (grade.getGrade() >= 10) {
                sum += grade.getCourse().getUnits();
            }
        }
        return sum;
    }

    public int getGpa() {
        int gpa = 0;
        int allUnits = 0;
        for (Grade grade : grades) {
            gpa += grade.getGrade() * grade.getCourse().getUnits();
            allUnits += grade.getCourse().getUnits();
        }
        if (allUnits == 0)
            return 0;
        gpa /= allUnits;
        return gpa;
    }


    public Map<String, Map<String, Double>> getGradesMap() {
        Map<String, Map<String, Double>> result = new HashMap<>();
        for (Grade grade : grades) {
            Map<String, Double> courseMap = result.computeIfAbsent(grade.getCourse().getCourseName(), ignored -> new HashMap<>());
            courseMap.put(grade.getSemester().getSemesterName(), grade.getGrade());
        }

        return result;
    }
}
