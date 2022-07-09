package com.sbu.intl.contoller;

import com.sbu.intl.model.Applicant;
import com.sbu.intl.service.ApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins="http://localhost:4200") // Tell spring boot to get request from 4200
public class ApplicantController {

    @Autowired
    private ApplicantRepository applicantRepository;

    @PostMapping(path = "/applicants")
    public ResponseEntity<Void> addApplicant(@RequestBody Applicant applicant) {
        applicantRepository.save(applicant);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/applicants/{id}")
    public ResponseEntity<Void> updateApplicant(@RequestBody Applicant applicant, @PathVariable("id") Long id) {
        Optional<Applicant> retrieved = applicantRepository.findById(id);
        if (retrieved != null)
            applicantRepository.save(applicant);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = "/applicants/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteApplicant(@PathVariable("id") Long id) {
        applicantRepository.deleteById(id);
    }

    @GetMapping(path = "/applicants")
    public Iterable<Applicant> getApplicants() {
        return applicantRepository.findAll();
    }

    @GetMapping(path = "/applicants/{id}")
    public Applicant getApplicant(@PathVariable("id") Long id) {
        return applicantRepository.findById(id).orElse(null);
    }
}

