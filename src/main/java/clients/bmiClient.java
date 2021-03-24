package clients;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;

import grpc.jake.bloodp.BloodpAnswer;
import grpc.jake.bloodp.BloodpGrpc;
import grpc.jake.bloodp.BloodpRequest;
import grpc.jake.bloodp.BloodpGrpc.BloodpBlockingStub;
import grpc.jake.bmi.BMIGrpc;
import grpc.jake.bmi.BMIGrpc.BMIBlockingStub;
import grpc.jake.bmi.BmiAdvice;
import grpc.jake.bmi.BmiReply;
import grpc.jake.bmi.BmiRequest;
import grpc.jake.bmi.Empty;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class BmiClient {
	
	private static class MyServiceListener implements ServiceListener{

		public void serviceAdded(ServiceEvent event) {
			System.out.println("Service added: "+event.getInfo());
			
		}

		public void serviceRemoved(ServiceEvent event) {
			System.out.println("Service removed: "+event.getInfo());
			
		}

		public void serviceResolved(ServiceEvent event) {
			System.out.println("Service resolved: "+event.getInfo());
			
			ServiceInfo serviceinfo = event.getInfo();
			
			System.out.println("host "+ serviceinfo.getHostAddresses()[0]);
			System.out.println("port "+ serviceinfo.getPort());
			System.out.println("type "+ serviceinfo.getType());
			System.out.println("name "+ serviceinfo.getName());
			System.out.println("comp.name "+ serviceinfo.getServer().replace(".local.", ""));
			System.out.println("desc/propertys "+ serviceinfo.getNiceTextString());
			
			getbmiCalculation(serviceinfo.getHostAddresses()[0],serviceinfo.getPort());
			getbmiAdvice(serviceinfo.getHostAddresses()[0],serviceinfo.getPort());
		}
		
	}

	public static void main(String[] args) {
		
		
		try {
			//get instance of jmDNS
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
			
			//discover service based on service type
			String service_type = "_bmi._tcp.local.";
			
			//i need to listen for services added/removed etc
			jmdns.addServiceListener(service_type, new MyServiceListener());
			
			Thread.sleep(10000);
			
			//jmdns.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void getbmiCalculation(String host, int port) {
		
		ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
		
		BMIBlockingStub blockingStub = BMIGrpc.newBlockingStub(channel);
		
		BmiRequest request = BmiRequest.newBuilder().setHeight(1.70f).setWeight(67.0f).build();
		
		BmiReply response = blockingStub.bmiCalculation(request);
		
		System.out.println("BMI: "+response.getBmi());
		System.out.println("Fitness Condition: "+response.getBmimessage());
		
	}
	
	public static void getbmiAdvice(String host, int port) {
		
		ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
		
		BMIBlockingStub blockingStub = BMIGrpc.newBlockingStub(channel);
		
		Empty request = Empty.newBuilder().build();
		
		BmiAdvice response = blockingStub.bmiAdvice(request);
		
		System.out.println("BMI: "+response.getLink1());
		System.out.println("Fitness Condition: "+response.getLink2());
		
	}
}
