package com.sbu.intl.service;

import com.sbu.intl.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {


    User findByEmail(String email);

    User getById(long id);
}

