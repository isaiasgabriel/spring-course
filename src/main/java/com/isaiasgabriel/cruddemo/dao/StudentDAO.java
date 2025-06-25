package com.isaiasgabriel.cruddemo.dao;

import com.isaiasgabriel.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save (Student student);

    Student findById (Integer id);

    List<Student> findAll();

    List<Student> findByName(String name);
}
