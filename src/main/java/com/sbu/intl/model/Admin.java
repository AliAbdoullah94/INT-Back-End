package com.sbu.intl.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    private String email;
    private String password;
    private String firstName;
    private String lastName;

    private String position;
    private String mobileNum;


}
