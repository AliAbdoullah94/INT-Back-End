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

    @ManyToOne
    private Admin admin;

    private Date dateCreated;

    @ManyToOne
    private Response response;

    public Log(String logType, Applicant applicant, Date dateCreated) {
        this.logType = logType;
        this.applicant = applicant;
        this.dateCreated = dateCreated;
    }

    public Log(String logType, Applicant applicant, Response response, Date dateCreated) {
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
