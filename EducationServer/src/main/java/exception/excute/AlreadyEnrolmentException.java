package exception.excute;

import exception.EducationException;

import static exception.EducationExceptionList.ALREADY_ENROLMENT;

public class AlreadyEnrolmentException extends EducationException {
    public AlreadyEnrolmentException() {
        super(ALREADY_ENROLMENT.getErrorCode(), ALREADY_ENROLMENT.getMessage());
    }
}
