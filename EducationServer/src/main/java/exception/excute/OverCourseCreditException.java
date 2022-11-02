package exception.excute;

import exception.EducationException;

import static exception.EducationExceptionList.OVER_COURSE_CREDIT;

public class OverCourseCreditException extends EducationException {
    public OverCourseCreditException() {
        super(OVER_COURSE_CREDIT.getErrorCode(), OVER_COURSE_CREDIT.getMessage());
    }
}
