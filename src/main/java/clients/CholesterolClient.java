package clients;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;

import grpc.jake.bloodp.BloodpAnswer;
import grpc.jake.cholesterol.CholesterolAnswer;
import grpc.jake.cholesterol.CholesterolGrpc;
import grpc.jake.cholesterol.CholesterolGrpc.CholesterolBlockingStub;
import grpc.jake.cholesterol.CholesterolReply;
import grpc.jake.cholesterol.CholesterolRequest;
import grpc.jake.cholesterol.Empty;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class CholesterolClient {
	
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
			
			getCholesterolCalculation(serviceinfo.getHostAddresses()[0],serviceinfo.getPort());
			getCholesterolAdvice(serviceinfo.getHostAddresses()[0],serviceinfo.getPort());
		}
		
	}

	public static void main(String[] args) {
		
		
		try {
			//get instance of jmDNS
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
			
			//discover service based on service type
			String service_type = "_cholesterol._tcp.local.";
			
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
	
	public static void getCholesterolCalculation(String host, int port) {
		
		ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
		
		CholesterolBlockingStub blockingStub = CholesterolGrpc.newBlockingStub(channel);
		
		CholesterolRequest request = CholesterolRequest.newBuilder().setTotal(10).setLdl(10).setHdl(10).setTriglycerides(10).build();
		
		CholesterolReply response = blockingStub.cholesterolCalculation(request);
		
		System.out.println(response.getTotal());
		System.out.println(response.getAnsldl());
		System.out.println(response.getAnshdl());
		System.out.println(response.getAnstri());
		
	}
	
	public static void getCholesterolAdvice(String host, int port) {
		
		ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
		
		CholesterolBlockingStub blockingStub = CholesterolGrpc.newBlockingStub(channel);
		
		Empty request = Empty.newBuilder().build();
		
		CholesterolAnswer response = blockingStub.cholesterolAdvice(request);
		
		System.out.println("Read more about Cholesterol: "+response.getHelplink1());
		System.out.println("Relavent reading for your condition: "+response.getHelplink2());
	}

}
