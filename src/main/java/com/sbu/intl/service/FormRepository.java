package com.sbu.intl.service;

import com.sbu.intl.model.Applicant;
import com.sbu.intl.model.Form;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormRepository extends CrudRepository<Form,Long> {
    @Query("SELECT f FROM Form f WHERE f.applicant = ?1")
    Form findByApplicant(Applicant applicant);
}
