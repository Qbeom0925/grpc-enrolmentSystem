package com.example.educationdata.service;

import com.example.educationdata.entity.Student;
import com.example.educationdata.repository.StudentRepository;
import com.grpc.education.*;
import io.grpc.stub.StreamObserver;

import java.util.List;

public class StudentService extends EducationServiceGrpc.EducationServiceImplBase{

    private StudentRepository studentRepository;

    public StudentService() {
        this.studentRepository = new StudentRepository();
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

}
