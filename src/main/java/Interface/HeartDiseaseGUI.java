package Interface;

import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextPane;

import clients.BmiClient;
import grpc.jake.bmi.BMIGrpc;
import grpc.jake.bmi.BmiAdvice;
import grpc.jake.bmi.BmiReply;
import grpc.jake.bmi.BmiRequest;
import grpc.jake.bmi.Empty;
import grpc.jake.bmi.BMIGrpc.BMIBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.awt.Font;
import java.awt.Canvas;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;

public class HeartDiseaseGUI {

	//private static BmiServiceBlockingStub blockingStub;
	//private static BmiServiceStub asyncStub;
	private ServiceInfo bmiServiceInfo;
	
	private JFrame frame;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField heighttf;
	private JTextField weighttf;
	private JSeparator separator;
	private JSeparator separator_1;
	private JLabel lblNewLabel_2;
	private JTextPane textPane;
	private JTextArea textArea_1;
	private JLabel lblNewLabel_3;
	private JTextArea textArea;
	private JTextArea bmitotal;
	private JTextArea bmicondition;
	private JTextArea bmihelplink1;
	private JTextArea bmihelplink2;

	/**
	 * Launch the application.
	 */
	public String bmitotalvalue;
	public String bmiconditionvalue;
	public String bmihelplink1value;
	public String bmihelplink2value;
	
	public double bmiheight;
	public double bmiweight;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HeartDiseaseGUI window = new HeartDiseaseGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HeartDiseaseGUI() {
		
		initialize();
	}
	
	public void discoverBmiService(String service_type) {
		try {
			//get instance of jmDNS
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
			
			//i need to listen for services added/removed etc
			jmdns.addServiceListener(service_type, new ServiceListener() {
			
			@Override
			public void serviceResolved(ServiceEvent event) {
				System.out.println("Math Service resolved: " + event.getInfo());

				bmiServiceInfo = event.getInfo();

				int port = bmiServiceInfo.getPort();
				
				System.out.println("resolving " + service_type + " with properties ...");
				System.out.println("\t port: " + port);
				System.out.println("\t type:"+ event.getType());
				System.out.println("\t name: " + event.getName());
				System.out.println("\t description/properties: " + bmiServiceInfo.getNiceTextString());
				System.out.println("\t host: " + bmiServiceInfo.getHostAddresses()[0]);
			
				
			}
			
			@Override
			public void serviceRemoved(ServiceEvent event) {
				System.out.println("Service removed: " + event.getInfo());

				
			}
			
			@Override
			public void serviceAdded(ServiceEvent event) {
				System.out.println("Service added: " + event.getInfo());

				
			}
		});
		
		// Wait a bit
		Thread.sleep(2000);
		
		jmdns.close();

		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Microsoft JhengHei", Font.PLAIN, 11));
		frame.setBounds(100, 100, 450, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		heighttf = new JTextField();
		heighttf.setBounds(338, 11, 86, 20);
		frame.getContentPane().add(heighttf);
		heighttf.setColumns(10);
		
		weighttf = new JTextField();
		weighttf.setBounds(338, 42, 86, 20);
		frame.getContentPane().add(weighttf);
		weighttf.setColumns(10);
		
		JButton bmibtn = new JButton("Calculate");
		bmibtn.setFont(new Font("Microsoft JhengHei", Font.BOLD, 11));
		bmibtn.setBounds(279, 73, 145, 27);
		frame.getContentPane().add(bmibtn);
		
		separator = new JSeparator();
		separator.setBounds(0, 200, 434, 2);
		frame.getContentPane().add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(-30, 441, 483, 2);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(-17, 696, 483, 2);
		frame.getContentPane().add(separator_2);
		
		JLabel lblNewLabel = new JLabel("Height:");
		lblNewLabel.setFont(new Font("Microsoft JhengHei", Font.BOLD, 12));
		lblNewLabel.setBounds(282, 12, 46, 19);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Weight:");
		lblNewLabel_1.setFont(new Font("Microsoft JhengHei", Font.BOLD, 12));
		lblNewLabel_1.setBounds(282, 42, 46, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Condition:");
		lblNewLabel_2.setFont(new Font("Microsoft JhengHei", Font.BOLD, 16));
		lblNewLabel_2.setBounds(174, 119, 107, 20);
		frame.getContentPane().add(lblNewLabel_2);
		
		JTextArea bmibiota = new JTextArea();
		bmibiota.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		bmibiota.setText("Measure your blood pressure regularly to \r\nhelp your health care team diagnose any \r\nhealth problems early. \r\nYou and your health care team can take steps \r\nto control your blood pressure if it is too high.");
		bmibiota.setBounds(10, 208, 262, 106);
		frame.getContentPane().add(bmibiota);
		bmibiota.setEditable(false);
		
		lblNewLabel_3 = new JLabel("BMI: ");
		lblNewLabel_3.setFont(new Font("Microsoft JhengHei", Font.BOLD, 16));
		lblNewLabel_3.setBounds(10, 119, 59, 20);
		frame.getContentPane().add(lblNewLabel_3);
		
		bmitotal = new JTextArea();
		bmitotal.setFont(new Font("Microsoft JhengHei", Font.BOLD, 16));
		bmitotal.setBounds(79, 119, 85, 27);
		bmitotal.setText(bmitotalvalue);
		frame.getContentPane().add(bmitotal);
		bmitotal.setEditable(false);
		
		bmicondition = new JTextArea();
		bmicondition.setText(bmiconditionvalue);
		bmicondition.setFont(new Font("Microsoft JhengHei", Font.BOLD, 16));
		bmicondition.setEditable(false);
		bmicondition.setBounds(263, 119, 161, 27);
		frame.getContentPane().add(bmicondition);
		
		JLabel lblHelpfulLinks = new JLabel("Helpful links:");
		lblHelpfulLinks.setFont(new Font("Microsoft JhengHei", Font.BOLD, 12));
		lblHelpfulLinks.setBounds(10, 151, 86, 19);
		frame.getContentPane().add(lblHelpfulLinks);
		
		bmihelplink1 = new JTextArea();
		bmihelplink1.setText(bmihelplink1value);
		bmihelplink1.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		bmihelplink1.setEditable(false);
		bmihelplink1.setBounds(101, 150, 323, 20);
		frame.getContentPane().add(bmihelplink1);
		
		bmihelplink2 = new JTextArea();
		bmihelplink2.setText(bmihelplink2value);
		bmihelplink2.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		bmihelplink2.setEditable(false);
		bmihelplink2.setBounds(101, 176, 323, 20);
		frame.getContentPane().add(bmihelplink2);	
		
		JTextArea bmibiota_1 = new JTextArea();
		bmibiota_1.setText("The body mass index (BMI) is a measurement \r\that uses your height and weight to work \r\nout if your weight is healthy. \r\nThe BMI calculation divides an adult's \r\nweight in kilograms by their height in \r\nmetres squared.");
		bmibiota_1.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		bmibiota_1.setEditable(false);
		bmibiota_1.setBounds(7, 10, 262, 106);
		frame.getContentPane().add(bmibiota_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(338, 209, 86, 20);
		frame.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(338, 240, 86, 20);
		frame.getContentPane().add(textField_1);
		
		JLabel lblSystolic = new JLabel("Systolic:");
		lblSystolic.setFont(new Font("Microsoft JhengHei", Font.BOLD, 12));
		lblSystolic.setBounds(279, 212, 59, 19);
		frame.getContentPane().add(lblSystolic);
		
		JLabel lblDystolic = new JLabel("Dystolic: ");
		lblDystolic.setFont(new Font("Microsoft JhengHei", Font.BOLD, 12));
		lblDystolic.setBounds(279, 240, 59, 19);
		frame.getContentPane().add(lblDystolic);
		
		JButton bmibtn_1 = new JButton("Calculate");
		bmibtn_1.setFont(new Font("Microsoft JhengHei", Font.BOLD, 11));
		bmibtn_1.setBounds(279, 271, 145, 27);
		frame.getContentPane().add(bmibtn_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Blood Pressure");
		lblNewLabel_3_1.setFont(new Font("Microsoft JhengHei", Font.BOLD, 16));
		lblNewLabel_3_1.setBounds(13, 327, 119, 20);
		frame.getContentPane().add(lblNewLabel_3_1);
		
		JTextArea bmitotal_1 = new JTextArea();
		bmitotal_1.setText((String) null);
		bmitotal_1.setFont(new Font("Microsoft JhengHei", Font.BOLD, 16));
		bmitotal_1.setEditable(false);
		bmitotal_1.setBounds(142, 324, 130, 23);
		frame.getContentPane().add(bmitotal_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Condition:");
		lblNewLabel_3_1_1.setFont(new Font("Microsoft JhengHei", Font.BOLD, 16));
		lblNewLabel_3_1_1.setBounds(13, 358, 86, 20);
		frame.getContentPane().add(lblNewLabel_3_1_1);
		
		JTextArea bmitotal_1_1 = new JTextArea();
		bmitotal_1_1.setText((String) null);
		bmitotal_1_1.setFont(new Font("Microsoft JhengHei", Font.BOLD, 16));
		bmitotal_1_1.setEditable(false);
		bmitotal_1_1.setBounds(142, 355, 130, 23);
		frame.getContentPane().add(bmitotal_1_1);
		
		JLabel lblHelpfulLinks_1 = new JLabel("Helpful links:");
		lblHelpfulLinks_1.setFont(new Font("Microsoft JhengHei", Font.BOLD, 12));
		lblHelpfulLinks_1.setBounds(10, 402, 86, 19);
		frame.getContentPane().add(lblHelpfulLinks_1);
		
		JTextArea bmihelplink1_1 = new JTextArea();
		bmihelplink1_1.setText((String) null);
		bmihelplink1_1.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		bmihelplink1_1.setEditable(false);
		bmihelplink1_1.setBounds(101, 410, 323, 20);
		frame.getContentPane().add(bmihelplink1_1);
		
		JTextArea bmihelplink1_1_1 = new JTextArea();
		bmihelplink1_1_1.setText((String) null);
		bmihelplink1_1_1.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		bmihelplink1_1_1.setEditable(false);
		bmihelplink1_1_1.setBounds(101, 389, 323, 20);
		frame.getContentPane().add(bmihelplink1_1_1);
		
		JTextArea txtrHighCholesterolUsually = new JTextArea();
		txtrHighCholesterolUsually.setText("High cholesterol usually has no signs or \r\nsymptoms.\r\nThe only way to know whether someone\r\nhas high cholesterol is to get a blood \r\ntest called “lipid profile”. ");
		txtrHighCholesterolUsually.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		txtrHighCholesterolUsually.setEditable(false);
		txtrHighCholesterolUsually.setBounds(10, 454, 262, 89);
		frame.getContentPane().add(txtrHighCholesterolUsually);
		
		JLabel lblSystolic_1 = new JLabel("Total:");
		lblSystolic_1.setFont(new Font("Microsoft JhengHei", Font.BOLD, 12));
		lblSystolic_1.setBounds(282, 458, 46, 19);
		frame.getContentPane().add(lblSystolic_1);
		
		JLabel lblSystolic_2 = new JLabel("LDL:");
		lblSystolic_2.setFont(new Font("Microsoft JhengHei", Font.BOLD, 12));
		lblSystolic_2.setBounds(282, 476, 46, 19);
		frame.getContentPane().add(lblSystolic_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(338, 455, 86, 20);
		frame.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(338, 476, 86, 20);
		frame.getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(338, 496, 86, 20);
		frame.getContentPane().add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(338, 516, 86, 20);
		frame.getContentPane().add(textField_7);
		
		JLabel lblSystolic_2_1 = new JLabel("HDL:");
		lblSystolic_2_1.setFont(new Font("Microsoft JhengHei", Font.BOLD, 12));
		lblSystolic_2_1.setBounds(282, 496, 46, 19);
		frame.getContentPane().add(lblSystolic_2_1);
		
		JLabel lblSystolic_2_2 = new JLabel("Systolic");
		lblSystolic_2_2.setFont(new Font("Microsoft JhengHei", Font.BOLD, 12));
		lblSystolic_2_2.setBounds(282, 516, 46, 20);
		frame.getContentPane().add(lblSystolic_2_2);
		
		JButton bmibtn_1_1 = new JButton("Calculate");
		bmibtn_1_1.setFont(new Font("Microsoft JhengHei", Font.BOLD, 11));
		bmibtn_1_1.setBounds(279, 542, 145, 27);
		frame.getContentPane().add(bmibtn_1_1);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("Total:");
		lblNewLabel_3_1_2.setFont(new Font("Microsoft JhengHei", Font.BOLD, 16));
		lblNewLabel_3_1_2.setBounds(13, 576, 46, 20);
		frame.getContentPane().add(lblNewLabel_3_1_2);
		
		JLabel lblNewLabel_3_1_2_1 = new JLabel("LDL:");
		lblNewLabel_3_1_2_1.setFont(new Font("Microsoft JhengHei", Font.BOLD, 16));
		lblNewLabel_3_1_2_1.setBounds(197, 576, 46, 20);
		frame.getContentPane().add(lblNewLabel_3_1_2_1);
		
		JTextArea bmitotal_1_2 = new JTextArea();
		bmitotal_1_2.setText((String) null);
		bmitotal_1_2.setFont(new Font("Microsoft JhengHei", Font.BOLD, 16));
		bmitotal_1_2.setEditable(false);
		bmitotal_1_2.setBounds(57, 577, 130, 23);
		frame.getContentPane().add(bmitotal_1_2);
		
		JTextArea bmitotal_1_3 = new JTextArea();
		bmitotal_1_3.setText((String) null);
		bmitotal_1_3.setFont(new Font("Microsoft JhengHei", Font.BOLD, 16));
		bmitotal_1_3.setEditable(false);
		bmitotal_1_3.setBounds(249, 573, 130, 23);
		frame.getContentPane().add(bmitotal_1_3);
		
		JLabel lblNewLabel_3_1_2_2 = new JLabel("HDL:");
		lblNewLabel_3_1_2_2.setFont(new Font("Microsoft JhengHei", Font.BOLD, 16));
		lblNewLabel_3_1_2_2.setBounds(10, 605, 46, 20);
		frame.getContentPane().add(lblNewLabel_3_1_2_2);
		
		JLabel lblNewLabel_3_1_2_2_1 = new JLabel("Triglycerides:");
		lblNewLabel_3_1_2_2_1.setFont(new Font("Microsoft JhengHei", Font.BOLD, 16));
		lblNewLabel_3_1_2_2_1.setBounds(181, 607, 100, 18);
		frame.getContentPane().add(lblNewLabel_3_1_2_2_1);
		
		JTextArea bmitotal_1_2_1 = new JTextArea();
		bmitotal_1_2_1.setText((String) null);
		bmitotal_1_2_1.setFont(new Font("Microsoft JhengHei", Font.BOLD, 16));
		bmitotal_1_2_1.setEditable(false);
		bmitotal_1_2_1.setBounds(50, 607, 130, 23);
		frame.getContentPane().add(bmitotal_1_2_1);
		
		JTextArea bmitotal_1_2_1_1 = new JTextArea();
		bmitotal_1_2_1_1.setText((String) null);
		bmitotal_1_2_1_1.setFont(new Font("Microsoft JhengHei", Font.BOLD, 16));
		bmitotal_1_2_1_1.setEditable(false);
		bmitotal_1_2_1_1.setBounds(286, 607, 138, 23);
		frame.getContentPane().add(bmitotal_1_2_1_1);
		
		JLabel lblHelpfulLinks_1_1 = new JLabel("Helpful links:");
		lblHelpfulLinks_1_1.setFont(new Font("Microsoft JhengHei", Font.BOLD, 12));
		lblHelpfulLinks_1_1.setBounds(10, 654, 86, 19);
		frame.getContentPane().add(lblHelpfulLinks_1_1);
		
		JTextArea bmihelplink1_1_1_1 = new JTextArea();
		bmihelplink1_1_1_1.setText((String) null);
		bmihelplink1_1_1_1.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		bmihelplink1_1_1_1.setEditable(false);
		bmihelplink1_1_1_1.setBounds(101, 644, 323, 20);
		frame.getContentPane().add(bmihelplink1_1_1_1);
		
		JTextArea bmihelplink1_1_2 = new JTextArea();
		bmihelplink1_1_2.setText((String) null);
		bmihelplink1_1_2.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		bmihelplink1_1_2.setEditable(false);
		bmihelplink1_1_2.setBounds(101, 665, 323, 20);
		frame.getContentPane().add(bmihelplink1_1_2);
		
		
		//Application Code
		bmibtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String bmi_service_type = "_bmi._tcp.local.";
				discoverBmiService(bmi_service_type);
				getValuesService1Bmi();
				getValuesService2Bmi();
			}
		});
		
	}
	
	public void getValuesService1Bmi() {
		
		bmiheight= Double.parseDouble(heighttf.getText());
		bmiweight= Double.parseDouble(weighttf.getText());
		
		//service 1
		
		ManagedChannel channel = ManagedChannelBuilder.forAddress(bmiServiceInfo.getHostAddresses()[0], bmiServiceInfo.getPort()).usePlaintext().build();
		
		BMIBlockingStub blockingStub = BMIGrpc.newBlockingStub(channel);
		
		BmiRequest request1 = BmiRequest.newBuilder().setHeight(bmiheight).setWeight(bmiweight).build();
		
		BmiReply response1 = blockingStub.bmiCalculation(request1);
		
		bmitotalvalue = String.valueOf(response1.getBmi());
		bmiconditionvalue = response1.getBmimessage();
		
		System.out.println(bmitotalvalue);
		System.out.println(bmiconditionvalue);
		
		//setting value in GUI
		bmitotal.setText(bmitotalvalue);
		bmicondition.setText(bmiconditionvalue);
		//bmihelplink1.setText(bmihelplink1value);
		//bmihelplink2.setText(bmihelplink2value);
		
	}
	
	public void getValuesService2Bmi() {
		
		//service 2		
		ManagedChannel channel2 = ManagedChannelBuilder.forAddress(bmiServiceInfo.getHostAddresses()[0], bmiServiceInfo.getPort()).usePlaintext().build();
		
		BMIBlockingStub blockingStub2 = BMIGrpc.newBlockingStub(channel2);
		
		Empty request2 = Empty.newBuilder().build();
		
		BmiAdvice response2 = blockingStub2.bmiAdvice(request2);
		
		bmihelplink1value = response2.getLink1();
		bmihelplink2value = response2.getLink2();
		
		System.out.println(bmihelplink1value);
		System.out.println(bmihelplink2value);
		
		bmihelplink1.setText(bmihelplink1value);
		bmihelplink2.setText(bmihelplink2value);
	}
}
