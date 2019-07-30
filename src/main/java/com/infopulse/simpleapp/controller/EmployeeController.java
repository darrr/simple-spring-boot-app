package com.infopulse.simpleapp.controller;

import com.infopulse.simpleapp.exception.ResourceNotFoundException;
import com.infopulse.simpleapp.model.Employee;
import com.infopulse.simpleapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public ResponseEntity<Page<Employee>> getEmployees(Pageable pageable) {
        return ResponseEntity.ok(employeeRepository.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Employee>> getEmployee(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(employeeRepository.findById(id));
    }


    @PostMapping
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
        return ResponseEntity.ok(employeeRepository.save(employee));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,
                                   @Valid @RequestBody Employee employeeRequest) {
        return employeeRepository.findById(id)
                .map(employee -> {
                    employee = employeeRequest;
                    return ResponseEntity.ok(employeeRepository.save(employee));
                }).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + id));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
        return employeeRepository.findById(id)
                .map(employee -> {
                    employeeRepository.delete(employee);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + id));
    }
}
