package com.sbu.intl.contoller;

import com.sbu.intl.model.Admin;
import com.sbu.intl.service.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins="http://localhost:4200") // Tell spring boot to get request from 4200
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;

    @PostMapping(path="/admins")
    public ResponseEntity<Void> addAdmin(@RequestBody Admin admin) {
        adminRepository.save(admin);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path="/admins/{id}")
    public ResponseEntity<Void> updateAdmin(@RequestBody Admin admin, @PathVariable("id") Long id) {
        Optional<Admin> retrieved = adminRepository.findById(id);
        if (retrieved.isPresent())
            adminRepository.save(admin);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = "/admins/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAdmin(@PathVariable("id") Long id) {
        adminRepository.deleteById(id);
    }

    @GetMapping(path="/admins")
    public Iterable<Admin> getAdmins() {
        return adminRepository.findAll();
    }

    @GetMapping(path="/admins/{id}")
    public Optional<Admin> getAdmin(@PathVariable("id") Long id) {
        return adminRepository.findById(id);
    }

}

