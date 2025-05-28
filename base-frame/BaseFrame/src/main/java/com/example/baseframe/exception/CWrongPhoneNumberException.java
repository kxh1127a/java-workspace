package com.example.baseframe.exception;

public class CWrongPhoneNumberException extends RuntimeException {

    public CWrongPhoneNumberException() {
        super();
    }

    public CWrongPhoneNumberException(String message) {
        super(message);
    }

    public CWrongPhoneNumberException(String message, Throwable cause) {
        super(message, cause);
    }
}

