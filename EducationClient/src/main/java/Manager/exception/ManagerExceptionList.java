package Manager.exception;

public enum ManagerExceptionList {

    NO_STUDENT("M0001","해당 학생 번호를 가진 학생은 없습니다."),
    CHECK_NUM("M0002","메뉴 번호를 확인해주세요.");
    private String ErrorCode;
    private String Message;

    ManagerExceptionList(String errorCode, String message) {
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
