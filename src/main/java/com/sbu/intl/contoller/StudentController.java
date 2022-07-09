package com.sbu.intl.contoller;

import com.sbu.intl.model.Student;
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

    @PostMapping(path="/students")
    public ResponseEntity<Void> addStudent(@RequestBody Student student) {
        studentRepository.save(student);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path="/students/{id}")
    public ResponseEntity<Void> updateStudent(@RequestBody Student student, @PathVariable("id") Long id) {
        Optional<Student> retrieved = studentRepository.findById(id);
        if (retrieved.isPresent())
            studentRepository.save(student);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = "/students/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudent(@PathVariable("id") Long id) {
        studentRepository.deleteById(id);
    }

    @GetMapping(path="/students")
    public Iterable<Student> getStudents() {
        return studentRepository.findAll();
    }

    @GetMapping(path="/students/{id}")
    public Optional<Student> getStudent(@PathVariable("id") Long id) {
        return studentRepository.findById(id);
    }

}

