package com.example.educationdata.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Getter
@Setter
public class Student {

    @Id
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
}
