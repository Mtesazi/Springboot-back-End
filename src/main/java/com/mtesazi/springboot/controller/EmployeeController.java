package com.mtesazi.springboot.controller;


import com.mtesazi.springboot.exception.ResourceNotFoundException;
import com.mtesazi.springboot.model.Employee;
import com.mtesazi.springboot.repository.EmployeeRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200/")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;


    //get all employees rest api
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    // Create employee rest api
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    //get employee by Id
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

        return ResponseEntity.ok(employee);
    }

    //Delete employee rest api



    //Update employee rest api
}
