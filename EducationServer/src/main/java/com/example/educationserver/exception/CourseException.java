package com.example.educationserver.exception;

import com.example.educationserver.global.exception.ApplicationException;

public class CourseException  extends ApplicationException {
    public CourseException(String errorCode, String message) {
        super(errorCode, message);
    }
}
