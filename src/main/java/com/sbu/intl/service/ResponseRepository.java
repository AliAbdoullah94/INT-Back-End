package com.sbu.intl.service;

import com.sbu.intl.model.Applicant;
import com.sbu.intl.model.Form;
import com.sbu.intl.model.Response;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponseRepository extends CrudRepository<Response,Long> {
    @Query("SELECT r FROM Response r WHERE r.applicant = ?1")
    Response findByApplicant(Applicant applicant);
}
