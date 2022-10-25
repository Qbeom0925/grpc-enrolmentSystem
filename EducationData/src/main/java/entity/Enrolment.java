package entity;

public class Enrolment {

    private String enrolmentIdx;

    private String studentId;
    private String courseId;

    public Enrolment(String enrolmentIdx, String studentId, String courseId) {
        this.enrolmentIdx = enrolmentIdx;
        this.studentId = studentId;
        this.courseId = courseId;
    }

    public Enrolment() {

    }

    public String getEnrolmentIdx() {
        return enrolmentIdx;
    }

    public void setEnrolmentIdx(String enrolmentIdx) {
        this.enrolmentIdx = enrolmentIdx;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
}
