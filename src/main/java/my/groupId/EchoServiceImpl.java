package my.groupId;

import io.grpc.stub.StreamObserver;
import io.quarkus.grpc.GrpcService;
import com.example.grpcbin.EchoRequest;
import com.example.grpcbin.EchoResponse;
import com.example.grpcbin.EchoServiceGrpc;

@GrpcService
public class EchoServiceImpl extends EchoServiceGrpc.EchoServiceImplBase {

    @Override
    public void echo(EchoRequest request, StreamObserver<EchoResponse> responseObserver) {
        String message = "Hello, " + request.getMessage();
        EchoResponse response = EchoResponse.newBuilder().setMessage(message).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
