package com.example.baseframe.exception;

public class CWrongPasswordException extends RuntimeException {

    public CWrongPasswordException() {
        super();
    }

    public CWrongPasswordException(String message) {
        super(message);
    }

    public CWrongPasswordException(String message, Throwable cause) {
        super(message, cause);
    }
}
