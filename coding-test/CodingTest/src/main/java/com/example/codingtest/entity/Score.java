package com.example.codingtest.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(nullable = false, name="studentId")
    @ManyToOne(fetch = FetchType.EAGER)
    private Student student;

    @JoinColumn(nullable = false, name="questionId")
    @ManyToOne(fetch = FetchType.EAGER)
    private Question question;

    @Column(nullable = false)
    private Long grade;
}
