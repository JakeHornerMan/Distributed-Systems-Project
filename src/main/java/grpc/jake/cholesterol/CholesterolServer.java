package grpc.jake.cholesterol;

import java.io.IOException;


import grpc.jake.cholesterol.CholesterolGrpc.CholesterolImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class CholesterolServer extends CholesterolImplBase { 
	
	public int total=0;
	public int ldl=0;
	public int hdl=0;
	public int tri=0;

	public static void main(String[] args) {
		CholesterolServer cholestservice = new CholesterolServer();
		int port = 50053;
		
		try {
			
			Server server = ServerBuilder.forPort(port).addService(cholestservice).build().start();
			
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
	public void cholesterolCalculation(CholesterolRequest request,
	        StreamObserver<CholesterolReply> responseObserver) {
		
		//Receiving message
		total = request.getTotal();
		ldl = request.getLdl();
		hdl = request.getHdl();
		tri = request.getTriglycerides();
		
		System.out.println("recieved Total: " + total);
		System.out.println("recieved LDL: " + ldl);
		System.out.println("recieved HDL: " + hdl);
		System.out.println("recieved Triglycerides: " + tri);
		
		//Calculate Response
		String anstotal = "";
		String ansldl = ""; 
		String anshdl = ""; 
		String anstri = ""; 
		
		if(total< 200) {
			anstotal = "Healthy";
		}else {
			anstotal = "Elevated";
		}
		
		if(ldl<100) {
			ansldl = "Healthy";
		}else {
			ansldl = "Elevated";
		}
		
		if(hdl>=60) {
			anshdl = "Healthy";
		}else {
			anshdl = "Deficit Amount";
		}
		
		if(tri<150) {
			anstri = "Healthy"; 
		}else {
			anstri = "Elevated";
		}
		
		CholesterolReply reply = CholesterolReply.newBuilder()
				.setTotal(anstotal)
				.setAnsldl(ansldl)
				.setAnshdl(anshdl)
				.setAnstri(anstri)
				.build();
		
		//responding
		responseObserver.onNext(reply);
		
		//completing interaction
		responseObserver.onCompleted();
	}
	public void cholesterolAdvice(Empty request,
	        StreamObserver<CholesterolAnswer> responseObserver) {
		
		String anshl = "https://www.cdc.gov/cholesterol/ldl_hdl.htm";
		
		if(total< 200 && total != 0|| ldl < 100 && ldl != 0|| hdl >= 60 && hdl != 0|| tri < 150 && tri != 0) {
			anshl = "https://www.cdc.gov/cholesterol/risk_factors.htm";
		}else if(total > 200 && total != 0|| ldl > 100&&ldl != 0|| hdl <= 60&&hdl != 0|| tri > 150&& tri != 0){
			anshl = "https://www.cdc.gov/cholesterol/ldl_hdl.htm";
		}else if(total == 0 || ldl == 0 || hdl == 0 || tri == 0){
			anshl = "Inavalid: Did not recieve field input";
		}
			
		
		
		CholesterolAnswer reply2 = CholesterolAnswer.newBuilder()
				.setHelplink1("https://www.cdc.gov/cholesterol/about.htm")
				.setHelplink2(anshl)
				.build();
		
		//responding
		responseObserver.onNext(reply2);
		
		//completing interaction
		responseObserver.onCompleted();
	}
}
