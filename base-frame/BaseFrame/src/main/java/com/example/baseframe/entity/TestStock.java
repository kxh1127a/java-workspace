package com.example.baseframe.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class TestStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30, nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer count;

    @Column(nullable = false)
    private Boolean isSoldOut;

    @Column(nullable = false)
    private LocalDate dateIn;

    private LocalDate dateSoldOut;
}
