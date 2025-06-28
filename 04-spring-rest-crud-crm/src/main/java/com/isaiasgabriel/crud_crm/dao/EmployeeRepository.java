package com.isaiasgabriel.crud_crm.dao;

import com.isaiasgabriel.crud_crm.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="members") // /api/members
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
}
