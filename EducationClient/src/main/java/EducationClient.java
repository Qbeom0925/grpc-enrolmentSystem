import com.grpc.education.EducationServiceGrpc;
import com.grpc.education.StudentLoginRequest;
import com.grpc.education.StudentResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import manager.controller.ManagerController;
import student.controller.StudentController;

import java.util.Scanner;

public class EducationClient {

    private static ManagedChannel ch;
    private static EducationServiceGrpc.EducationServiceBlockingStub stub;

    private static ManagerController managerController;
    private static StudentController studentController;
    private static Scanner sc;

    private static StudentResponse studentResponse;

    public static void main(String[] args) {
        inital();
        System.out.println("클라이언트 구동 완료.");
        Exit:
        while (true){
            switch (login()){
                case 1:
                    studentController.initial(studentResponse);
                    break;
                case 2:
                    managerController.initial();
                    break;
                case 0:
                    break Exit;
            }
        }
    }

    private static int login() {
        System.out.print("ID: "); String studentId = sc.next();
        System.out.print("PASSWORD: "); String password = sc.next();
        studentResponse = stub.login(StudentLoginRequest.newBuilder().setStudentId(studentId).setPassword(password).build());
        switch (studentResponse.getStatus()){
            case "S":
                return 1;
            case "M":
                return 2;
            default:
                System.out.println("로그인 실패");
        }
        return -1;
    }

    public static void inital(){
        ch = ManagedChannelBuilder.forAddress("localhost", 9000).usePlaintext().build();
        stub = EducationServiceGrpc.newBlockingStub(ch);
        managerController = new ManagerController(stub);
        studentController = new StudentController(stub);
        sc=new Scanner(System.in);
    }


}
