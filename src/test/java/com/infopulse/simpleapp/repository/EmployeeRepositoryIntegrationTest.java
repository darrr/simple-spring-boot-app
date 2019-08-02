package com.infopulse.simpleapp.repository;


import com.infopulse.simpleapp.SimpleAppApplication;
import com.infopulse.simpleapp.model.Employee;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SimpleAppApplication.class)
@ActiveProfiles("test")
public class EmployeeRepositoryIntegrationTest {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void whenSaveAndRetrieveEntity_thenOk() {
        Employee employee = new Employee();
        employee.setFirstname("Daria");
        employee.setLastname("Lazurenko");

        Employee savedEmployee = employeeRepository.save(employee);
        Employee retrievedEmployee = employeeRepository.getOne(savedEmployee.getId());

        assertNotNull(retrievedEmployee);
        assertEquals(savedEmployee.getFirstname(), retrievedEmployee.getFirstname());

    }
}
