package com.example.educationserver.service;

import com.example.educationserver.exception.CourseException;
import com.example.educationserver.exception.excute.NoStudentNumException;
import com.grpc.education.*;
import io.grpc.ManagedChannel;
import io.grpc.stub.StreamObserver;

public class EducationService extends EducationServiceGrpc.EducationServiceImplBase{
    private ManagedChannel channel;

    public EducationService(ManagedChannel channel) {
        this.channel = channel;
    }

    @Override
    public void getAllCoursesData(BasicRequest request, StreamObserver<GetAllCoursesDataResponse> responseObserver) {
        GetAllCoursesDataResponse response = EducationServiceGrpc.newBlockingStub(channel).getAllCoursesData(BasicRequest.newBuilder().build());
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void addCourse(AddCourseRequest request, StreamObserver<BasicResponse> responseObserver) {
        BasicResponse basicResponse = EducationServiceGrpc.newBlockingStub(channel).addCourse(AddCourseRequest.newBuilder()
                .setCourseId(request.getCourseId())
                .setProfessorName(request.getProfessorName())
                .setCourseName(request.getCourseName())
                .setCourseCredit(request.getCourseCredit())
                .setPrerequisiteList(request.getPrerequisiteList()).build());
        responseObserver.onNext(basicResponse);
        responseObserver.onCompleted();
    }

    @Override
    public void updateCourse(AddCourseRequest request, StreamObserver<BasicResponse> responseObserver) {
        super.updateCourse(request, responseObserver);
    }

    @Override
    public void deleteCourse(DeleteCourseRequest request, StreamObserver<BasicResponse> responseObserver) {
        BasicResponse basicResponse = EducationServiceGrpc.newBlockingStub(channel).deleteCourse(DeleteCourseRequest.newBuilder().setCourseId(request.getCourseId()).build());
        responseObserver.onNext(basicResponse);
        responseObserver.onCompleted();
    }

    @Override
    public void getAllStudentsData(BasicRequest request, StreamObserver<GetAllStudentsDataResponse> responseObserver) {
        GetAllStudentsDataResponse response = EducationServiceGrpc.newBlockingStub(channel).getAllStudentsData(BasicRequest.newBuilder().build());
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void addStudent(AddStudentRequest request, StreamObserver<BasicResponse> responseObserver) {
        BasicResponse response = EducationServiceGrpc.newBlockingStub(channel).addStudent(AddStudentRequest.newBuilder()
                .setStudentId(request.getStudentId())
                .setFirstName(request.getFirstName())
                .setLastName(request.getLastName())
                .setMajor(request.getMajor())
                .build());
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void deleteStudent(DeleteStudentRequest request, StreamObserver<BasicResponse> responseObserver) {
        BasicResponse response = EducationServiceGrpc.newBlockingStub(channel).deleteStudent(DeleteStudentRequest.newBuilder().setStudentId(request.getStudentId()).build());
        try {
            if (!response.getMessage().equals("SUCCESS")) {
                throw new NoStudentNumException();
            }
//            response(responseObserver,"200","요청에 성공하였습니다.");
        } catch (NoStudentNumException e) {
//                response(responseObserver,"401","해당 학번이 존재하지 않습니다..");
                e.printStackTrace();
        }
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void updateStudent(AddStudentRequest request, StreamObserver<BasicResponse> responseObserver) {
        BasicResponse response = EducationServiceGrpc.newBlockingStub(channel).updateStudent(AddStudentRequest.newBuilder()
                .setStudentId(request.getStudentId())
                .setFirstName(request.getFirstName())
                .setLastName(request.getLastName())
                .setMajor(request.getMajor())
                .setCompletedCoursesList(request.getCompletedCoursesList()).build());
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getStudent(BasicRequest request, StreamObserver<StudentResponse> responseObserver) {
        StudentResponse response = EducationServiceGrpc.newBlockingStub(channel).getStudent(BasicRequest.newBuilder().setMessage(request.getMessage()).build());
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void enrolment(EnrolmentRequest request, StreamObserver<BasicResponse> responseObserver) {
        BasicResponse response = EducationServiceGrpc.newBlockingStub(channel).enrolment(EnrolmentRequest.newBuilder().setCourseId(request.getCourseId()).setStudentId(request.getStudentId()).build());
        responseObserver.onNext(response);
        responseObserver.onCompleted();

    }

//    private void response(StreamObserver<BasicResponse> responseObserver, String code, String message) {
//        responseObserver.onNext(makeStatusCode(BasicResponse.newBuilder(), code, message));
//        responseObserver.onCompleted();
//    }
//
//    public BasicResponse makeStatusCode(BasicResponse.Builder statusCodeBuilder, String code, String message){
//        return statusCodeBuilder.setStatusCode(code).setMessage(message).build();
//    }


    @Override
    public void login(StudentLoginRequest request, StreamObserver<StudentResponse> responseObserver) {
        StudentResponse response = EducationServiceGrpc.newBlockingStub(channel).login(StudentLoginRequest.newBuilder().setStudentId(request.getStudentId()).setPassword(request.getPassword()).build());
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
