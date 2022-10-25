package Manager.comment;

public interface ClientComment {

    String RESET = "\u001B[0m";
    String FONT_RED = "\u001B[31m";
    String FONT_BLUE = "\u001B[34m";

    public static final String SUCCESS = FONT_BLUE+"요청에 성공하였습니다."+RESET;

    public static final String COURSE_NUM = FONT_RED+"해당 과목 번호가 존재하지 않습니다."+RESET;
    public static final String STUDENT_NUM = FONT_RED+"해당 학번이 존재하지 않습니다."+RESET;
    public static final String DISCONNECTION = FONT_RED+"DB연결에 에러가 발생하였습니다."+RESET;

    public static final String STUDENT = "student";
    public static final String COURSE = "course";
}
