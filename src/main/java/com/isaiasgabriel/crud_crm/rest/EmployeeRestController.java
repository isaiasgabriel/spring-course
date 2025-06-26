package com.isaiasgabriel.crud_crm.rest;

import com.isaiasgabriel.crud_crm.dao.EmployeeDAO;
import com.isaiasgabriel.crud_crm.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeDAO employeeDAO;

    // NOT RECOMMENDED SOLUTION: inject employee dao directly
    // TODO: Refactor this solution later
    @Autowired
    public EmployeeRestController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    // Expose "/employees" endpoint
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return  employeeDAO.findAll();
    }
}
