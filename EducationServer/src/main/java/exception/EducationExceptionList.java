package exception;

public enum EducationExceptionList {

    NO_STUDENT("M0001","해당 학생 번호를 가진 학생은 없습니다."),
    CHECK_NUM("M0002","메뉴 번호를 확인해주세요."),
    FAILED_LOGIN("M0003","로그인에 실패하였습니다."),
    NO_COURSE_DATA("M0004", "해당 번호를 가진 과목은 없습니다."),
    ALREADY_ENROLMENT("M0005","해당 과목을 이미 수강신청을 하였습니다."),
    ALREADY_COURSE("M0006","해당 과목을 이미 수강하였습니다."),
    NON_PREREQUISITE("M0007","해당 과목의 선 이수 과목을 수강하지 않았습니다.");

    private String ErrorCode;
    private String Message;

    EducationExceptionList(String errorCode, String message) {
        ErrorCode = errorCode;
        Message = message;
    }

    public String getErrorCode() {
        return this.ErrorCode;
    }

    public String getMessage() {
        return this.Message;
    }
}
