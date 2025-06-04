package com.example.snack.service;

import com.example.snack.enums.ResultCode;
import com.example.snack.model.result.CommonResult;
import com.example.snack.model.result.ListResult;
import com.example.snack.model.result.SingleResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResponseService {

    public static CommonResult getSuccessResult() {
        CommonResult result = new CommonResult();
        setResult(result, true, ResultCode.SUCCESS);
        return result;
    }

    public static <T> SingleResult<T> getSingleResult(T data) {
        SingleResult<T> result = new SingleResult<>();
        result.setData(data);
        setResult(result, true, ResultCode.SUCCESS);
        return result;
    }

    public static <T> ListResult<T> getListResult(List<T> data) {
        ListResult<T> result = new ListResult<>();
        result.setListData(data);
        setResult(result, true, ResultCode.SUCCESS);
        return result;
    }

    public static CommonResult getFailResult(ResultCode resultCode) {
        CommonResult result = new CommonResult();
        setResult(result, false, resultCode);
        return result;
    }

    public static void setResult(CommonResult commonResult, boolean isSuccess, ResultCode resultCode) {
        commonResult.setIsSuccess(isSuccess);
        commonResult.setCode(resultCode.getCode());
        commonResult.setMessage(resultCode.getMessage());
    }
}
