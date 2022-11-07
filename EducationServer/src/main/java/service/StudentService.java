package service;

import com.grpc.education.*;
import exception.excute.*;
import global.MajorData;
import global.log.MyLogger;
import io.grpc.ManagedChannel;
import io.grpc.stub.StreamObserver;

import static service.EducationService.*;

public class StudentService {

    private MyLogger logger;
    private ManagedChannel channel;

    public StudentService(ManagedChannel channel) {
        this.channel = channel;
        logger = MyLogger.getLogger();
    }

    public GetAllStudentsDataResponse getAllStudentsData(){
        return EducationServiceGrpc.newBlockingStub(channel).getAllStudentsData(BasicRequest.newBuilder().build());
    }

    public void addStudent(AddStudentRequest request, StreamObserver<BasicResponse> responseObserver){
        BasicResponse response=null;
        try {
            if(!isNumeric(request.getStudentId())) throw new ValidateNumberException();

            if(checkMajor(request.getMajor())){if(request.getStudentId().length()==8){
                response = EducationServiceGrpc.newBlockingStub(channel).addStudent(AddStudentRequest.newBuilder().setStudentId(request.getStudentId()).setFirstName(request.getFirstName()).setLastName(request.getLastName()).setMajor(request.getMajor()).build());
                if(response.getStatusMessage().equals("OVERLAP_STUDENT_ID")){
                    throw new OverlapStudentIdException();
                }else{
                    logger.log("SUCCESS",MyLogger.getClassName(),MyLogger.getMethodName());
                    response(responseObserver,"200","요청에 성공하였습니다.");
                }
            }else throw new ValidateStudentNumException();
            }else throw new NoDataMajorException();

        }catch (NoDataMajorException | ValidateStudentNumException | OverlapStudentIdException | ValidateNumberException e) {
            logger.warning("FAILED_STUDENT exception: ",MyLogger.getClassName(),MyLogger.getMethodName(),e.getClass().getSimpleName());
            response(responseObserver,"405",e.getClass().getSimpleName());
            e.printStackTrace();
        }
    }

    public void deleteStudent(DeleteStudentRequest request, StreamObserver<BasicResponse> responseObserver){
        BasicResponse response = EducationServiceGrpc.newBlockingStub(channel).deleteStudent(DeleteStudentRequest.newBuilder().setStudentId(request.getStudentId()).build());
        try {
            if (response.getMessage().equals("SUCCESS")){
                logger.log("SUCCESS",MyLogger.getClassName(),MyLogger.getMethodName());
                response(responseObserver,"200","요청에 성공하였습니다.");
            }else{
                throw new NoStudentNumException();
            }
        } catch (NoStudentNumException e) {
            logger.warning("FAIL_DELETE_STUDENT",MyLogger.getClassName(),MyLogger.getMethodName(),e.getClass().getSimpleName());
            response(responseObserver,"404","student");
            e.printStackTrace();
        }
    }

    public void updateStudent(AddStudentRequest request, StreamObserver<BasicResponse> responseObserver){
        try {
            if (checkMajor(request.getMajor())) {
                BasicResponse response = EducationServiceGrpc.newBlockingStub(channel).updateStudent(AddStudentRequest.newBuilder()
                        .setStudentId(request.getStudentId())
                        .setFirstName(request.getFirstName())
                        .setLastName(request.getLastName())
                        .setMajor(request.getMajor())
                        .setCompletedCoursesList(request.getCompletedCoursesList()).build());
                if (response.getStatusMessage().equals("NO_COURSE")){
                    throw new NoCourseDataException();
                }else{
                    logger.log("SUCCESS",MyLogger.getClassName(),MyLogger.getMethodName());
                    response(responseObserver,"200","요청에 성공하였습니다.");
                }
            } else {
                throw new NoDataMajorException();
            }
        }catch(NoDataMajorException | NoCourseDataException e){
            logger.warning("FAILED_UPDATE_STUDENT",MyLogger.getClassName(),MyLogger.getMethodName(),e.getClass().getSimpleName());
            response(responseObserver,"405",e.getClass().getSimpleName());
            e.printStackTrace();
        }
    }

    public void enrolment(EnrolmentRequest request, StreamObserver<BasicResponse> responseObserver) {
        BasicResponse response = EducationServiceGrpc.newBlockingStub(channel).enrolment(EnrolmentRequest.newBuilder().setCourseId(request.getCourseId()).setStudentId(request.getStudentId()).build());
        try {
            if(response.getStatusMessage().equals("NON_COURSE"))throw new NoCourseDataException();
            if(response.getStatusMessage().equals("ALREADY_ENROLMENT")) throw new AlreadyEnrolmentException();
            if(response.getStatusMessage().equals("ALREADY_COURSE")) throw new AlreadyCourseException();
            if(response.getStatusMessage().equals("NON_PREREQUISITE")) throw new NonPrerequisiteException();
            if(response.getStatusMessage().equals("SUCCESS")) {
                logger.log("SUCCESS",MyLogger.getClassName(),MyLogger.getMethodName());
                response(responseObserver,"200",response.getStatusMessage());
            }
        } catch (NoCourseDataException | AlreadyEnrolmentException | AlreadyCourseException | NonPrerequisiteException e) {
            logger.warning("FAILED_ENROLMENT",MyLogger.getClassName(),MyLogger.getMethodName(),e.getClass().getSimpleName());
            response(responseObserver,"405",response.getStatusMessage());
            e.printStackTrace();
        }
    }

    public void getStudent(BasicRequest request, StreamObserver<StudentResponse> responseObserver) {
        StudentResponse response = EducationServiceGrpc.newBlockingStub(channel).getStudent(BasicRequest.newBuilder().setMessage(request.getMessage()).build());
        try {
            if (response.getStatus().equals("NON_STUDENT_NUM"))throw new NoStudentNumException();
        } catch (NoStudentNumException  e) {
            logger.warning("FAILED_GET_STUDENT",MyLogger.getClassName(),MyLogger.getMethodName(),e.getClass().getSimpleName());
            e.printStackTrace();
        }
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
