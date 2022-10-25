package com.example.educationdata.service;

import com.example.educationdata.entity.Course;
import com.example.educationdata.repository.CourseRepository;
import com.grpc.education.*;
import io.grpc.stub.StreamObserver;

public class CourseService extends EducationServiceGrpc.EducationServiceImplBase{

    private CourseRepository courseRepository;

    public CourseService() {
        this.courseRepository = new CourseRepository();
    }

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
}
