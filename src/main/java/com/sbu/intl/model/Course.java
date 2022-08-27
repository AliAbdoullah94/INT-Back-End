package com.sbu.intl.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Builder
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    private String courseName;
    private String description;
    private int units;

//    @OneToMany
//    @JoinColumn(name = "course_id")
//    private List<Grade> grades=List.of();


}
