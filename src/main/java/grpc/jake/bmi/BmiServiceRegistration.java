package grpc.jake.bmi;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

public class BmiServiceRegistration {

	public static void main(String[] args) {
		
		
		try {
			//instance of JMDNS	
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

			//service information
			String service_type = "_bmi._tcp.local.";	//service-type.domain
			String service_name = "BMI Services";
			int service_port = 50052;
			String service_desc = "BMI Calculation and recommneded actions";
			
			//register service with ServiceInfo
			ServiceInfo serviceInfo = ServiceInfo.create(service_type,service_name,service_port,service_desc);
			jmdns.registerService(serviceInfo);
			System.out.printf("registering type %s , name %s , port %d ", service_type,service_name,service_port);
			//usually wait
			Thread.sleep(350000);
			
			//unregister services
			System.out.println("\n unregistering services");
			
			jmdns.unregisterAllServices();
			
			System.out.println("\n unregistering completed");
			
			
			
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
