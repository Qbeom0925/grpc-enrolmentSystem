package Manager.exception;


import global.exception.ApplicationException;

public class ManagerException extends ApplicationException {
    public ManagerException(String errorCode, String message) {
        super(errorCode, message);
    }
}
