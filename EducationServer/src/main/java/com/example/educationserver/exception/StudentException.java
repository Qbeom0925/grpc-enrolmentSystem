package com.example.educationserver.exception;

import com.example.educationserver.global.exception.ApplicationException;

public class StudentException extends ApplicationException {
    public StudentException(String errorCode, String message) {
        super(errorCode, message);
    }
}
