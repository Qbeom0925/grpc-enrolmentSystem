package com.example.educationclient;

import com.example.educationclient.Manager.controller.ManagerController;
import com.example.educationclient.Student.controller.StudentController;
import com.example.educationclient.global.Comment;
import com.grpc.education.BasicRequest;
import com.grpc.education.EducationServiceGrpc;
import com.grpc.education.GetAllStudentsDataResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.List;

public class ClientMain {

    private static ManagedChannel ch;
    private static EducationServiceGrpc.EducationServiceBlockingStub stub;

    private static ManagerController managerController;
    private static StudentController studentController;
    private static Comment comment;

    public static void main(String[] args) {
        inital();
        System.out.println("클라이언트 구동 완료.");

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

    public static void inital(){
        ch = ManagedChannelBuilder.forAddress("localhost", 9000).usePlaintext().build();
        stub = EducationServiceGrpc.newBlockingStub(ch);
        managerController = new ManagerController(stub);
        studentController = new StudentController(stub);
        comment = new Comment();
    }

}
