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

    public EducationService(ManagedChannel channel) {
        this.channel = channel;
        logger = MyLogger.getLogger();
    }

    @Override
    public void getAllCoursesData(BasicRequest request, StreamObserver<GetAllCoursesDataResponse> responseObserver) {
        GetAllCoursesDataResponse response = EducationServiceGrpc.newBlockingStub(channel).getAllCoursesData(BasicRequest.newBuilder().build());
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void addCourse(AddCourseRequest request, StreamObserver<BasicResponse> responseObserver) {
        try {
            if(Integer.parseInt(request.getCourseCredit())>3 || Integer.parseInt(request.getCourseCredit()) < 0){
                throw new OverCourseCreditException();
            }

            BasicResponse basicResponse = EducationServiceGrpc.newBlockingStub(channel).addCourse(AddCourseRequest.newBuilder().setCourseId(request.getCourseId()).setProfessorName(request.getProfessorName()).setCourseName(request.getCourseName()).setCourseCredit(request.getCourseCredit()).setPrerequisiteList(request.getPrerequisiteList()).build());

            if(!basicResponse.getStatusMessage().equals("OVERLAP_COURSE_NUM")){
                if (!basicResponse.getStatusMessage().equals("NO_DATA_PREREQUISITE")){
                    logger.log("SUCCESS",MyLogger.getClassName(),MyLogger.getMethodName());
                    response(responseObserver,"200","요청에 성공하였습니다.");
                }else throw new NoDataPrerequisiteException();
            }else throw new OverlapCourseNumException();

        }catch (NoDataPrerequisiteException | OverlapCourseNumException | OverCourseCreditException e){
            logger.warning("FAILED_ADD_COURSE exception: ",MyLogger.getClassName(),MyLogger.getMethodName(),e.getClass().getSimpleName());
            response(responseObserver,"406",e.getClass().getSimpleName());
            e.printStackTrace();
        }
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
        BasicResponse response=null;
        try {
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

        }catch (NoDataMajorException | ValidateStudentNumException | OverlapStudentIdException e) {
            logger.warning("FAILED_ENROLMENT exception: ",MyLogger.getClassName(),MyLogger.getMethodName(),e.getClass().getSimpleName());
            response(responseObserver,"405",e.getClass().getSimpleName());
            e.printStackTrace();
        }
    }

    private boolean checkMajor(String major) {
        for(String s :MajorData.majorList){
            if(s.equals(major)) return true;
        }
        return false;
    }

    @Override
    public void deleteStudent(DeleteStudentRequest request, StreamObserver<BasicResponse> responseObserver) {
        BasicResponse response = EducationServiceGrpc.newBlockingStub(channel).deleteStudent(DeleteStudentRequest.newBuilder().setStudentId(request.getStudentId()).build());
        try {
            if (response.getMessage().equals("SUCCESS")){
                logger.log("SUCCESS",MyLogger.getClassName(),MyLogger.getMethodName());
                response(responseObserver,"200","요청에 성공하였습니다.");
            }else{
                throw new NoStudentNumException();
            }
        } catch (NoStudentNumException e) {
                logger.warning("NOT_FOUND_STUDENT",MyLogger.getClassName(),MyLogger.getMethodName(),e.getClass().getSimpleName());
                response(responseObserver,"404","student");
                e.printStackTrace();
        }
    }

    @Override
    public void updateStudent(AddStudentRequest request, StreamObserver<BasicResponse> responseObserver) {
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
                logger.warning("FAILED_ENROLMENT exception: ",MyLogger.getClassName(),MyLogger.getMethodName(),e.getClass().getSimpleName());
                response(responseObserver,"405",e.getClass().getSimpleName());
                e.printStackTrace();
            }

    }

    @Override
    public void getStudent(BasicRequest request, StreamObserver<StudentResponse> responseObserver) {
        StudentResponse response = EducationServiceGrpc.newBlockingStub(channel).getStudent(BasicRequest.newBuilder().setMessage(request.getMessage()).build());
         try {
             if (response.getStatus().equals("NON_STUDENT_NUM"))throw new NoStudentNumException();
        } catch (NoStudentNumException e) {
            logger.warning("FAILED_GET_STUDENT exception: ",MyLogger.getClassName(),MyLogger.getMethodName(),e.getClass().getSimpleName());
            e.printStackTrace();
        }
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void enrolment(EnrolmentRequest request, StreamObserver<BasicResponse> responseObserver) {
        BasicResponse response = EducationServiceGrpc.newBlockingStub(channel).enrolment(EnrolmentRequest.newBuilder().setCourseId(request.getCourseId()).setStudentId(request.getStudentId()).build());
            try {
                if(response.getStatusMessage().equals("NON_COURSE"))throw new NoCourseDataException();
                if(response.getStatusMessage().equals("ALREADY_ENROLMENT")) throw new AlreadyEnrolmentException();
                if(response.getStatusMessage().equals("ALREADY_COURSE")) throw new AlreadyCourseException();
                if(response.getStatusMessage().equals("NON_PREREQUISITE")) throw new NonPrerequisiteException();
                if(response.getStatusMessage().equals("SUCCESS")) {
                    logger.log("SUCCESS",MyLogger.getClassName(),MyLogger.getMethodName());
                    response(responseObserver,"200","요청에 성공하였습니다.");
                }
            } catch (NoCourseDataException | AlreadyEnrolmentException | AlreadyCourseException | NonPrerequisiteException e) {
                logger.warning("FAILED_ENROLMENT exception: ",MyLogger.getClassName(),MyLogger.getMethodName(),e.getClass().getSimpleName());
                response(responseObserver,"405",response.getStatusMessage());
                e.printStackTrace();
            }
    }

    private void response(StreamObserver<BasicResponse> responseObserver, String code, String message) {
        responseObserver.onNext(makeStatusCode(BasicResponse.newBuilder(), code, message));
        responseObserver.onCompleted();
    }

    public BasicResponse makeStatusCode(BasicResponse.Builder statusCodeBuilder, String code, String message){
        return statusCodeBuilder.setStatusCode(code).setMessage(message).setStatusMessage(message).build();
    }


    @Override
    public void login(StudentLoginRequest request, StreamObserver<StudentResponse> responseObserver) {
        StudentResponse response=null;
            response = EducationServiceGrpc.newBlockingStub(channel).login(StudentLoginRequest.newBuilder().setStudentId(request.getStudentId()).setPassword(request.getPassword()).build());
            try {
                if(response.getStatus().equals("FAILED")) throw new FailedLoginException();
            }catch (FailedLoginException e){
                logger.warning("FAILED_LOGIN",MyLogger.getClassName(),MyLogger.getMethodName(),e.getClass().getSimpleName());
                e.printStackTrace();
            }
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


}
