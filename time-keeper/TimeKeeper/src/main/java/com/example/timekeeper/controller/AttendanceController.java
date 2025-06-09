package com.example.timekeeper.controller;

import com.example.timekeeper.model.AttendanceItem;
import com.example.timekeeper.model.result.CommonResult;
import com.example.timekeeper.model.result.ListResult;
import com.example.timekeeper.service.AttendanceService;
import com.example.timekeeper.service.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/attendance")
public class AttendanceController {
    private final AttendanceService attendanceService;

    @PostMapping("/check-in/{id}")
    public CommonResult checkInCreateRequest(@RequestParam long id) {
//        attendanceService.checkInCreateRequest(id);
        return ResponseService.getSuccessResult();
    }
}
