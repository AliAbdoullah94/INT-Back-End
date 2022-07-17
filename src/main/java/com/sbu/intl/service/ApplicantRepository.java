package com.sbu.intl.service;

import com.sbu.intl.model.Applicant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantRepository extends CrudRepository<Applicant, Long> {

    Applicant findByEmail(String email);

}
