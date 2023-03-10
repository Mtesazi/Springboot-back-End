package com.mtesazi.springboot.repository;

import com.mtesazi.springboot.model.Employee;
import  static  org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.OPTIONAL;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
public class EmployeeRepositoryTests {
    @Autowired
    private EmployeeRepository employeeRepository;

    //JUnit test for save employee operation
    @Test
    @DisplayName("save employee operation")
    public void givenEmployeeObject_whenSave_thenReturnSavedEmployee() {


        //Given - precondition or setup
        Employee employee = Employee.builder()
                .firstName("Bongani")
                .lastName("Gumede")
                .address("Ntenga Area ward 6 Jozini 3969")
                .emailId("Mtesazi@gmail.com")
                .telephone("0734735290")
                .build();

        //When - action or the behaviour that we are going to test
        Employee savedEmployee = employeeRepository.save(employee);

        //Then - verify the output
        assertThat(savedEmployee).isNotNull();
        assertThat(savedEmployee.getId()).isGreaterThan(0);
    }


    //JUnit test for get all employees operation
    @Test
    @DisplayName("get all employee operation")
    public void givenEmployeeList_whenFindAll_thenEmployeeList() {

        //Given - precondition or setup
        Employee employee = Employee.builder()
                .firstName("Bongani")
                .lastName("Gumede")
                .address("Ntenga Area ward 6 Jozini 3969")
                .emailId("Mtesazi@gmail.com")
                .telephone("0734735290")
                .build();

        Employee employee1 = Employee.builder()
                .firstName("Mtesazi")
                .lastName("Mtshali")
                .address("23 Morningford Parkland Cape Town 7441")
                .emailId("Mtesazi@gmail.com")
                .telephone("0739601935")
                .build();
        employeeRepository.save(employee);
        employeeRepository.save(employee1);

        //When - action or the behaviour that we are going to test
        List<Employee> employeeList = employeeRepository.findAll();

        //Then - verify the output
        assertThat(employeeList).isNotNull();
        assertThat(employeeList.size()).isEqualTo(2);
    }


    //JUnit test for get employees by id operation
    @Test
    @DisplayName("get employee by id")
    public void givenEmployeeObject_whenFindById_thenReturnEmployeeObject() {

        //Given - precondition or setup
        Employee employee = Employee.builder()
                .firstName("Bongani")
                .lastName("Gumede")
                .address("Ntenga Area ward 6 Jozini 3969")
                .emailId("Mtesazi@gmail.com")
                .telephone("0734735290")
                .build();
        employeeRepository.save(employee);

        //When - action or the behaviour that we are going to test
        Employee employeeDB = employeeRepository.findById(employee.getId()).get();

        //Then - verify the output
        assertThat(employeeDB).isNotNull();

    }

    //JUnit test for get employee by email operation
    @Test
    @DisplayName("get employee by email operation")
    public void givenEmployeeEmail_whenFindByEmail_thenReturnEmployeeObject() {

        //Given - precondition or setup
        Employee employee = Employee.builder()
                .firstName("Bongani")
                .lastName("Gumede")
                .address("Ntenga Area ward 6 Jozini 3969")
                .emailId("Mtesazi@gmail.com")
                .telephone("0734735290")
                .build();
        employeeRepository.save(employee);

        //When - action or the behaviour that we are going to test
        Employee employeeDB = employeeRepository.findByEmailId(employee.getEmailId()).get();

        //Then - verify the output
        assertThat(employeeDB).isNotNull();
    }

    //JUnit test for update employee operation
    @Test
    @DisplayName("update employee operation")
    public void givenEmployeeObject_whenUpdateEmployee_thenReturnUpdatedEmployee() {

        //Given - precondition or setup
        Employee employee = Employee.builder()
                .firstName("Bongani")
                .lastName("Gumede")
                .address("Ntenga Area ward 6 Jozini 3969")
                .emailId("Mtesazi@gmail.com")
                .telephone("0734735290")
                .build();
        employeeRepository.save(employee);

        //When - action or the behaviour that we are going to test
        Employee savedEmployee = employeeRepository.findById(employee.getId()).get();
        savedEmployee.setFirstName("Mzaion");
        savedEmployee.setLastName("Mnguni");
        Employee updatedEmployee = employeeRepository.save(savedEmployee);

        //Then - verify the output
        assertThat(updatedEmployee.getFirstName()).isEqualTo("Mzaion");
        assertThat(updatedEmployee.getLastName()).isEqualTo("Mnguni");

    }

    //JUnit test for delete employee operation
    @Test
    @DisplayName("delete employee operation")
    public void givenEmployeeObject_whenDeleteEmployee_thenRemoveEmployee() {

        //Given - precondition or setup
        Employee employee = Employee.builder()
                .firstName("Bongani")
                .lastName("Gumede")
                .address("Ntenga Area ward 6 Jozini 3969")
                .emailId("Mtesazi@gmail.com")
                .telephone("0734735290")
                .build();
        employeeRepository.save(employee);

        //When - action or the behaviour that we are going to test
        employeeRepository.delete(employee);
        Optional<Employee> employeeOptional = employeeRepository.findById(employee.getId());

        //Then - verify the output
        assertThat(employeeOptional).isEmpty();
    }
}
