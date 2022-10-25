package exception.excute;

import exception.EducationException;

import static exception.EducationExceptionList.NO_STUDENT;

public class NoStudentNumException extends EducationException {

    public NoStudentNumException() {
        super(NO_STUDENT.getErrorCode(), NO_STUDENT.getMessage());
    }

}
