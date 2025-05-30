package com.example.baseframe.advice;

import com.example.baseframe.enums.ResultCode;
import com.example.baseframe.exception.CMissingDataException;
import com.example.baseframe.exception.CWrongPhoneNumberException;
import com.example.baseframe.model.CommonResult;
import com.example.baseframe.service.ResponseService;
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

    @ExceptionHandler(CMissingDataException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected CommonResult customException(HttpServletRequest request, CMissingDataException e) {
        return ResponseService.getFailResult(ResultCode.MISSING_DATA);
    }

    @ExceptionHandler(CWrongPhoneNumberException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected CommonResult customException(HttpServletRequest request, CWrongPhoneNumberException e) {
        return ResponseService.getFailResult(ResultCode.WRONG_PHONE_NUMBER);
    }
}
