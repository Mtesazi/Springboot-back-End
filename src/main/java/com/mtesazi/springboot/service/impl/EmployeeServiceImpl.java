package com.mtesazi.springboot.service.impl;

import com.mtesazi.springboot.exception.ResourceNotFoundException;
import com.mtesazi.springboot.model.Employee;
import com.mtesazi.springboot.repository.EmployeeRepository;
import com.mtesazi.springboot.service.EmployeeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    public Employee createEmployee(Employee employee) {

        Optional<Employee> createEmployee = employeeRepository.findById(employee.getId());
        if(createEmployee.isPresent()){
            throw new ResourceNotFoundException("Employee already exist with given id:" + employee.getId());
        }
        return employeeRepository.save(employee);
    }
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Transactional
    public Optional<Employee> getEmployeeById(long id) {
        return employeeRepository.findById(id);
    }

    @Transactional
    public Employee updateEmployee(Employee employeeDetails) {
        return employeeRepository.save(employeeDetails);
    }

    @Transactional
    public void deleteEmployee(long id) {
        employeeRepository.deleteById(id);
    }
}
