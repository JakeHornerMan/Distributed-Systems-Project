package clients;

import grpc.jake.bmi.BMIGrpc;
import grpc.jake.bmi.BMIGrpc.BMIBlockingStub;
import grpc.jake.bmi.BmiReply;
import grpc.jake.bmi.BmiRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class bmiClient {

	public static void main(String[] args) {
		
		String host = "localhost";
		int port = 50052;
		
		ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
		
		//retrieving the client stub
		BMIBlockingStub blockingStub = BMIGrpc.newBlockingStub(channel);
		
		//preparing request
		BmiRequest request = BmiRequest.newBuilder().setHeight(1.7f).setWeight(67.0f).build();
		
		//sending the message reply & receiving Reply
		BmiReply reply =blockingStub.bmiCalculation(request);
		
		System.out.println("Responce Bmi: "+reply.getBmi());
		
	}

}
