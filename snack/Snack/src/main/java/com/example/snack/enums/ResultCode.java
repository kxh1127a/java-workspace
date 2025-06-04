package com.example.snack.enums;

import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ResultCode {
    SUCCESS(0, "successful"),
    FAILED(-1, "fail"),

    MISSING_DATA(-1000, "There's no data."),
    ALREADY_EXISTS(-1001, "Data already exists.");

    private final Integer code;
    private final String message;

}
