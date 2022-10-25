package entity;

public class Student {


    private String studentId;
    private String firstName;
    private String lastName;
    private String major;
    private String completedCourses;
    private String password;

    public Student(String studentId, String firstName, String lastName, String major, String completedCourses) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.major = major;
        this.completedCourses = completedCourses;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getCompletedCourses() {
        return completedCourses;
    }

    public void setCompletedCourses(String completedCourses) {
        this.completedCourses = completedCourses;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
