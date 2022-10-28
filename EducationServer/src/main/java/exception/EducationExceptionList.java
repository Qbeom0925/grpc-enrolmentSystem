package exception;

public enum EducationExceptionList {

    NO_STUDENT("M0001","해당 학생 번호를 가진 학생은 없습니다."),
    CHECK_NUM("M0002","메뉴 번호를 확인해주세요."),
    FAILED_LOGIN("M0003","로그인에 실패하였습니다.");

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
