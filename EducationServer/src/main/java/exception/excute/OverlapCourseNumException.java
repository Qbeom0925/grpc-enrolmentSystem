package exception.excute;

import exception.EducationException;

import static exception.EducationExceptionList.OVERLAP_COURSE_NUM;

public class OverlapCourseNumException extends EducationException {
    public OverlapCourseNumException() {
        super(OVERLAP_COURSE_NUM.getErrorCode(), OVERLAP_COURSE_NUM.getMessage());
    }
}
