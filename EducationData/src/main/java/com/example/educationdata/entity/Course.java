package com.example.educationdata.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
public class Course {

    @Id
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
}
