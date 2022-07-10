package com.sbu.intl.service;

import com.sbu.intl.model.Form;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormRepository extends CrudRepository<Form,Long> {
}
