package com.example.baseframe.controller;

import com.example.baseframe.enums.ResultCode;
import com.example.baseframe.model.CommonResult;
import com.example.baseframe.service.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestController {
//    private final ResponseService responseService;

    @PostMapping("/new") //회원가입
    public CommonResult memberJoin() {
        return ResponseService.getSuccessResult();
    }

    @PostMapping("/admin/new") //회원등록
    public CommonResult setMember() {
        return ResponseService.getSuccessResult();
    }
}
