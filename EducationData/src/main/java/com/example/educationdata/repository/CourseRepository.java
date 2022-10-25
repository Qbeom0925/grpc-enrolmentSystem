package com.example.educationdata.repository;

import com.example.educationdata.entity.Course;
import com.example.educationdata.entity.Student;
import com.example.educationdata.global.util.SqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseRepository {

    private final Connection connection;

    public CourseRepository() {
        this.connection = SqlConnection.connection();
    }

    public List<Course> getCourseAll() {
        ArrayList<Course> courses = new ArrayList<>();
        String sql = "select * from Course";

        try {
            PreparedStatement st = this.connection.prepareStatement(sql);
            ResultSet rs = null;
            rs = st.executeQuery();

            while(rs.next()){
                Course course = new Course(
                        rs.getString("course_id"),
                        rs.getString("professor_first_name"),
                        rs.getString("course_name"),
                        rs.getString("course_credit"),
                        rs.getString("prerequisite")
                        );
                courses.add(course);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return courses;
    }

    public void addCourse(String courseId, String courseCredit, String courseName, String professorName, String prerequisiteList) {
        String sql = "insert into course(course_id, course_name, course_credit, professor_first_name, prerequisite) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1,courseId);
            st.setString(2,courseName);
            st.setString(3,courseCredit);
            st.setString(4,professorName);
            st.setString(5,prerequisiteList);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deleteCourse(String courseId) {
        String sql = "delete from course where course_id = ?";
        try {
            PreparedStatement st = this.connection.prepareStatement(sql);
            st.setString(1,courseId);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean checkOverlapCourse(String courseId) {
        String sql = "select count(*) from course where course_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, courseId);
            ResultSet rs = st.executeQuery();
            if (rs.next()) if(rs.getInt("count(*)") >0) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
