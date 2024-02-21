package com.example.emp_mngmt.service;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.emp_mngmt.model.Employee;
import com.example.emp_mngmt.repository.EmployeeRepository;


@Service
public class EmployeeService {
  
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @SuppressWarnings("null")
    public Employee getAllEmployees(Employee employee){
        return employeeRepository.save(employee);
    }

    public List<Employee> getEmployee(){
        return employeeRepository.findAll();
    }
    @SuppressWarnings("null")
    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }
    public Employee getEmployeeById(Long id){
        @SuppressWarnings("null")
        Optional<Employee> emp = employeeRepository.findById(id);
        return emp.orElse(null);
    }
    // @SuppressWarnings("null")
    // public Employee updateEmployee(Employee updatedEmployee){
    //      return employeeRepository.save(updatedEmployee);
    // }
    @SuppressWarnings("null")
    public Employee putbyEmpId(Long id,Employee employee){
        return employeeRepository.findById(id).orElse(null);
    }
}
