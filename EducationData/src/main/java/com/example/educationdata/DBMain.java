package com.example.educationdata;

import com.example.educationdata.service.EducationService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class DBMain {

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder
                .forPort(9001)
//                .addService(new CourseService())
//                .addService(new StudentService())
                .addService(new EducationService())
                .build();

        server.start();
        System.out.println("데이터 서버 구동 완료");
        server.awaitTermination();
    }
}
