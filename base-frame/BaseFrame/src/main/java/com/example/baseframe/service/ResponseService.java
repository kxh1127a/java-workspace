package com.example.baseframe.service;

import com.example.baseframe.enums.ResultCode;
import com.example.baseframe.model.CommonResult;
import com.example.baseframe.model.SingleResult;
import org.springframework.stereotype.Service;

@Service
public class ResponseService {

    public static <T> SingleResult<T> getSingleResult(T data) {
        SingleResult<T> result = new SingleResult<>();
        result.setData(data);
        setResult(result, true, ResultCode.SUCCESS);

        return result;
    }

    public static CommonResult getSuccessResult() {
        CommonResult result = new CommonResult();
//        result.setIsSuccess(true);
//        result.setCode(ResultCode.SUCCESS.getCode());
//        result.setMessage(ResultCode.SUCCESS.getMessage());
        setResult(result, true, ResultCode.SUCCESS);

        return result;
    }

    // 오버로딩 (resultCode가 parameter로 넘어오지 않으면 기본 실패 처리)
    public static CommonResult getFailResult() {
        CommonResult result = new CommonResult();
        setResult(result, false, ResultCode.FAILED);

        return result;
    }

    public static CommonResult getFailResult(ResultCode resultCode) {
        CommonResult result = new CommonResult();
//        result.setIsSuccess(false);
//        result.setCode(resultCode.getCode());
//        result.setMessage(resultCode.getMessage());
        setResult(result, false, resultCode);

        return result;
    }

    private static void setResult(CommonResult commonResult, boolean isSuccess, ResultCode resultCode) {
        commonResult.setIsSuccess(isSuccess);
        commonResult.setCode(resultCode.getCode());
        commonResult.setMessage(resultCode.getMessage());
    }
}
