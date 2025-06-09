package com.example.timekeeper.service;

import com.example.timekeeper.enums.ResultCode;
import com.example.timekeeper.model.result.CommonResult;
import com.example.timekeeper.model.result.ListResult;
import com.example.timekeeper.model.result.SingleResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ResponseService {

    public static CommonResult getSuccessResult() {
        CommonResult result = new CommonResult();
        setResult(result, true, ResultCode.SUCCESS);
        return result;
    }

    public static <T> SingleResult<T> getSuccessSingleResult(T data) {
        SingleResult<T> result = new SingleResult<>();
        setResult(result, true, ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }

    public static <T> ListResult<T> getSuccessListResult(List<T> listData) {
        ListResult<T> result = new ListResult<>();
        setResult(result, true, ResultCode.SUCCESS);
        result.setList(listData);
        return result;
    }

    public static CommonResult getFailResult(ResultCode resultCode) {
        CommonResult result = new CommonResult();
        setResult(result, false, resultCode);
        return result;
    }

    private static void setResult(CommonResult commonResult, boolean isSuccess, ResultCode resultCode) {
        commonResult.setIsSuccess(isSuccess);
        commonResult.setCode(resultCode.getCode());
        commonResult.setMessage(resultCode.getMessage());
    }

}
