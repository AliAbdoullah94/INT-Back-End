package com.sbu.intl.service;

import com.sbu.intl.model.Admin;
import com.sbu.intl.model.Semester;
import org.springframework.data.repository.CrudRepository;

public interface SemesterRepository extends CrudRepository<Semester, Long> {
}
