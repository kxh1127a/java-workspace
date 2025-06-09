package com.example.timekeeper.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AttendanceStatus {
    NORMAL("정상"),
    LATE("지각"),
    EARLY_LEAVE("조퇴"),
    ABSENT("결근");

    private final String statusDetail;
}
