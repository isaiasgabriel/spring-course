package com.isaiasgabriel.rest_demo.rest;

import com.isaiasgabriel.rest_demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @GetMapping("/students")
    public List<Student> getStudents() {

        List<Student> students = new ArrayList<>();

        students.add(new Student("Alexander", "Volkanovski"));
        students.add(new Student("Alex", "Poatan"));
        students.add(new Student("Kai-kara", "France"));
        students.add(new Student("Zabit", "Magomedsharipov"));

        return students;
    }
}
