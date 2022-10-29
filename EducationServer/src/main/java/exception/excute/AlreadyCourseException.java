package exception.excute;

import exception.EducationException;

import static exception.EducationExceptionList.ALREADY_COURSE;

public class AlreadyCourseException extends EducationException {
    public AlreadyCourseException() {
        super(ALREADY_COURSE.getErrorCode(), ALREADY_COURSE.getMessage());
    }
}
