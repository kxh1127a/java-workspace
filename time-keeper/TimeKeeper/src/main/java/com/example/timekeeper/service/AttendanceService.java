package com.example.timekeeper.service;

import com.example.timekeeper.entity.Attendance;
import com.example.timekeeper.exception.CMissingDataById;
import com.example.timekeeper.repository.AttendanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendanceService {
    private final AttendanceRepository attendanceRepository;

//    public void checkInCreateRequest(long id) {
//
//
//        });
//    }
}
