package com.example.emp_mngmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.emp_mngmt.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{

    
}
