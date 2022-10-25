package com.example.educationclient.Manager.exception.exceution;

import com.example.educationclient.Manager.exception.ManagerException;

import static com.example.educationclient.Manager.exception.ManagerExceptionList.CHECK_NUM;

public class CheckMenuNumException extends ManagerException {

    public CheckMenuNumException() {
        super(CHECK_NUM.getErrorCode(),
                CHECK_NUM.getMessage());
    }
}
