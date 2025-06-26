package com.isaiasgabriel.crud_crm.dao;

import com.isaiasgabriel.crud_crm.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    // Define field for entity manager
    private EntityManager entityManager;

    // Setup constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Employee> findAll() {

        // Create a query
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);

        // Execute query and get result list
        List<Employee> employees = query.getResultList();

        // Return the results
        return employees;
    }
}
