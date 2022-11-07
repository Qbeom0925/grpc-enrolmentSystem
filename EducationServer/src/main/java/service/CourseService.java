package service;

import com.grpc.education.*;
import exception.excute.*;
import global.log.MyLogger;
import io.grpc.ManagedChannel;
import io.grpc.stub.StreamObserver;

import static service.EducationService.isNumeric;
import static service.EducationService.response;


public class CourseService {

    private MyLogger logger;
    private ManagedChannel channel;

    public CourseService(ManagedChannel channel) {
        this.channel = channel;
        logger = MyLogger.getLogger();
    }

    public GetAllCoursesDataResponse getAllCoursesDataResponse(){
        return EducationServiceGrpc.newBlockingStub(channel).getAllCoursesData(BasicRequest.newBuilder().build());
    }

    public void addCourse(AddCourseRequest request, StreamObserver<BasicResponse> responseObserver){
        try {
            if(!isNumeric(request.getCourseId())) throw new ValidateNumberException();
            if(Integer.parseInt(request.getCourseCredit())>3 || Integer.parseInt(request.getCourseCredit()) <= 0){
                throw new OverCourseCreditException();
            }
            BasicResponse basicResponse = EducationServiceGrpc.newBlockingStub(channel).addCourse(AddCourseRequest.newBuilder().setCourseId(request.getCourseId()).setProfessorName(request.getProfessorName()).setCourseName(request.getCourseName()).setCourseCredit(request.getCourseCredit()).setPrerequisiteList(request.getPrerequisiteList()).build());
            if(!basicResponse.getStatusMessage().equals("OVERLAP_COURSE_NUM")){
                if (!basicResponse.getStatusMessage().equals("NO_DATA_PREREQUISITE")){
                    logger.log("SUCCESS", MyLogger.getClassName(),MyLogger.getMethodName());
                    response(responseObserver,"200","요청에 성공하였습니다.");
                }else throw new NoDataPrerequisiteException();
            }else throw new OverlapCourseNumException();

        }catch (NoDataPrerequisiteException | OverlapCourseNumException | OverCourseCreditException | ValidateNumberException e){
            logger.warning("FAILED_ADD_COURSE",MyLogger.getClassName(),MyLogger.getMethodName(),e.getClass().getSimpleName());
            response(responseObserver,"406",e.getClass().getSimpleName());
            e.printStackTrace();
        }
    }

    public void deleteCourse(DeleteCourseRequest request, StreamObserver<BasicResponse> responseObserver){
        try {
            if(!isNumeric(request.getCourseId())) throw new ValidateNumberException();
            BasicResponse basicResponse = EducationServiceGrpc.newBlockingStub(channel).deleteCourse(DeleteCourseRequest.newBuilder().setCourseId(request.getCourseId()).build());
            if (basicResponse.getStatusMessage().equals("NO_DATA_COURSE")) {
                throw new NoCourseDataException();
            }else {
                logger.log("SUCCESS",MyLogger.getClassName(),MyLogger.getMethodName());
                response(responseObserver,"200","요청에 성공하였습니다.");
            }
        } catch (NoCourseDataException | ValidateNumberException e) {
            logger.warning("FAILED_DELETE_COURSE",MyLogger.getClassName(),MyLogger.getMethodName(),e.getClass().getSimpleName());
            response(responseObserver,"405",e.getClass().getSimpleName());
            e.printStackTrace();
        }
    }
}
