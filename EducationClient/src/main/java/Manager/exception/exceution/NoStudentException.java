package Manager.exception.exceution;


import Manager.exception.ManagerException;

import static Manager.exception.ManagerExceptionList.NO_STUDENT;

public class NoStudentException extends ManagerException {
    public NoStudentException() {
        super(NO_STUDENT.getErrorCode(),
                NO_STUDENT.getMessage());    }
}
