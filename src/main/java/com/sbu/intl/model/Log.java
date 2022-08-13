package com.sbu.intl.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String logType;

    @ManyToOne
    private Applicant applicant;

    private Date dateCreated;

    @ManyToOne
    private Form form;

    @ManyToOne
    private Response response;

    //SignUp Log Constructor
    public Log(String logType, Applicant applicant, Date dateCreated) {
        this.logType = logType;
        this.applicant = applicant;
        this.dateCreated = dateCreated;
    }

    //Apply Log Constructor
    public Log(String logType, Applicant applicant, Form form, Date dateCreated) {
        this.logType = logType;
        this.applicant = applicant;
        this.form = form;
        this.dateCreated = dateCreated;
    }

    //Response Log Constructor
    public Log(String logType, Applicant applicant, Response form, Date dateCreated) {
        this.logType = logType;
        this.applicant = applicant;
        this.response = response;
        this.dateCreated = dateCreated;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Log log = (Log) o;
        return id != null && Objects.equals(id, log.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
