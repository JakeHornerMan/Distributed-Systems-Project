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
import grpc.jake.bloodp.BloodpGrpc.BloodpBlockingStub;
import grpc.jake.bloodp.BloodpReply;
import grpc.jake.bloodp.BloodpRequest;
import grpc.jake.bloodp.Empty;
import grpc.jake.bmi.BMIGrpc.BMIBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class BloodpClient {
	
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
			
			getBloodpCalculation(serviceinfo.getHostAddresses()[0],serviceinfo.getPort());
			getBloodpAdvice(serviceinfo.getHostAddresses()[0],serviceinfo.getPort());
		}
		
	}

	public static void main(String[] args) {
		
		
		try {
			//get instance of jmDNS
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
			
			//discover service based on service type
			String service_type = "_bloodp._tcp.local.";
			
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
	
	//RPC CALL
	public static void getBloodpCalculation(String host, int port) {
		
		ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
		
		BloodpBlockingStub blockingStub = BloodpGrpc.newBlockingStub(channel);
		
		//prepare request
		BloodpRequest request = BloodpRequest.newBuilder().setSystolic(140).setDiastolic(90).build();
		
		BloodpReply response = blockingStub.bloodpCalculation(request);
		
		System.out.println("Blood Pressure: "+response.getBp());
		System.out.println("Blood Pressure Condition: "+response.getBpmessage());
		
	}
	
	public static void getBloodpAdvice(String host, int port) {
			
			ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
			
			BloodpBlockingStub blockingStub = BloodpGrpc.newBlockingStub(channel);
			
			//prepare request
			Empty request = Empty.newBuilder().build();
			
			BloodpAnswer response = blockingStub.bloodpAdvice(request);
			
			System.out.println("Read more about blood pressure: "+response.getHelplink1());
			System.out.println("Relavent Read for your condition: "+response.getHelplink2());
			
	}

}
