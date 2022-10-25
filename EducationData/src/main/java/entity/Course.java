package entity;



public class Course {

    private String courseId;
    private String professorFirstName;
    private String courseName;
    private String courseCredit;
    private String prerequisite;

    public Course(String courseId, String professorFirstName, String courseName, String courseCredit, String prerequisite) {
        this.courseId = courseId;
        this.professorFirstName = professorFirstName;
        this.courseName = courseName;
        this.courseCredit = courseCredit;
        this.prerequisite = prerequisite;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getProfessorFirstName() {
        return professorFirstName;
    }

    public void setProfessorFirstName(String professorFirstName) {
        this.professorFirstName = professorFirstName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(String courseCredit) {
        this.courseCredit = courseCredit;
    }

    public String getPrerequisite() {
        return prerequisite;
    }

    public void setPrerequisite(String prerequisite) {
        this.prerequisite = prerequisite;
    }
}
