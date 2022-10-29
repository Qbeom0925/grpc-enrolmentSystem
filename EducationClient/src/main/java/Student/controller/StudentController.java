package Student.controller;

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
            case "NON_COURSE": System.out.println("해당 번호를 가진 과목은 없습니다.");break;
            case "ALREADY_ENROLMENT":System.out.println("해당 과목을 이미 수강신청을 하였습니다.");break;
            case "ALREADY_COURSE":System.out.println("해당 과목을 이미 수강하였습니다.");break;
            case "NON_PREREQUISITE":System.out.println("해당 과목의 선 이수 과목을 수강하지 않았습니다.");break;
            case "SUCCESS":System.out.println("수강신청이 완료되었습니다.");break;
        }
    }
}
