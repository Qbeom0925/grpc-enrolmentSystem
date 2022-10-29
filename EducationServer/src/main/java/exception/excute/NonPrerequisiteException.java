package exception.excute;

import exception.EducationException;

import static exception.EducationExceptionList.NON_PREREQUISITE;

public class NonPrerequisiteException extends EducationException {
    public NonPrerequisiteException() {
        super(NON_PREREQUISITE.getErrorCode(),NON_PREREQUISITE.getMessage());
    }
}
