package com.infopulse.simpleapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
public class Employee implements Serializable {
    @Id
    @GeneratedValue(generator = "employee_generator")
    @SequenceGenerator(
            name = "employee",
            sequenceName = "employee_sequence",
            initialValue = 1000
    )
    private Long id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

}