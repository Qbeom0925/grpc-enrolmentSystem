package com.example.educationclient.Manager.exception.exceution;


import com.example.educationclient.global.exception.ApplicationException;

public class CourseException extends ApplicationException {
    public CourseException() {
        super("errorCode", "message");
    }
}
