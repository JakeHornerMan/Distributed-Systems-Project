package grpc.jake.bloodp;

import java.io.IOException;

import grpc.jake.bloodp.BloodpGrpc.BloodpImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class BloodpServer extends BloodpImplBase{
	
	public int systolic;
	public int diastolic;

	public static void main(String[] args) {
		
		BloodpServer bpservice = new BloodpServer();
		int port = 50051;
		
		try {
			
			Server server = ServerBuilder.forPort(port).addService(bpservice).build().start();
			
			System.out.println("server started at: " + port);
			
			server.awaitTermination();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void bloodpCalculation(BloodpRequest request,
	        StreamObserver<BloodpReply> responseObserver) {
		
		//Receiving message
		systolic = request.getSystolic();
		diastolic = request.getDiastolic();
		System.out.println("recieved Systolic: " + systolic);
		System.out.println("recieved Diastolic: " + diastolic);
		
		//Calculate Response
		String bp = systolic+"/"+diastolic+" mmHg";
		String message = "";

		if(systolic < 120 && diastolic < 80) {
			message = "Normal";
		}else if(systolic < 140 && diastolic < 90 && systolic >= 120 && diastolic >= 80) {
			message = "Elevated";
		}else if(systolic >= 140 && diastolic >= 90) {
			message = "Hypertension";
		}else {
			message = "Hypertension";
		}
		
		//Build Response
		BloodpReply reply = BloodpReply.newBuilder()
				.setBp(bp)
				.setBpmessage(message)
				.build();
		
		//responding
		responseObserver.onNext(reply);
		
		//completing interaction
		responseObserver.onCompleted();
	}
	
	public void bloodpAdvice(Empty request,
	        StreamObserver<BloodpAnswer> responseObserver) {
		
		String helplink1 = "https://www.cdc.gov/bloodpressure/about.htm";
		String helplink2 = "";
		
		if(systolic < 120 && diastolic < 80) {
			helplink2 = "https://www.cdc.gov/bloodpressure/risk_factors.htm";
		}else if(systolic < 140 && diastolic < 90 && systolic >= 120 && diastolic >= 80) {
			helplink2 = "https://www.cdc.gov/bloodpressure/prevent_manage.htm";
		}else if(systolic >= 140 && diastolic >= 90) {
			helplink2 = "https://www.cdc.gov/bloodpressure/manage.htm";
		}else {
			helplink2 = "https://www.cdc.gov/bloodpressure/manage.htm";
		}
		
		BloodpAnswer reply = BloodpAnswer.newBuilder()
				.setHelplink1(helplink1)
				.setHelplink2(helplink2)
				.build();
		
		//responding
		responseObserver.onNext(reply);
		
		//completing interaction
		responseObserver.onCompleted();
		
	}

}
