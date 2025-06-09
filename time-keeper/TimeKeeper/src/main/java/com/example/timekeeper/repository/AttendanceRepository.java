package com.example.timekeeper.repository;

import com.example.timekeeper.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    Optional<List<Attendance>> findAllByEmployeeId(long id);
}
