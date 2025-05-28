package com.example.baseframe.exception;

public class CWrongIdException extends RuntimeException {

    public CWrongIdException() {
        super();
    }

    public CWrongIdException(String message) {
        super(message);
    }

    public CWrongIdException(String message, Throwable cause) {
        super(message, cause);
    }
}

