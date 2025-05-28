package com.example.baseframe.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
public enum ResultCode {
    SUCCESS(0, "성공하였습니다.")
    , FAILED(-1, "실패하였습니다.")

    , WRONG_PHONE_NUMBER(-1000, "잘못된 핸드폰번호입니다.")
    , WRONG_ID(-1001, "잘못된 아이디입니다.")
    , WRONG_PASSWORD(-1002, "잘못된 비밀번호입니다.")

    , MISSING_DATA(-2000, "데이터가 없습니다.")
    ;

    private final Integer code;
    private final String msg;


}
