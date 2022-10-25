package exception;


import global.exception.ApplicationException;

public class EducationException extends ApplicationException {
    public EducationException(String errorCode, String message) {
        super(errorCode, message);
    }
}
