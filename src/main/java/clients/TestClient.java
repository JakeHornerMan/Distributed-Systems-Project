package clients;

import grpc.jake.greet.GreeterGrpc;
import grpc.jake.greet.GreeterGrpc.GreeterBlockingStub;
import grpc.jake.greet.HelloReply;
import grpc.jake.greet.HelloRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class TestClient {
	
	public static void main(String[] args) {
			
		String host = "localhost";
		int port = 5001;
		
		ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
		System.out.println("Step1");
		
		//retrieving the client stub
		GreeterBlockingStub blockingStub = GreeterGrpc.newBlockingStub(channel);
		System.out.println("Step2");
		
		//preparing request
		HelloRequest request = HelloRequest.newBuilder().setName("Jake ").build();
		System.out.println("Step3");
		
		//sending the message reply & receiving Reply
		HelloReply reply = blockingStub.sayHello(request);
		System.out.println("Step4");
		
		System.out.println("Responce Bmi: "+reply.getMessage());
			
	}
}
