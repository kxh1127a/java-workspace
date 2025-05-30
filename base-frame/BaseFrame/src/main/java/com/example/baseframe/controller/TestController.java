package com.example.baseframe.controller;

import com.example.baseframe.entity.TestStock;
import com.example.baseframe.enums.ResultCode;
import com.example.baseframe.model.CommonResult;
import com.example.baseframe.model.ListResult;
import com.example.baseframe.model.SingleResult;
import com.example.baseframe.service.ResponseService;
import com.example.baseframe.service.TestStockService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestController {
//    private final ResponseService responseService;
    private final TestStockService testStockService;

    @PostMapping("/new") //회원가입
    public CommonResult memberJoin() {
        return ResponseService.getSuccessResult();
    }

    @PostMapping("/admin/new") //회원등록
    public CommonResult setMember() {
        return ResponseService.getSuccessResult();
    }

    @GetMapping("/{id}")
    public SingleResult<TestStock> getStock(@PathVariable long id) {
        return ResponseService.getSingleResult(testStockService.getStock(id));
    }

    @GetMapping("/all")
    public ListResult<TestStock> getStocks() {
        return ResponseService.getListResult(testStockService.getStocks());
    }
}

