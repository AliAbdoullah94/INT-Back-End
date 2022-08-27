package com.sbu.intl.contoller;

import com.sbu.intl.model.Course;
import com.sbu.intl.service.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins="http://localhost:4200") // Tell spring boot to get request from 4200
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @PostMapping(path="/courses")
    public ResponseEntity<Void> addCourse(@RequestBody Course course) {
        courseRepository.save(course);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path="/courses/{id}")
    public ResponseEntity<Void> updateCourse(@RequestBody Course course, @PathVariable("id") Long id) {
        Optional<Course> retrieved = courseRepository.findById(id);
        if (retrieved.isPresent())
            courseRepository.save(course);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = "/courses/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCourse(@PathVariable("id") Long id) {
        courseRepository.deleteById(id);
    }

    @GetMapping(path="/courses")
    public Iterable<Course> getCourses() {
        return courseRepository.findAll();
    }

    @GetMapping(path="/courses/{id}")
    public Optional<Course> getCourse(@PathVariable("id") Long id) {
        return courseRepository.findById(id);
    }

}

