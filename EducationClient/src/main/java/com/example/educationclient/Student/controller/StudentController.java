package com.example.educationclient.Student.controller;

import com.grpc.education.*;

import java.util.List;
import java.util.Scanner;

public class StudentController {

    private static EducationServiceGrpc.EducationServiceBlockingStub stub;
    private static Scanner sc;

    public StudentController(EducationServiceGrpc.EducationServiceBlockingStub stub) {
        this.stub = stub;
        sc = new Scanner(System.in);
    }

    public void initial() {
        if (login()){
            Exit:
            while (true) {
                switch (printMenu()) {
                    case 1: Enrolment(); break;
                    case 0: break Exit;
                }
            }//TODO 로그인 exception
        }else System.out.println("로그인 실패");
    }

    private boolean login() {
        System.out.print("ID: "); String studentId = sc.next();
        System.out.print("PASSWORD: "); String password = sc.next();
        StudentResponse studentResponse = stub.login(StudentLoginRequest.newBuilder().setStudentId(studentId).setPassword(password).build());
        if (studentResponse != null) {
            System.out.println(studentResponse.getStudentId() + " " + studentResponse.getFirstName() + " 님 안녕하세요");
            return true;
        }
        else {
            System.out.println("로그인 실패");
            return false;
        }
    }

    private int printMenu() {
        sc = new Scanner(System.in);
        List<String> stringList = List.of("1. 수강 신청 진행");

        for (String s : stringList) {
            System.out.println(s);
        }
        return sc.nextInt();
    }

    //TODO 학번, 과목번호 존재, 중복수강, 학점 초과
    private void Enrolment() {
        System.out.println("수강신청을 진행합니다.");
        System.out.print("학번: "); //TODO 나중에는 빠져서 로그인 파라미터로 값받을 예정
        String studentId = sc.next();
        System.out.println("과목 번호:");  String courseNum = sc.next();

        BasicResponse enrolment = stub.enrolment(EnrolmentRequest.newBuilder().setStudentId(studentId).setCourseId(courseNum).build());
        System.out.println(enrolment.getMessage());
    }
}
