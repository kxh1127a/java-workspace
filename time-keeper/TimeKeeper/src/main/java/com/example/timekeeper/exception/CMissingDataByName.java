package com.example.timekeeper.exception;

public class CMissingDataByName extends RuntimeException {
    public CMissingDataByName() {
        super();
    }
    public CMissingDataByName(String message) {
        super(message);
    }
    public CMissingDataByName(String message, Throwable cause) {
        super(message, cause);
    }
}

