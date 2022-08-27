package com.sbu.intl.contoller;

import com.sbu.intl.dto.AddStudentDTO;
import com.sbu.intl.model.Applicant;
import com.sbu.intl.model.Student;
import com.sbu.intl.service.ApplicantRepository;
import com.sbu.intl.service.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins="http://localhost:4200") // Tell spring boot to get request from 4200
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ApplicantRepository applicantRepository;

    @PostMapping(path="/students")
    public ResponseEntity<Void> addStudent(@RequestBody AddStudentDTO input) {

        Applicant applicant = applicantRepository.findById(input.getApplicantId()).orElseThrow();
        //todo: Check if applicant is already a student
        // add applicatedId to student when creating it
        // check  if StudentRepository.findByApllicantId returns something
        // if yes throw studentExistException
        Student student = new Student(applicant, input.getStId());
        studentRepository.save(student);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = "/students/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudent(@PathVariable("id") String id) {
        studentRepository.deleteById(id);
    }

    @GetMapping(path="/students")
    public Iterable<Student> getStudents() {
        return studentRepository.findAll();
    }

    @GetMapping(path="/students/{id}")
    public Optional<Student> getStudent(@PathVariable("id") String id) {
        return studentRepository.findById(id);
    }

}

