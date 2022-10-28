package exception.excute;

import exception.EducationException;
import exception.EducationExceptionList;

import static exception.EducationExceptionList.*;

public class FailedLoginException extends EducationException {
    public FailedLoginException() {
        super(FAILED_LOGIN.getErrorCode(), FAILED_LOGIN.getMessage());
    }
}
