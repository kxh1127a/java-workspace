package com.example.timekeeper.exception;

public class CMissingDataById extends RuntimeException {
    public CMissingDataById() {
        super();
    }
    public CMissingDataById(String message) {
        super(message);
    }
    public CMissingDataById(String message, Throwable cause) {
        super(message, cause);
    }
}
