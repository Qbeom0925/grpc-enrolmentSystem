package Manager.exception.exceution;


import global.exception.ApplicationException;

public class CourseException extends ApplicationException {
    public CourseException() {
        super("errorCode", "message");
    }
}
