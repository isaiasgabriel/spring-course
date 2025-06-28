package com.isaiasgabriel.rest_demo.rest;

import com.isaiasgabriel.rest_demo.entity.Student;
import com.isaiasgabriel.rest_demo.rest.error.StudentErrorResponse;
import com.isaiasgabriel.rest_demo.rest.exception.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    // Declare students list
    private List<Student> students;

    // @PostConstruct executes once after it's created by spring
    @PostConstruct
    public void loadData() {
        // Initialize students list
        // Using this.students is optional here because there's no name conflict
        // So we're cleary referring to the students attribute above
        students = new ArrayList<>();

        students.add(new Student("Alexander", "Volkanovski"));
        students.add(new Student("Alex", "Poatan"));
        students.add(new Student("Kai-kara", "France"));
        students.add(new Student("Zabit", "Magomedsharipov"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/students/{studentId}") // Path Variable
    public Student getStudent(@PathVariable Integer studentId) {

        // Throw an Exception is user is not found
        if((studentId >= students.size()) || (studentId < 0)) {
            throw new StudentNotFoundException("Student id not found: " + studentId);
        }

        return students.get(studentId);
    }
}
