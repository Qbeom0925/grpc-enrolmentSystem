package manager.controller;

import com.grpc.education.*;

import java.util.List;
import java.util.Scanner;

import static manager.comment.ClientComment.*;
import static manager.comment.EducationCode.*;

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
                case 1: getAllStudentData(); break; //완료
                case 2: addStudent(); break; //완료
                case 3: deleteStudent(); break ; //완료
                case 4: updateStudent(); break; //완료
                case 5: getAllCourseData(); break; //완료
                case 6: addCourse(); break; //완료
                case 7: deleteCourse(); break; //완료
                case 0: break Exit;
            }
        }
    }

    public int printMenu(){
        List<String> stringList = List.of("1. 전체 학생 정보 조회","2. 학생 정보 추가", "3. 학생 정보 삭제", "4. 학생 정보 수정",
                "---------------","5. 전체 과목 정보 조회","6. 과목 정보 추가", "7. 과목 정보 삭제","0. 로그아웃");

        for (String s : stringList) System.out.println(s);

        int choice=0;
        while (true){
            choice = sc.nextInt();
            if(choice > stringList.size() || choice < 0){
                System.out.println("번호를 다시 입력해주세요.");
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
        System.out.println("삭제할 학번을 입력해주세요."); String choice = sc.next();
        print(stub.deleteStudent(DeleteStudentRequest.newBuilder().setStudentId(choice).build()));
    }

    private void print(BasicResponse basicResponse) {
        String status = basicResponse.getStatusCode();
        String message = basicResponse.getStatusMessage();

        switch (status){
            case S200:
                System.out.println(SUCCESS);
                break;
            case S404:
                if(message.equals(STUDENT))System.out.println(STUDENT_NUM);
                else System.out.println(NO_COURSE_NUM_COMMENT);
                if (message.equals(ValidateNumberException)) System.out.println(VALIDATE_NUMBER_COMMENT);
                break;
            case S500:
                System.out.println(DISCONNECTION);
                break;
            case S405:
                if(message.equals(NoDataMajorException)) System.out.println(NO_DATA_MAJOR_COMMENT);
                else if(message.equals(ValidateStudentNumException)) System.out.println(VALIDATE_STUDENT_NUM_COMMENT);
                else if(message.equals(OverlapStudentIdException)) System.out.println(OVERLAP_STUDENT_ID_COMMENT);
                else if(message.equals(NoCourseDataException)) System.out.println(NO_COURSE_NUM_COMMENT);
                if (message.equals(ValidateNumberException)) System.out.println(VALIDATE_NUMBER_COMMENT);
                break;
            case S406:
                if (message.equals(OverlapCourseNumException)) System.out.println(OVERLAP_COURSE_NUM_COMMENT);
                if (message.equals(NoDataPrerequisiteException)) System.out.println(NO_DATA_PREREQUISITE_COMMENT);
                if (message.equals(OverCourseCreditException)) System.out.println(OVER_COURSE_CREDIT_COMMENT);
                if (message.equals(ValidateNumberException)) System.out.println(VALIDATE_NUMBER_COMMENT);
        }
    }

    private void addStudent() {
        System.out.println("학생 추가를 진행합니다.");
        System.out.print("학번 : "); String studentId = sc.next();
        System.out.print("성 : "); String lastName = sc.next();
        System.out.print("이름 : "); String firstName = sc.next();
        System.out.print("전공 : "); String major=sc.next();
        print(stub.addStudent(AddStudentRequest.newBuilder().setStudentId(studentId).setFirstName(firstName).setLastName(lastName).setMajor(major).build()));
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
        if(!response.getStatus().equals("NON_STUDENT_NUM")){
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
                    System.out.println("수정 전: " + response.getMajor());
                    System.out.print("수정 후: ");
                    builder.setMajor(sc.next());
                    break;
                case 4:
                    System.out.println("수정 전: " + response.getCompletedCoursesList());
                    System.out.print("수정 후(,로 구분하여 입력): ");
                    builder.setCompletedCoursesList(sc.next());
                    break;
            }
            print(stub.updateStudent(builder.build()));
        }else System.out.println(FONT_RED+"학번을 다시 확인해주시기 바랍니다."+RESET);
    }

    private void getAllCourseData() {
        System.out.println("[과목번호] 교수님 성 || 과목명 || 선이수 과목");
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
        System.out.print("선이수 과목 (,로 구분하여 입력) 없을시 ,: "); String prerequisite=sc.next();
        print(stub.addCourse(AddCourseRequest.newBuilder().setCourseId(courseNum).setProfessorName(professorLastName).setCourseName(courseName).setCourseCredit(courseCredit).setPrerequisiteList(prerequisite).build()));
    }

    private void deleteCourse() {
        getAllCourseData();
        System.out.println("삭제할 과목 번호 : "); String courseId = sc.next();
        print(stub.deleteCourse(DeleteCourseRequest.newBuilder().setCourseId(courseId).build()));
    }

}
