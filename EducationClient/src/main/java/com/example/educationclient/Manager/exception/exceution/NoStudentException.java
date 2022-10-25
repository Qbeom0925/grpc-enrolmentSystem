package com.example.educationclient.Manager.exception.exceution;

import com.example.educationclient.Manager.exception.ManagerException;

import static com.example.educationclient.Manager.exception.ManagerExceptionList.CHECK_NUM;
import static com.example.educationclient.Manager.exception.ManagerExceptionList.NO_STUDENT;

public class NoStudentException extends ManagerException {
    public NoStudentException() {
        super(NO_STUDENT.getErrorCode(),
                NO_STUDENT.getMessage());    }
}
