package com.mtesazi.springboot.controller;



import com.mtesazi.springboot.model.Employee;
import com.mtesazi.springboot.repository.EmployeeRepository;
import com.mtesazi.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "http://localhost:4200/")
@ControllerAdvice
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;


    public EmployeeController(EmployeeService employeeService) {this.employeeService = employeeService;}


    //get all employees rest api
    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    // Create employee rest api
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    //get employees by Id rest api
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId){
        return employeeService.getEmployeeById(employeeId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    //Update employee rest api
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long employeeId,
                                                   @RequestBody Employee employee){
        return employeeService.getEmployeeById(employeeId)
                .map(createEmployee -> {

                    createEmployee.setFirstName(employee.getFirstName());
                    createEmployee.setLastName(employee.getLastName());
                    createEmployee.setEmailId(employee.getEmailId());
                    createEmployee.setTelephone(employee.getTelephone());
                    createEmployee.setAddress(employee.getAddress());

                    Employee updatedEmployee = employeeService.updateEmployee(createEmployee);
                    return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);

                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
     //delete employee rest api
     @DeleteMapping("{id}")
     public ResponseEntity<String> deleteEmployee(@PathVariable("id") long employeeId){

         employeeService.deleteEmployee(employeeId);
         return new ResponseEntity<String>("Employee deleted successfully!.", HttpStatus.OK);
     }
}