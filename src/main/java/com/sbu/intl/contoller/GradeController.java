package com.sbu.intl.contoller;

import com.sbu.intl.dto.GradeDto;
import com.sbu.intl.model.Course;
import com.sbu.intl.model.Grade;
import com.sbu.intl.model.Semester;
import com.sbu.intl.model.Student;
import com.sbu.intl.service.CourseRepository;
import com.sbu.intl.service.GradeRepository;
import com.sbu.intl.service.SemesterRepository;
import com.sbu.intl.service.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200") // Tell spring boot to get request from 4200
public class GradeController {

    @Autowired
    private GradeRepository gradeRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private SemesterRepository semesterRepository;

    @PostMapping(path = "/grades")
    public ResponseEntity<String> addGrades(@RequestBody GradeDto gradeDto) {
        Course course = courseRepository.findById(gradeDto.getCourseId()).orElseThrow();
        Semester semester = semesterRepository.findById(gradeDto.getSemesterId()).orElseThrow();
        List<Grade> grades = new ArrayList<>();
        List<String> notFoundStudentIds = new ArrayList<>();
        for (Map.Entry<String, Double> entry : gradeDto.getGrades().entrySet()) {
            Optional<Student> studentOptional = studentRepository.findById(entry.getKey());
            if (studentOptional.isPresent()) {
                Grade grade = new Grade(studentOptional.get(), course, semester, entry.getValue());
                grades.add(grade);
            } else {
                notFoundStudentIds.add(entry.getKey());
            }
        }

        gradeRepository.saveAll(grades);
        if (notFoundStudentIds.isEmpty()) {
            return ResponseEntity.ok("all grades added");
        } else {
            return ResponseEntity.ok("Following studentIds were not found:"
                    + notFoundStudentIds.stream().collect(Collectors.joining(",")));
        }
    }

    @PutMapping(path = "/grades/{id}")
    public ResponseEntity<Void> updateGrade(@RequestBody Grade grade, @PathVariable("id") Long id) {
        Optional<Grade> retrieved = gradeRepository.findById(id);
        if (retrieved.isPresent())
            gradeRepository.save(grade);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = "/grades/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteGrade(@PathVariable("id") Long id) {
        gradeRepository.deleteById(id);
    }

    @GetMapping(path = "/grades")
    public Iterable<Grade> getGrades() {
        return gradeRepository.findAll();
    }

    @GetMapping(path = "/grades/{id}")
    public Optional<Grade> getGrade(@PathVariable("id") Long id) {
        return gradeRepository.findById(id);
    }

}

