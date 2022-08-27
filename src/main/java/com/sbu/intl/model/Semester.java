package com.sbu.intl.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@AllArgsConstructor

public class Semester {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;
    private String semesterName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Semester semester = (Semester) o;
        return id != null && Objects.equals(id, semester.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
