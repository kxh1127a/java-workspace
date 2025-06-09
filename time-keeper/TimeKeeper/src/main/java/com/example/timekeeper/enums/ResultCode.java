package com.example.timekeeper.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ResultCode {
    SUCCESS(0, "성공하였습니다."),
    FAILED(-1, "실패하였습니다."),

    // 사원 기능 (근태 조회)
    MISSING_DATA_BY_ID(-1000, "해당 id의 직원이 존재하지 않습니다."),
    MISSING_DATA_BY_NAME(-1001, "해당 이름의 직원이 존재하지 않습니다.");

    // 관리자 기능

    private final Integer code;
    private final String message;
}
