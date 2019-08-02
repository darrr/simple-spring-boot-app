package com.infopulse.simpleapp.controller;

import com.infopulse.simpleapp.SimpleAppApplication;
import com.infopulse.simpleapp.model.Employee;
import com.infopulse.simpleapp.repository.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {
        SimpleAppApplication.class},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class EmployeeControllerIntegrationTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void givenEmployees_whenGetEmployeeById_thenStatus200()
            throws Exception {

        Employee employee = new Employee();
        employee.setFirstname("Daria");
        employee.setLastname("Lazurenko");

        Employee savedEmployee = employeeRepository.save(employee);
        long employeeId = savedEmployee.getId();

        mvc.perform(get("/employee/" + employeeId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(employeeId));
    }
}
