package service;


import com.grpc.education.*;
import entity.Course;
import entity.Student;
import io.grpc.stub.StreamObserver;
import repository.CourseRepository;
import repository.ManagerRepository;
import repository.StudentRepository;

import java.util.List;

public class EducationService extends EducationServiceGrpc.EducationServiceImplBase{

    private CourseRepository courseRepository;
    private StudentRepository studentRepository;
    private ManagerRepository managerRepository;

    public EducationService() {
        this.courseRepository = new CourseRepository();
        this.studentRepository = new StudentRepository();
        this.managerRepository = new ManagerRepository();
    }


    //TODO 학생, 과목 클래스 나눌 방법 생각

    @Override
    public void getAllCoursesData(BasicRequest request, StreamObserver<GetAllCoursesDataResponse> responseObserver) {
        GetAllCoursesDataResponse.Builder builder = GetAllCoursesDataResponse.newBuilder();
        for (Course c : courseRepository.getCourseAll()) {
            GetAllCoursesDataResponse.Course course = GetAllCoursesDataResponse.Course.newBuilder().setCourseId(c.getCourseId()).setCourseCredit(c.getCourseCredit()).setCourseName(c.getCourseId()).setProfessorName(c.getProfessorFirstName()).setCourseCredit(c.getPrerequisite()).build();
            builder.addCourses(course);
        }
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void addCourse(AddCourseRequest request, StreamObserver<BasicResponse> responseObserver) {
        //TODO 이미 존재한 과목 번호
        BasicResponse.Builder builder = BasicResponse.newBuilder();
        courseRepository.addCourse(request.getCourseId(),request.getCourseCredit(),request.getCourseName(), request.getProfessorName(),request.getPrerequisiteList());
        responseObserver.onNext(builder.setMessage("SUCCESS").build());
        responseObserver.onCompleted();
    }

    @Override
    public void updateCourse(AddCourseRequest request, StreamObserver<BasicResponse> responseObserver) {
        super.updateCourse(request, responseObserver);
    }

    @Override
    public void deleteCourse(DeleteCourseRequest request, StreamObserver<BasicResponse> responseObserver) {
        BasicResponse.Builder builder = BasicResponse.newBuilder();
        if(courseRepository.checkOverlapCourse(request.getCourseId())){
            courseRepository.deleteCourse(request.getCourseId());
            builder.setMessage("SUCCESS");
        }else{
            //TODO 존재하지 않는 과목
        }
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void getAllStudentsData(BasicRequest request, StreamObserver<GetAllStudentsDataResponse> responseObserver) {
        GetAllStudentsDataResponse.Builder builder = GetAllStudentsDataResponse.newBuilder();
        for (Student s : studentRepository.getStudentAll()) {
            GetAllStudentsDataResponse.Student student = GetAllStudentsDataResponse.Student.newBuilder().setStudentId(s.getStudentId()).setFirstName(s.getFirstName()).setLastName(s.getLastName()).setMajor(s.getMajor()).addAllCompletedCoursesList(List.of(s.getCompletedCourses().split(" "))).build();
            builder.addStudents(student);
        }

        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void addStudent(AddStudentRequest request, StreamObserver<BasicResponse> responseObserver) {
        BasicResponse.Builder builder = BasicResponse.newBuilder();
        if(studentRepository.checkNonOverlapStudent(request.getStudentId())){
            if(true){
                if(true){
                    studentRepository.addStudent(request.getStudentId(), request.getFirstName(),request.getLastName(),request.getMajor());
                    builder.setMessage("SUCCESS");
                }else{//학번 양식 안맞음
                    builder.setMessage("NO_STUDENT_NUM");
                }
            }else{//학과 잘못 선택시
                builder.setMessage("NO_MAJOR_DATA");
            }
        }else{
            builder.setMessage("OVERLAP_STUDENT_ID");
        }
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void deleteStudent(DeleteStudentRequest request, StreamObserver<BasicResponse> responseObserver) {
        BasicResponse.Builder builder = BasicResponse.newBuilder();
        if(studentRepository.checkOverlapStudent(request.getStudentId())){
            studentRepository.deleteStudent(request.getStudentId());
            builder.setMessage("SUCCESS");
        }else{
            builder.setMessage("FAIL");
        }

        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void updateStudent(AddStudentRequest request, StreamObserver<BasicResponse> responseObserver) {
        BasicResponse.Builder builder = BasicResponse.newBuilder();
        studentRepository.updateStudent(request.getStudentId(), request.getMajor(), request.getLastName(), request.getFirstName(), request.getCompletedCoursesList());
        builder.setMessage("SUCCESS");
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void getStudent(BasicRequest request, StreamObserver<StudentResponse> responseObserver) {
        StudentResponse.Builder builder = StudentResponse.newBuilder();
        Student student =null;
        if (studentRepository.checkOverlapStudent(request.getMessage())){
            student = studentRepository.getStudent(request.getMessage());
        }
        responseObserver.onNext(builder.setStudentId(student.getStudentId()).setFirstName(student.getFirstName()).setLastName(student.getLastName()).setMajor(student.getMajor()).setCompletedCoursesList(student.getCompletedCourses()).build());
        responseObserver.onCompleted();
    }

    @Override
    public void enrolment(EnrolmentRequest request, StreamObserver<BasicResponse> responseObserver) {
        BasicResponse.Builder builder = BasicResponse.newBuilder();
        studentRepository.enrolment(request.getStudentId(), request.getCourseId());
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void login(StudentLoginRequest request, StreamObserver<StudentResponse> responseObserver) {
        StudentResponse.Builder builder = StudentResponse.newBuilder();
        if(!getRole(request.getStudentId())){
            Student student =null;
            student = studentRepository.login(request.getStudentId(), request.getPassword());
            if (student != null){
                responseObserver.onNext(builder.setStudentId(student.getStudentId()).setMajor(student.getMajor()).setLastName(student.getLastName()).setFirstName(student.getFirstName()).setCompletedCoursesList(student.getCompletedCourses()).setStatus("S").build());
            }else{
                responseObserver.onNext(builder.setStatus("FAILED").build());
            }
        }else{
            responseObserver.onNext(builder.setStatus("M").build());
        }
        responseObserver.onCompleted();
    }

    public boolean getRole(String login_id) {
        if (managerRepository.getManager(login_id)) return true;
        else return false;
    }
}
