package com.sbu.intl.contoller;

import com.sbu.intl.model.User;
import com.sbu.intl.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins="http://localhost:4200") // Tell spring boot to get request from 4200
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path="/users")
    public ResponseEntity<Void> addUser(@RequestBody User user) {
        userRepository.save(user);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path="/users/{id}")
    public ResponseEntity<Void> updateUser(@RequestBody User user, @PathVariable("id") Long id) {
        Optional<User> retrieved = userRepository.findById(id);
        if (retrieved.isPresent())
            userRepository.save(user);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = "/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable("id") Long id) {
        userRepository.deleteById(id);
    }

    @GetMapping(path="/users")
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping(path="/users/{id}")
    public Optional<User> getUser(@PathVariable("id") Long id) {
        return userRepository.findById(id);
    }

}
