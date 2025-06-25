package com.isaiasgabriel.cruddemo;

import com.isaiasgabriel.cruddemo.dao.StudentDAO;
import com.isaiasgabriel.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner ->{
            // queryForStudents(studentDAO);

            //queryForStudentsByFirstName(studentDAO);

            // updateStudent(studentDAO);

            // deleteStudent(studentDAO);

            deleteAllStudents(studentDAO);
        };
    }

    private void deleteAllStudents(StudentDAO studentDAO) {
        int numRowsDeleted =  studentDAO.deleteAll();
        System.out.println("Number of rows deleted: " + numRowsDeleted);

        queryForStudents(studentDAO);

    }

    private void deleteStudent(StudentDAO studentDAO) {

        int studentId = 3;
        System.out.println("Deleting student with id " + studentId);
        studentDAO.delete(studentId);
        System.out.println("Deleted student with id " + studentId);

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

    private void queryForStudents(StudentDAO studentDAO) {
        List<Student> students = studentDAO.findAll();

        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void queryForStudentsByFirstName(StudentDAO studentDAO) {
        List<Student> students = studentDAO.findByName("Paul");

        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void updateStudent(StudentDAO studentDAO) {
        // Retrieve student based on the id
        int studentId = 1;
        System.out.println("Getting student with id: " + studentId);
        Student myStudent = studentDAO.findById(studentId);

        // Update Student
        System.out.println("Updating student with id: " + studentId);
        myStudent.setFirstName("Scooby");
        myStudent.setLastName("Doo");
        myStudent.setEmail("scooby@doo.com");

        // Update te student
        studentDAO.update(myStudent);

        // Display the updated student
        System.out.println("Updated student: " + myStudent);
    }
}
