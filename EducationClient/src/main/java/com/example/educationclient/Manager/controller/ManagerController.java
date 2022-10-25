package com.example.educationclient.Manager.controller;

import com.example.educationclient.Manager.exception.exceution.CheckMenuNumException;
import com.example.educationclient.Manager.exception.exceution.CourseException;
import com.example.educationclient.Manager.exception.exceution.NoStudentException;
import com.grpc.education.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.example.educationclient.global.Comment.FONT_BLUE;
import static com.example.educationclient.global.Comment.RESET;

public class ManagerController {

    private static EducationServiceGrpc.EducationServiceBlockingStub stub;
    private static Scanner sc;

    public ManagerController(EducationServiceGrpc.EducationServiceBlockingStub stub) {
        this.stub = stub;
        sc = new Scanner(System.in);
    }


    public void initial() {
        Exit:
        while (true) {
            switch (printMenu()) {
                case 1: getAllStudentData(); break;
                case 2: addStudent(); break;
                case 3: deleteStudent(); break ;
                case 4: updateStudent(); break;
                //TODO 학점 추가 예정
                case 5: getAllCourseData(); break;
                case 6: addCourse(); break;
                case 7: //과목 정보 수정
                    updateCourse();
                    break;
                case 8: deleteCourse(); break;
                case 0: break Exit;
            }
        }
    }



    public int printMenu(){
        sc = new Scanner(System.in);
        List<String> stringList = List.of("1. 전체 학생 정보 조회","2. 학생 정보 추가", "3. 학생 정보 삭제", "4. 학생 정보 수정", "---------------","5. 전체 과목 정보 조회","6. 과목 정보 추가", "7. 과목 정보 수정", "8. 과목 정보 삭제");

        for (String s : stringList) System.out.println(s);

        int choice=0;
        while (true){
            choice = sc.nextInt();
            if(choice > stringList.size() || choice < 0){
                new CheckMenuNumException();
                continue;
            }
            break;
        }
        return choice;
    }



    public void getAllStudentData(){
        System.out.println("[학번] 성  이름 || 학과 || 이수 과목");

        for (GetAllStudentsDataResponse.Student s : stub.getAllStudentsData(BasicRequest.newBuilder().build()).getStudentsList()) {
            System.out.print("["+s.getStudentId()+"]" + " " + s.getLastName() + " "+s.getFirstName() + " || " + s.getMajor() + " || ");
            for (String s1 : s.getCompletedCoursesListList()) System.out.print(s1 + " ");

            System.out.println();
        }
    }



    private void deleteStudent() {
       this.getAllStudentData();
        System.out.println("삭제할 학번을 입력해주세요.");

        String choice = sc.next();
        BasicResponse basicResponse = stub.deleteStudent(DeleteStudentRequest.newBuilder().setStudentId(choice).build());
        if(basicResponse.getMessage().equals("SUCCESS")) System.out.println(FONT_BLUE+"삭제에 성공하였습니다."+RESET);
        else new NoStudentException();

//            try {
//                System.out.println(FONT_BLUE+"삭제에 성공하였습니다."+RESET);
//            } catch (CourseException e) {
//                e.printStackTrace();
//            }



    }

    private void addStudent() {
        System.out.println("학생 추가를 진행합니다.");
        System.out.print("학번 : "); String studentId = sc.next();
        System.out.print("성 : "); String lastName = sc.next();
        System.out.print("이름 : "); String firstName = sc.next();
        System.out.print("전공 : "); String major=sc.next();

        BasicResponse basicResponse = stub.addStudent(AddStudentRequest.newBuilder().setStudentId(studentId).setFirstName(firstName).setLastName(lastName).setMajor(major).build());

        //TODO OVERLAP_STUDENT_ID, NO_MAJOR_DATA, NO_STUDENT_NUM, SUCCESS
        System.out.println(basicResponse.getMessage());
    }

    private void updateStudent() {
        getAllStudentData();
        System.out.println("수정할 학번을 입력해주세요.");
        String studentId = sc.next();
        StudentResponse response = stub.getStudent(BasicRequest.newBuilder().setMessage(studentId).build());
        AddStudentRequest.Builder builder = AddStudentRequest.newBuilder()
                .setStudentId(response.getStudentId())
                .setFirstName(response.getFirstName())
                .setLastName(response.getLastName())
                .setCompletedCoursesList(response.getCompletedCoursesList())
                .setMajor(response.getMajor());
        if(response!=null){
            System.out.println("수정 할 항목을 선택하세요");
            System.out.println("1. 성  2. 이름  3. 학과  4. 이수과목");
            switch (sc.nextInt()){
                case 1:
                    System.out.println("수정 전: " + response.getLastName());
                    System.out.print("수정 후: ");
                    builder.setLastName(sc.next());
                    break;
                case 2:
                    System.out.println("수정 전: " + response.getFirstName());
                    System.out.print("수정 후: ");
                    builder.setFirstName(sc.next());
                    break;
                case 3:
                    //TODO 해당학과 존재한지 확인
                    System.out.println("수정 전: " + response.getMajor());
                    System.out.print("수정 후: ");
                    builder.setMajor(sc.next());
                    break;
                case 4:
                    //TODO 해당 과목 번호 존재한지 확인
                    System.out.println("수정 전: " + response.getCompletedCoursesList());
                    System.out.print("수정 후: ");
                    builder.setCompletedCoursesList(sc.nextLine());
                    break;
            }
        }else{
            //TODO 학번 확인 해주세요
        }
        if(!stub.updateStudent(builder.build()).getMessage().equals("SUCCESS")){
         //TODO DB 에러 발생
        }
    }

    private void getAllCourseData() {
        System.out.println("[과목번호] 강사 성 || 과목명 || 선이수 과목");

        for (GetAllCoursesDataResponse.Course c : stub.getAllCoursesData(BasicRequest.newBuilder().build()).getCoursesList()) {
            System.out.println("["+c.getCourseId()+"]"+ " "+ c.getProfessorName()+" "+c.getCourseName()+" "+c.getPrerequisiteList()+" "+c.getCourseCredit());
        }
    }

    private void addCourse() {
        System.out.println("과목 추가를 진행합니다.");
        System.out.print("과목번호 : "); String courseNum = sc.next();
        System.out.print("교수님 성 : "); String professorLastName = sc.next();
        System.out.print("과목이름 : "); String courseName = sc.next();
        System.out.print("과목 학점 : "); String courseCredit=sc.next();
        System.out.print("선이수 과목 : "); String prerequisite=sc.next();


        BasicResponse basicResponse = stub.addCourse(AddCourseRequest.newBuilder().setCourseId(courseNum).setProfessorName(professorLastName).setCourseName(courseName).setCourseCredit(courseCredit).setPrerequisiteList(prerequisite).build());
        //TODO 동일한 과목 번호, 선이수 해당 과목 존재한지 확인
        System.out.println(basicResponse.getMessage());
    }

    private void deleteCourse() {
        getAllCourseData();
        System.out.println("삭제할 과목 번호를 입력해주세요.");
        String courseId = sc.next();

        BasicResponse basicResponse = stub.deleteCourse(DeleteCourseRequest.newBuilder().setCourseId(courseId).build());
        System.out.println(basicResponse.getMessage());
    }

    private void updateCourse() {
        System.out.println("개발 진행 중입니다.");
    }
}
