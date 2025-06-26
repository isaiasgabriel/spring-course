package com.isaiasgabriel.crud_crm.rest;

import com.isaiasgabriel.crud_crm.entity.Employee;
import com.isaiasgabriel.crud_crm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId) {
            Employee employee = employeeService.findById(employeeId);

            if(employee == null){
                throw new RuntimeException("Employee with id " + employeeId + " not found");
            }

            return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        employee.setId(null);
       // Just in case someone pass an ID inside the JSON.body
       // However if you are using an in inside the entity then
       // You should use setId(0);
        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployeeById(@PathVariable int employeeId) {
        Employee employee = employeeService.findById(employeeId);

        if(employee == null){
            throw new RuntimeException("Employee with id " + employeeId + " not found");
        }

        employeeService.deleteById(employeeId);

        return "Deleted employee id:" + employeeId;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

}
