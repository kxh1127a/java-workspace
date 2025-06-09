package com.example.timekeeper.advice;

import com.example.timekeeper.enums.ResultCode;
import com.example.timekeeper.exception.CMissingDataById;
import com.example.timekeeper.exception.CMissingDataByName;
import com.example.timekeeper.model.result.CommonResult;
import com.example.timekeeper.service.ResponseService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected CommonResult defaultException(HttpServletRequest request, Exception e) {
        return ResponseService.getFailResult(ResultCode.FAILED);
    }

    @ExceptionHandler(CMissingDataById.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected CommonResult customException(HttpServletRequest request, CMissingDataById e) {
        return ResponseService.getFailResult(ResultCode.MISSING_DATA_BY_ID);
    }

    @ExceptionHandler(CMissingDataByName.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected CommonResult customException(HttpServletRequest request, CMissingDataByName e) {
        return ResponseService.getFailResult(ResultCode.MISSING_DATA_BY_NAME);
    }
}
