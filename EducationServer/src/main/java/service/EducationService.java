package service;


import com.grpc.education.*;
import exception.excute.*;
import global.MajorData;
import global.log.MyLogger;
import io.grpc.ManagedChannel;
import io.grpc.stub.StreamObserver;

public class EducationService extends EducationServiceGrpc.EducationServiceImplBase{

    private MyLogger logger;
    private ManagedChannel channel;

    private CourseService courseService;
    private StudentService studentService;

    public EducationService(ManagedChannel channel) {
        this.channel = channel;
        logger = MyLogger.getLogger();
        courseService = new CourseService(channel);
        studentService = new StudentService(channel);
    }

    @Override
    public void getAllCoursesData(BasicRequest request, StreamObserver<GetAllCoursesDataResponse> responseObserver) {
        responseObserver.onNext(courseService.getAllCoursesDataResponse());
        responseObserver.onCompleted();
    }

    @Override
    public void addCourse(AddCourseRequest request, StreamObserver<BasicResponse> responseObserver) {
        this.courseService.addCourse(request,responseObserver);
    }

    @Override
    public void updateCourse(AddCourseRequest request, StreamObserver<BasicResponse> responseObserver) {
        super.updateCourse(request, responseObserver);
    }

    @Override
    public void deleteCourse(DeleteCourseRequest request, StreamObserver<BasicResponse> responseObserver) {
        this.courseService.deleteCourse(request,responseObserver);
    }

    @Override
    public void getAllStudentsData(BasicRequest request, StreamObserver<GetAllStudentsDataResponse> responseObserver) {
        responseObserver.onNext(this.studentService.getAllStudentsData());
        responseObserver.onCompleted();
    }

    @Override
    public void addStudent(AddStudentRequest request, StreamObserver<BasicResponse> responseObserver) {
        this.studentService.addStudent(request,responseObserver);
    }


    @Override
    public void deleteStudent(DeleteStudentRequest request, StreamObserver<BasicResponse> responseObserver) {
        this.studentService.deleteStudent(request,responseObserver);
    }

    @Override
    public void updateStudent(AddStudentRequest request, StreamObserver<BasicResponse> responseObserver) {
        this.studentService.updateStudent(request,responseObserver);
    }

    @Override
    public void getStudent(BasicRequest request, StreamObserver<StudentResponse> responseObserver) {
        this.studentService.getStudent(request,responseObserver);
    }

    @Override
    public void enrolment(EnrolmentRequest request, StreamObserver<BasicResponse> responseObserver) {
        this.studentService.enrolment(request,responseObserver);
    }

    public static void response(StreamObserver<BasicResponse> responseObserver, String code, String message) {
        responseObserver.onNext(makeStatusCode(BasicResponse.newBuilder(), code, message));
        responseObserver.onCompleted();
    }

    public static BasicResponse makeStatusCode(BasicResponse.Builder statusCodeBuilder, String code, String message){
        return statusCodeBuilder.setStatusCode(code).setMessage(message).setStatusMessage(message).build();
    }


    @Override
    public void login(StudentLoginRequest request, StreamObserver<StudentResponse> responseObserver) {
        StudentResponse response=null;
            try {
                response = EducationServiceGrpc.newBlockingStub(channel).login(StudentLoginRequest.newBuilder().setStudentId(request.getStudentId()).setPassword(request.getPassword()).build());
                if(response.getStatus().equals("FAILED")) throw new FailedLoginException();
            }catch (FailedLoginException e){
                logger.warning("FAILED_LOGIN",MyLogger.getClassName(),MyLogger.getMethodName(),e.getClass().getSimpleName());
                e.printStackTrace();
            }
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    public static boolean checkMajor(String major) {
        for(String s : MajorData.majorList){
            if(s.equals(major)) return true;
        }
        return false;
    }

    public static boolean isNumeric(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
