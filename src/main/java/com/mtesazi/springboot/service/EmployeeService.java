package com.mtesazi.springboot.service;

import com.mtesazi.springboot.model.Employee;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface EmployeeService {
    Employee createEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Optional<Employee> getEmployeeById(long id);
    Employee updateEmployee(Employee employeeDetails);
    void deleteEmployee(long id);
}
