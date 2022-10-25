package com.example.educationserver;

import com.example.educationserver.service.EducationService;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GrpcServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        run();
    }

    private static void run() throws IOException, InterruptedException {
        //DB 연결
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9001).usePlaintext().build();
        System.out.println("데이터 연결 완료");

        //Server 가동
        Server server = ServerBuilder
                .forPort(9000)
                .addService(new EducationService(channel))
                .build();

        System.out.println("서버 가동 완료");
        server.start();
        server.awaitTermination();
    }
}
