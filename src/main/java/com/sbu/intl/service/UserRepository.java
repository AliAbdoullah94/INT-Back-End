package com.sbu.intl.service;

import com.sbu.intl.model.User;
import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public interface UserRepository<T extends User> extends CrudRepository<T, Long> {

    T findByEmail(String email);
}

