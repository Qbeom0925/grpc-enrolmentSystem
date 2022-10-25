package com.example.educationdata.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
public class Enrolment {

    @Id
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
}
