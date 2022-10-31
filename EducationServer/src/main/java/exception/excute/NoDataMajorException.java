package exception.excute;

import exception.EducationException;
import exception.EducationExceptionList;

import static exception.EducationExceptionList.*;

public class NoDataMajorException extends EducationException {
    public NoDataMajorException() {
        super(NO_DATA_MAJOR.getErrorCode(),
                NO_DATA_MAJOR.getMessage());
    }
}
