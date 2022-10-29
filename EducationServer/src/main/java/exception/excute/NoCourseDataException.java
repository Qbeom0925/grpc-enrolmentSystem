package exception.excute;

import exception.EducationException;

import static exception.EducationExceptionList.NO_COURSE_DATA;

public class NoCourseDataException extends EducationException {
    public NoCourseDataException() {
        super(NO_COURSE_DATA.getErrorCode(), NO_COURSE_DATA.getMessage());
    }
}
