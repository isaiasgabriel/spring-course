package com.isaiasgabriel.crud_crm.service;

import com.isaiasgabriel.crud_crm.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);

}
