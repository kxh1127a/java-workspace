package com.example.timekeeper.model.result;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonResult {
    private Boolean isSuccess;
    private Integer Code;
    private String message;
}
