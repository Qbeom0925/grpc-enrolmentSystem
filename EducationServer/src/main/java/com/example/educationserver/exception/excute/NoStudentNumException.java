package com.example.educationserver.exception.excute;

import com.example.educationserver.exception.StudentException;

import static com.example.educationserver.exception.StudentExceptionList.NO_STUDENT;

public class NoStudentNumException extends StudentException {

    public NoStudentNumException() {
        super(NO_STUDENT.getErrorCode(), NO_STUDENT.getMessage());
    }

}
