package com.sbu.intl.service;

import com.sbu.intl.model.Applicant;
import com.sbu.intl.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantRepository extends UserRepository<Applicant> {


}
