package com.sbu.intl.contoller;

import com.sbu.intl.model.Applicant;
import com.sbu.intl.service.ApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class ApplicantController {

    @Autowired
    private ApplicantRepository applicantRepository;

    @PostMapping(path = "/applicants")
    public ResponseEntity<Void> addApplicant(@RequestBody Applicant applicant) {
        applicantRepository.save(applicant);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/applicants/{email}")
    public ResponseEntity<Void> updateApplicant(@RequestBody Applicant applicant, @PathVariable("email") String email) {
//        Optional<Applicant> retrieved = Optional.ofNullable(applicantRepository.findByEmail(email));
        Applicant retrieved = applicantRepository.findByEmail(email);
        retrieved.update(applicant);
//        if (retrieved.isPresent())
//            applicantRepository.save(applicant);
        applicantRepository.save(retrieved);
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

