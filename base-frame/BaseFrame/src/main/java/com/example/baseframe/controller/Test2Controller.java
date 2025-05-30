package com.example.baseframe.controller;

import com.example.baseframe.model.SingleResult;
import com.example.baseframe.service.ResponseService;
import com.example.baseframe.service.Test2Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test2")
public class Test2Controller {
    private final Test2Service test2Service;

    @GetMapping("/name")
    public SingleResult<String> getTestName() {
        return ResponseService.getSingleResult(test2Service.getTestName());
    }
    // { "isSuccess": true, "code": 0, "message": "성공하였습니다.", "data": "홍길동" }
}

