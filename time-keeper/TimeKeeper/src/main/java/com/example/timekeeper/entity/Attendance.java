package com.example.timekeeper.entity;

import com.example.timekeeper.enums.AttendanceStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.boot.model.source.spi.FetchCharacteristics;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(nullable=false, name="employeeId")
    @ManyToOne(fetch = FetchType.EAGER)
    private Employee employee;

    private LocalDate date;
    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;

    @Enumerated(EnumType.STRING)
    private AttendanceStatus attendanceStatus;
}
