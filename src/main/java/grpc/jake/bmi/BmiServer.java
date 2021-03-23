package grpc.jake.bmi;

import java.io.IOException;

import grpc.jake.bmi.BMIGrpc.BMIImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class BmiServer extends BMIImplBase{
	
	public float bmi;

	public static void main(String[] args) {
		
		BmiServer bmiservice = new BmiServer();
		int port = 50052;

		try {
			
			Server server = ServerBuilder.forPort(port).addService(bmiservice).build().start();
			
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
	public void bmiCalculation(BmiRequest request,
	        StreamObserver<BmiReply> responseObserver) {
		
		//Receiving message
		float height = request.getHeight();
		float weight = request.getWeight();
		System.out.println("recieved height: " + height);
		System.out.println("recieved weight: " + weight);
		
		//BMI Calculation
		float height2 =height*height;
		float ans = weight/height2;
		bmi = ans;
		
		String message = "";
		if(ans < 18.5) {
			message = "Underweight";
		}else if(ans < 25 && ans >18.4) {
			message = "Healthy Weight";
		}else if(ans < 30 && ans >24.9) {
			message = "Overweight";
		}else if(ans >= 30) {
			message = "Obese";
		}
		
		
		System.out.println("sent BMI: " + ans);
		System.out.println("sent message: " + message);
		
		//Build a reply
		BmiReply reply = BmiReply.newBuilder().setBmi(ans).setBmimessage(message).build();
		
		//responding
		responseObserver.onNext(reply);
		
		//completing interaction
		responseObserver.onCompleted();
		
		
	}
	
    public void bmiAdvice(Empty request,
            StreamObserver<BmiAdvice> responseObserver) {
    	
    	String link1 = "https://www.cdc.gov/healthyweight/assessing/bmi/adult_bmi/index.html";
    	String link2 = "";
    	
    	if(bmi< 18.5) {
    		link2 ="https://www.cdc.gov/healthyweight/healthy_eating/index.html";
    	}else if(bmi < 25 && bmi >18.4) {
    		link2 ="https://www.cdc.gov/healthyweight/calories/index.html";
    	}else if(bmi < 30 && bmi >24.9) {
    		link2 ="https://www.cdc.gov/healthyweight/prevention/index.html";
		}else if(bmi >= 30) {
			link2 ="https://www.cdc.gov/healthyweight/losing_weight/index.html";
		}else if(bmi ==0) {
			link2 ="Invalid: Inputs not recieved";
		}
    	
    	//Build a reply
		BmiAdvice reply = BmiAdvice.newBuilder().setLink1(link1).setLink2(link2).build();
		
		//responding
		responseObserver.onNext(reply);
		
		//completing interaction
		responseObserver.onCompleted();

    }

}
