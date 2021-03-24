package grpc.jake.cholesterol;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

public class CholesterolServiceRegistration {

	public static void main(String[] args) {
		
		
		try {
			//instance of JMDNS	
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

			//service information
			String service_type = "_cholesterol._tcp.local.";	//service-type.domain
			String service_name = "Cholesterol Services";
			int service_port = 50053;
			String service_desc = "Cholesterol Calculation and recommneded actions";
			
			//register service with ServiceInfo
			ServiceInfo serviceInfo = ServiceInfo.create(service_type,service_name,service_port,service_desc);
			jmdns.registerService(serviceInfo);
			System.out.printf("registering type %s , name %s , port %d ", service_type,service_name,service_port);
			//usually wait
			Thread.sleep(10000);
			
			System.out.println("\n unregistering services");
			//unregister services
			jmdns.unregisterAllServices();
			System.out.println("\n unregistering completed");
			
			Thread.sleep(10000);
			
			
			//surround with try/catch
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

}
