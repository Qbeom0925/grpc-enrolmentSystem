package exception.excute;

import exception.EducationException;

import static exception.EducationExceptionList.OVERLAP_STUDENT_ID;

public class OverlapStudentIdException extends EducationException {
    public OverlapStudentIdException() {
        super(OVERLAP_STUDENT_ID.getErrorCode(), OVERLAP_STUDENT_ID.getMessage());
    }
}
