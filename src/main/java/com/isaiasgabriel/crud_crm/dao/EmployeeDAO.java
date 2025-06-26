package com.isaiasgabriel.crud_crm.dao;

import com.isaiasgabriel.crud_crm.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
