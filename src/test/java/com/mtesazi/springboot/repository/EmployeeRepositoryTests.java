package com.mtesazi.springboot.repository;

import com.mtesazi.springboot.model.Employee;
import  static  org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

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
}
