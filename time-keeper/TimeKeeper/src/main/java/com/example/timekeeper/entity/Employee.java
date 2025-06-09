package com.example.timekeeper.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @JoinColumn(nullable = false, name="departmentId")
    @ManyToOne(fetch = FetchType.EAGER)
    private Department department;

    @Column(nullable = false)
    private LocalDate hireDate;
}
