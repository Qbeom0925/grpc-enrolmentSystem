package exception.excute;

import exception.EducationException;

import static exception.EducationExceptionList.NO_DATA_PREREQUISITE;

public class NoDataPrerequisiteException extends EducationException {
    public NoDataPrerequisiteException() {
        super(NO_DATA_PREREQUISITE.getErrorCode(), NO_DATA_PREREQUISITE.getMessage());
    }
}
