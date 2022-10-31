package exception.excute;

import exception.EducationException;
import exception.EducationExceptionList;

import static exception.EducationExceptionList.VALIDATE_STUDENT_NUM;

public class ValidateStudentNumException extends EducationException {
    public ValidateStudentNumException() {
        super(VALIDATE_STUDENT_NUM.getErrorCode(), VALIDATE_STUDENT_NUM.getMessage());
    }
}
