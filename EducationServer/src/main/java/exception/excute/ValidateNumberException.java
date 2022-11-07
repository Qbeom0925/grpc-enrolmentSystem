package exception.excute;

import exception.EducationException;
import exception.EducationExceptionList;

public class ValidateNumberException extends EducationException {
    public ValidateNumberException() {
        super(EducationExceptionList.VALIDATE_NUMBER.getErrorCode(), EducationExceptionList.VALIDATE_NUMBER.getMessage());
    }
}
