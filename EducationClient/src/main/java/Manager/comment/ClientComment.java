package Manager.comment;

import static Manager.exception.ManagerExceptionList.*;


public interface ClientComment {

    String RESET = "\u001B[0m";
    String FONT_RED = "\u001B[31m";
    String FONT_BLUE = "\u001B[34m";

    public static final String SUCCESS = FONT_BLUE+"요청에 성공하였습니다."+RESET;

    public static final String COURSE_NUM = FONT_RED+ NO_COURSE_DATA.getMessage()+RESET;
    public static final String STUDENT_NUM = FONT_RED+ NO_STUDENT.getMessage()+RESET;
    public static final String DISCONNECTION = FONT_RED+"DB연결에 에러가 발생하였습니다."+RESET;

    public static final String NO_DATA_MAJOR_COMMENT = FONT_RED+ NO_DATA_MAJOR.getMessage()+RESET;
    public static final String VALIDATE_STUDENT_NUM_COMMENT = FONT_RED+ VALIDATE_STUDENT_NUM.getMessage()+RESET;
    public static final String OVERLAP_STUDENT_ID_COMMENT = FONT_RED+ OVERLAP_STUDENT_ID.getMessage() +RESET;

    public static final String STUDENT = "student";
    public static final String COURSE = "course";
}
