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

    @Override
    public Employee findById(int id) {
        // 1. Get employee
        // Employee employee = entityManager.find(Employee.class, id);
        // 2. Return employee:
        // return employee;
        //
        // Same as:
        return entityManager.find(Employee.class, id);
    }

    @Override
    public Employee save(Employee employee) {
        // 1. Save employee:
        // Employee dbEmployee = entityManager.merge(employee);
        //
        // if id == 0 then INSERT
        // if id != 0 then UPDATE
        //
        // 2. Return the employee
        // return dbEmployee;
        //
        // Same as:
        return entityManager.merge(employee);
    }

    @Override
    public void deleteById(int id) {
        // 1. Find the employee:
        // Employee employee = entityManager.find(Employee.class, id);
        //
        // 2. Delete the employee:
        // entityManager.remove(employee);
        //
        // Same as:
        entityManager.remove(entityManager.find(Employee.class, id));
    }
}
