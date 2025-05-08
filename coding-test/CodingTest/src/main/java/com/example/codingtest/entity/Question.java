package com.example.codingtest.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(nullable= false, name="subjectId")
    @ManyToOne(fetch = FetchType.EAGER)
    private Subject subject;

    @Column(nullable = false)
    private String content;

}
