package com.example.EmployeeMGMT.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employees")
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Employees{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NameofEmployee", nullable = false)
    private String name;
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "designation", nullable = false)
    private String designation;
}
