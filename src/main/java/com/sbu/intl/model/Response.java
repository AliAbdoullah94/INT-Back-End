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
public class Response {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    private Form onForm;
    @OneToOne
    private Applicant applicant;
    private boolean accepted;
    private String responseText;
    private Date dateCreated;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Response response = (Response) o;
        return id != null && Objects.equals(id, response.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
