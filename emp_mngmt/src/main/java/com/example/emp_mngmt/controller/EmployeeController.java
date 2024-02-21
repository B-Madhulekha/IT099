package com.example.emp_mngmt.controller;



import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.emp_mngmt.model.Employee;
import com.example.emp_mngmt.service.EmployeeService;

@RestController

public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save")
    public Employee getAllEmployees(@RequestBody Employee employee) {
        return employeeService.getAllEmployees(employee);
    }
    
    @GetMapping ("/get")
    public List<Employee> getEmployee(){
        return employeeService.getEmployee();
    }
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long id) {
        return employeeService.getEmployeeById(id);
    }

    // @PutMapping ("/{id}")
    // public Employee updateEmployee(@PathVariable("id") Long id, @RequestBody Employee updatedEmployee) {
    //     return employeeService.updateEmployee(updatedEmployee);
    // }
    @PutMapping("/{id}")
    public ResponseEntity<Employee> putEmpId(@PathVariable("id") Long id, @RequestBody Employee employee){
        Employee emp=employeeService.putbyEmpId(id,employee);
        if(emp!=null)
            return new ResponseEntity<>(HttpStatus.CREATED);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
}
