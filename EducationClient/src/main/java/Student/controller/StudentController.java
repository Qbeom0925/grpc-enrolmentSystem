package student.controller;

import com.grpc.education.BasicResponse;
import com.grpc.education.EducationServiceGrpc;
import com.grpc.education.EnrolmentRequest;
import com.grpc.education.StudentResponse;

import java.util.List;
import java.util.Scanner;

import static manager.comment.ClientComment.*;

public class StudentController {

    private static EducationServiceGrpc.EducationServiceBlockingStub stub;
    private static Scanner sc;

    public StudentController(EducationServiceGrpc.EducationServiceBlockingStub stub) {
        this.stub = stub;
        sc = new Scanner(System.in);
    }

    public void initial(StudentResponse studentResponse) {
        Exit:
        while (true) {
            switch (printMenu()) {
                case 1: Enrolment(studentResponse); break;
                case 0: break Exit;
            }
        }
    }

    private int printMenu() {
        sc = new Scanner(System.in);
        List<String> stringList = List.of("1. 수강 신청 진행","0. 로그아웃");

        for (String s : stringList) {
            System.out.println(s);
        }
        return sc.nextInt();
    }

    private void Enrolment(StudentResponse studentResponse) {
        System.out.println("수강신청을 진행합니다.");
        System.out.println("과목 번호:");  String courseNum = sc.next();
        BasicResponse enrolment = stub.enrolment(EnrolmentRequest.newBuilder().setStudentId(studentResponse.getStudentId()).setCourseId(courseNum).build());
        switch (enrolment.getStatusMessage()){
            case "NON_COURSE": System.out.println(NO_COURSE_NUM_COMMENT);break;
            case "ALREADY_ENROLMENT":System.out.println(ALREADY_ENROLMENT_COMMENT);break;
            case "ALREADY_COURSE":System.out.println(ALREADY_COURSE_COMMENT);break;
            case "NON_PREREQUISITE":System.out.println(NON_PREREQUISITE_COMMENT);break;
            case "SUCCESS":System.out.println("수강신청이 완료되었습니다.");break;
        }
    }
}
