package com.example.educationclient.Manager.exception;

import com.example.educationclient.global.exception.ApplicationException;

public class ManagerException extends ApplicationException {
    public ManagerException(String errorCode, String message) {
        super(errorCode, message);
    }
}
