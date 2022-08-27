package com.sbu.intl.contoller;

import com.sbu.intl.model.Semester;
import com.sbu.intl.service.SemesterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins="http://localhost:4200") // Tell spring boot to get request from 4200
public class SemesterController {

    @Autowired
    private SemesterRepository semesterRepository;

    @PostMapping(path="/semesters")
    public ResponseEntity<Void> addSemester(@RequestBody Semester semester) {
        Semester created = semesterRepository.save(semester);
        return new ResponseEntity(created.getId(), HttpStatus.OK);
    }

    @PutMapping(path="/semesters/{id}")
    public ResponseEntity<Void> updateSemester(@RequestBody Semester semester, @PathVariable("id") Long id) {
        Optional<Semester> retrieved = semesterRepository.findById(id);
        if (retrieved.isPresent())
            semesterRepository.save(semester);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = "/semesters/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteSemester(@PathVariable("id") Long id) {
        semesterRepository.deleteById(id);
    }

    @GetMapping(path="/semesters")
    public Iterable<Semester> getSemesters() {
        return semesterRepository.findAll();
    }

    @GetMapping(path="/semesters/{id}")
    public Optional<Semester> getSemester(@PathVariable("id") Long id) {
        return semesterRepository.findById(id);
    }

}

