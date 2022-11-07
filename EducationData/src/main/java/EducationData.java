import io.grpc.Server;
import io.grpc.ServerBuilder;
import service.EducationService;

import java.io.IOException;

public class EducationData {

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder
                .forPort(9001)
                .addService(new EducationService())
                .build();

        server.start();
        System.out.println("데이터 서버 구동 완료");
        server.awaitTermination();
    }
}
