package com.isaiasgabriel.cruddemo.dao;

import com.isaiasgabriel.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save (Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById (Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        // create query
        // TypedQuery<Student> query = entityManager.createQuery("FROM Student", Student.class);
        TypedQuery<Student> query = entityManager.createQuery("FROM Student", Student.class);
        // return query results
        return query.getResultList();
    }

    @Override
    public List<Student> findByName(String name) {
        // Create query
        TypedQuery<Student> query = entityManager
                .createQuery("FROM Student WHERE firstName= :name", Student.class);

        // Set Query Parameters
        query.setParameter("name", name);

        // Return Query Results
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update (Student student) {
        entityManager.merge(student);
    }
}
