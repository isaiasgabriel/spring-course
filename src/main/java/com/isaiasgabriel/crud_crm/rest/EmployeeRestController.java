package com.isaiasgabriel.crud_crm.rest;

import com.isaiasgabriel.crud_crm.dao.EmployeeDAO;
import com.isaiasgabriel.crud_crm.entity.Employee;
import com.isaiasgabriel.crud_crm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Expose "/employees" endpoint
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return  employeeService.findAll();
    }
}
