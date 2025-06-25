package com.isaiasgabriel.cruddemo;

import com.isaiasgabriel.cruddemo.dao.StudentDAO;
import com.isaiasgabriel.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner ->{
            readStudent(studentDAO);
        };
    }

    private void createStudent(StudentDAO studentDAO) {
       System.out.println("Creating new student ...");
       Student student = new Student("Paul", "Richard", "paulrichard@gmail.com");

       System.out.println("Saving the student ...");
       studentDAO.save(student);

        System.out.println("Student saved successfully. ID: " + student);
    }

    private void readStudent(StudentDAO studentDAO) {

        // create a student object
        System.out.println("Creating new student object ...");
        Student tempStudent = new Student("Daffy", "Duck", "daffy@luv2code.com");

        // save the student
        System.out.println("Saving the student ...");
        studentDAO.save(tempStudent);

        // display id of the saved student
        int studentId = tempStudent.getId();
        System.out.println("Saved student. Generated id: " + studentId);

        // retrieve student based on the id: primary key
        System.out.println("Retrieving student with id: " + studentId);
        Student myStudent = studentDAO.findById(studentId);

        // display student
        System.out.println("Found the student: " + myStudent);
    }
}
