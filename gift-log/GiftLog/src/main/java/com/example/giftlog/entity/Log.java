package com.example.giftlog.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable=false)
    private LocalDate date;

    @JoinColumn(nullable = false, name="gift_name")
    @ManyToOne(fetch = FetchType.EAGER)
    private Gift gift;

    @JoinColumn(nullable = false, name="person_name")
    @ManyToOne(fetch = FetchType.EAGER)
    private Person person;
}
