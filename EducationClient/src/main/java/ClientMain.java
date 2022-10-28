import Manager.controller.ManagerController;
import Student.controller.StudentController;
import com.grpc.education.EducationServiceGrpc;
import com.grpc.education.StudentLoginRequest;
import com.grpc.education.StudentResponse;
import global.Comment;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Scanner;

public class ClientMain {

    private static ManagedChannel ch;
    private static EducationServiceGrpc.EducationServiceBlockingStub stub;

    private static ManagerController managerController;
    private static StudentController studentController;
    private static Comment comment;
    private static Scanner sc;

    public static void main(String[] args) {
        inital();
        System.out.println("클라이언트 구동 완료.");
        login();
        Exit:
        while (true){
            switch (comment.initial()){
                case 1:
                    studentController.initial();
                    break;
                case 2:
                    managerController.initial();
                    break;
                case 0:
                    break Exit;
            }
        }
    }

    private static void login() {
        System.out.print("ID: "); String studentId = sc.next();
        System.out.print("PASSWORD: "); String password = sc.next();
        StudentResponse login = stub.login(StudentLoginRequest.newBuilder().setStudentId(studentId).setPassword(password).build());
        System.out.println(login.getStatus());
    }

    public static void inital(){
        ch = ManagedChannelBuilder.forAddress("localhost", 9000).usePlaintext().build();
        stub = EducationServiceGrpc.newBlockingStub(ch);
        managerController = new ManagerController(stub);
        studentController = new StudentController(stub);
        comment = new Comment();
        sc=new Scanner(System.in);
    }


}
