package repository;


import entity.Student;
import global.util.SqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    private final Connection connection;

    public StudentRepository() {
        this.connection = SqlConnection.connection();
    }

    public List<Student> getStudentAll() {
        ArrayList<Student> students = new ArrayList<>();
        try {
            String sql = "select * from Student";
            PreparedStatement st = this.connection.prepareStatement(sql);
            ResultSet rs = null;
            rs = st.executeQuery();

            while(rs.next()){
                Student student = new Student(
                        rs.getString("student_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("major"),
                        rs.getString("completed_courses")
                        );
                students.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    public boolean checkOverlapStudent(String studentId) {
        try {
            String sql = "SELECT count(*) FROM STUDENT where student_id = ? ";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1,studentId);
            ResultSet rs = st.executeQuery();
            if(rs.next()) if(rs.getInt("count(*)") >0) return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public boolean checkNonOverlapStudent(String studentId) {
        try {
            String sql = "SELECT count(*) FROM STUDENT where student_id = ? ";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1,studentId);
            ResultSet rs = st.executeQuery();
            if(rs.next()) if(rs.getInt("count(*)") ==0) return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }



    public void deleteStudent(String studentId) {
        try {
            String sql = "DELETE FROM Student WHERE student_id = ?;";
            PreparedStatement st = this.connection.prepareStatement(sql);
            st.setString(1, studentId);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void addStudent(String studentId, String firstName, String lastName, String major) {
        try {
            String sql = "insert into student(student_id, first_name,  last_name, major,completed_courses,password) VALUES (?,?,?,?,?,?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, studentId);
            st.setString(2, firstName);
            st.setString(3, lastName);
            st.setString(4, major);
            st.setString(5,"0");
            st.setString(6,studentId);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Student getStudent(String studentId) {
        try {
            String sql = "select * from Student where student_id = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1,studentId);
            ResultSet rs =null;
            rs = st.executeQuery();
            Student student = null;
            if(rs.next()) {
                student = new Student(
                        rs.getString("student_id"),
                        rs.getString("FIRST_NAME"),
                        rs.getString("LAST_NAME"),
                        rs.getString("MAJOR"),
                        rs.getString("COMPLETED_COURSES")
                );
            }
            return student;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateStudent(String studentId, String major, String lastName, String firstName, String completedCoursesList) {
        try {
            String sql = "UPDATE STUDENT SET major= ? , last_name = ? , first_name = ? , completed_courses = ? WHERE student_id=?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1,major);
            st.setString(2,lastName);
            st.setString(3, firstName);
            st.setString(4, completedCoursesList);
            st.setString(5,studentId);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void enrolment(String studentId, String courseId) {
        String indexQuery = "select enrolment_idx from enrolment order by enrolment_idx desc";
        String sql = "INSERT INTO ENROLMENT(enrolment_idx, course_id, student_id) VALUES(?,?,?)";
        try {

            PreparedStatement stIndex = connection.prepareStatement(indexQuery);
            ResultSet rs = stIndex.executeQuery();
            int index = 1;
            if (rs.next()) index += rs.getInt("enrolment_idx");

            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, index);
            st.setString(2, courseId);
            st.setString(3, studentId);
            st.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Student login(String studentId, String password) {
        String sql = "select * from student where student_id = ? and password = ?";
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(sql);
            st.setString(1,studentId);
            st.setString(2,password);
            ResultSet rs =null;
            rs = st.executeQuery();
            Student student = null;
            if(rs.next()) {
                student = new Student(
                        rs.getString("student_id"),
                        rs.getString("FIRST_NAME"),
                        rs.getString("LAST_NAME"),
                        rs.getString("MAJOR"),
                        rs.getString("COMPLETED_COURSES")
                );
            }
            return student;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
