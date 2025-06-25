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
            createStudent(studentDAO);
        };
    }

    private void createStudent(StudentDAO studentDAO) {
       System.out.println("Creating new student ...");
       Student student = new Student("Paul", "Richard", "paulrichard@gmail.com");

       System.out.println("Saving the student ...");
       studentDAO.save(student);

        System.out.println("Student saved successfully. ID: " + student);


    }
}
