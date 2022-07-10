package com.sbu.intl.service;

import com.sbu.intl.model.Response;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponseRepository extends CrudRepository<Response,Long> {
}
