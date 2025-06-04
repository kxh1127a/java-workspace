package com.example.snack.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JoinColumn(nullable = false, name="snackId")
    @ManyToOne(fetch = FetchType.EAGER)
    private Snack snack;

    @Column(nullable = false)
    private Integer amount;

    private LocalDate dateIn;
    private LocalDate dateOut;
    private boolean isSoldOut;

}
