package com.sbu.intl.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Form form = (Form) o;
        return id != null && Objects.equals(id, form.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
