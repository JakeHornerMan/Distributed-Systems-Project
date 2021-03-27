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
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

import clients.BmiClient;
//import grpc.jake.bloodp.Empty;
import grpc.jake.bloodp.BloodpAnswer;
import grpc.jake.bloodp.BloodpGrpc;
import grpc.jake.bloodp.BloodpReply;
import grpc.jake.bloodp.BloodpRequest;
import grpc.jake.bloodp.BloodpGrpc.BloodpBlockingStub;
import grpc.jake.bmi.BMIGrpc;
import grpc.jake.bmi.BmiAdvice;
import grpc.jake.bmi.BmiReply;
import grpc.jake.bmi.BmiRequest;
//import grpc.jake.bmi.Empty;
import grpc.jake.bmi.BMIGrpc.BMIBlockingStub;
import grpc.jake.cholesterol.CholesterolAnswer;
import grpc.jake.cholesterol.CholesterolGrpc;
import grpc.jake.cholesterol.CholesterolReply;
import grpc.jake.cholesterol.CholesterolRequest;
import grpc.jake.cholesterol.Empty;
import grpc.jake.cholesterol.CholesterolGrpc.CholesterolBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.awt.Font;
import javax.swing.JTextArea;

public class HeartDiseaseGUI {

	private ServiceInfo bmiServiceInfo;
	private ServiceInfo bpServiceInfo;
	private ServiceInfo choServiceInfo;
	public double bmiheight;
	public double bmiweight;
	public int bpsystolic;
	public int bpdystolic;
	public int total;
	public int ldl;
	public int hdl;
	public int tri;
	
	public String bmitotalvalue;
	public String bmiconditionvalue;
	public String bmihelplink1value;
	public String bmihelplink2value;
	
	public String bptotalvalue;
	public String bpconditionvalue;
	public String bphelplink1value;
	public String bphelplink2value;
	
	public String chototalvalue;
	public String choldlvalue;
	public String chohdlvalue;
	public String chotrivalue;
	public String chohelplink1value;
	public String chohelplink2value;
	
	private JFrame frame;
	private JTextField heighttf;
	private JTextField weighttf;
	private JSeparator separator;
	private JSeparator separator_1;
	private JLabel lblNewLabel_2;
	private JTextArea bmitotal;
	private JTextArea bmicondition;
	private JTextArea bmihelplink1;
	private JTextArea bmihelplink2;
	private JTextArea bptotaltf;
	private JTextArea bpcontf;
	private JTextArea bplink1tf;
	private JTextArea bplink2tf;
	private JTextArea chototaltf;
	private JTextArea choldltf;
	private JTextArea chohdltf;
	private JTextArea chotritf;
	private JTextArea cholink1tf;
	private JTextArea cholink2tf;
	

	/**
	 * Launch the application.
	 */
	
	
	
	private JTextField systf;
	private JTextField dystf;
	private JTextField chototalinputtf;
	private JTextField choldlinputtf;
	private JTextField chohdlinputtf;
	private JTextField chotriinputtf;
	
	
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
		DoServices();
		
	}
	
	public void DoServices() {
		
		String bmi_service_type = "_bmi._tcp.local.";
		discoverBmiService(bmi_service_type);
		String bp_service_type = "_bloodp._tcp.local.";
		discoverBpService(bp_service_type);
		String cho_service_type = "_cholesterol._tcp.local.";
		discoverChoService(cho_service_type);
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
		
		JLabel lblNewLabel_3 = new JLabel("BMI: ");
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
		
		systf = new JTextField();
		systf.setColumns(10);
		systf.setBounds(338, 209, 86, 20);
		frame.getContentPane().add(systf);
		
		dystf = new JTextField();
		dystf.setColumns(10);
		dystf.setBounds(338, 240, 86, 20);
		frame.getContentPane().add(dystf);
		
		JLabel lblSystolic = new JLabel("Systolic:");
		lblSystolic.setFont(new Font("Microsoft JhengHei", Font.BOLD, 12));
		lblSystolic.setBounds(279, 212, 59, 19);
		frame.getContentPane().add(lblSystolic);
		
		JLabel lblDystolic = new JLabel("Dystolic: ");
		lblDystolic.setFont(new Font("Microsoft JhengHei", Font.BOLD, 12));
		lblDystolic.setBounds(279, 240, 59, 19);
		frame.getContentPane().add(lblDystolic);
		
		JButton bpbtn = new JButton("Calculate");
		bpbtn.setFont(new Font("Microsoft JhengHei", Font.BOLD, 11));
		bpbtn.setBounds(279, 271, 145, 27);
		frame.getContentPane().add(bpbtn);
		
		JLabel lblNewLabel_3_1 = new JLabel("Blood Pressure");
		lblNewLabel_3_1.setFont(new Font("Microsoft JhengHei", Font.BOLD, 16));
		lblNewLabel_3_1.setBounds(13, 327, 119, 20);
		frame.getContentPane().add(lblNewLabel_3_1);
		
		bptotaltf = new JTextArea();
		bptotaltf.setText((String) null);
		bptotaltf.setFont(new Font("Microsoft JhengHei", Font.BOLD, 16));
		bptotaltf.setEditable(false);
		bptotaltf.setBounds(142, 324, 130, 23);
		frame.getContentPane().add(bptotaltf);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Condition:");
		lblNewLabel_3_1_1.setFont(new Font("Microsoft JhengHei", Font.BOLD, 16));
		lblNewLabel_3_1_1.setBounds(13, 358, 86, 20);
		frame.getContentPane().add(lblNewLabel_3_1_1);
		
		bpcontf = new JTextArea();
		bpcontf.setText((String) null);
		bpcontf.setFont(new Font("Microsoft JhengHei", Font.BOLD, 16));
		bpcontf.setEditable(false);
		bpcontf.setBounds(142, 355, 130, 23);
		frame.getContentPane().add(bpcontf);
		
		JLabel lblHelpfulLinks_1 = new JLabel("Helpful links:");
		lblHelpfulLinks_1.setFont(new Font("Microsoft JhengHei", Font.BOLD, 12));
		lblHelpfulLinks_1.setBounds(10, 402, 86, 19);
		frame.getContentPane().add(lblHelpfulLinks_1);
		
		bplink1tf = new JTextArea();
		bplink1tf.setText((String) null);
		bplink1tf.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		bplink1tf.setEditable(false);
		bplink1tf.setBounds(101, 389, 323, 20);
		frame.getContentPane().add(bplink1tf);
		
		bplink2tf = new JTextArea();
		bplink2tf.setText((String) null);
		bplink2tf.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		bplink2tf.setEditable(false);
		bplink2tf.setBounds(101, 410, 323, 20);
		frame.getContentPane().add(bplink2tf);
		
		JTextArea txtrHighCholesterolUsually = new JTextArea();
		txtrHighCholesterolUsually.setText("High cholesterol usually has no signs or \r\nsymptoms.\r\nThe only way to know whether someone\r\nhas high cholesterol is to get a blood \r\ntest called “lipid profile”. ");
		txtrHighCholesterolUsually.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		txtrHighCholesterolUsually.setEditable(false);
		txtrHighCholesterolUsually.setBounds(10, 454, 252, 89);
		frame.getContentPane().add(txtrHighCholesterolUsually);
		
		JLabel lblSystolic_1 = new JLabel("Total:");
		lblSystolic_1.setFont(new Font("Microsoft JhengHei", Font.BOLD, 12));
		lblSystolic_1.setBounds(282, 458, 46, 19);
		frame.getContentPane().add(lblSystolic_1);
		
		JLabel lblSystolic_2 = new JLabel("LDL:");
		lblSystolic_2.setFont(new Font("Microsoft JhengHei", Font.BOLD, 12));
		lblSystolic_2.setBounds(282, 476, 46, 19);
		frame.getContentPane().add(lblSystolic_2);
		
		chototalinputtf = new JTextField();
		chototalinputtf.setColumns(10);
		chototalinputtf.setBounds(338, 455, 86, 20);
		frame.getContentPane().add(chototalinputtf);
		
		choldlinputtf = new JTextField();
		choldlinputtf.setColumns(10);
		choldlinputtf.setBounds(338, 476, 86, 20);
		frame.getContentPane().add(choldlinputtf);
		
		chohdlinputtf = new JTextField();
		chohdlinputtf.setColumns(10);
		chohdlinputtf.setBounds(338, 496, 86, 20);
		frame.getContentPane().add(chohdlinputtf);
		
		chotriinputtf = new JTextField();
		chotriinputtf.setColumns(10);
		chotriinputtf.setBounds(338, 516, 86, 20);
		frame.getContentPane().add(chotriinputtf);
		
		JLabel lblSystolic_2_1 = new JLabel("HDL:");
		lblSystolic_2_1.setFont(new Font("Microsoft JhengHei", Font.BOLD, 12));
		lblSystolic_2_1.setBounds(282, 496, 46, 19);
		frame.getContentPane().add(lblSystolic_2_1);
		
		JLabel lblSystolic_2_2 = new JLabel("Triglicerides:");
		lblSystolic_2_2.setFont(new Font("Microsoft JhengHei", Font.BOLD, 12));
		lblSystolic_2_2.setBounds(263, 516, 75, 20);
		frame.getContentPane().add(lblSystolic_2_2);
		
		JButton chobtn = new JButton("Calculate");
		chobtn.setFont(new Font("Microsoft JhengHei", Font.BOLD, 11));
		chobtn.setBounds(279, 542, 145, 27);
		frame.getContentPane().add(chobtn);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("Total:");
		lblNewLabel_3_1_2.setFont(new Font("Microsoft JhengHei", Font.BOLD, 16));
		lblNewLabel_3_1_2.setBounds(13, 576, 46, 20);
		frame.getContentPane().add(lblNewLabel_3_1_2);
		
		JLabel lblNewLabel_3_1_2_1 = new JLabel("LDL:");
		lblNewLabel_3_1_2_1.setFont(new Font("Microsoft JhengHei", Font.BOLD, 16));
		lblNewLabel_3_1_2_1.setBounds(197, 576, 46, 20);
		frame.getContentPane().add(lblNewLabel_3_1_2_1);
		
		chototaltf = new JTextArea();
		chototaltf.setText(chototalvalue);
		chototaltf.setFont(new Font("Microsoft JhengHei", Font.BOLD, 16));
		chototaltf.setEditable(false);
		chototaltf.setBounds(57, 577, 130, 23);
		frame.getContentPane().add(chototaltf);
		
		choldltf = new JTextArea();
		choldltf.setText(choldlvalue);
		choldltf.setFont(new Font("Microsoft JhengHei", Font.BOLD, 16));
		choldltf.setEditable(false);
		choldltf.setBounds(249, 573, 130, 23);
		frame.getContentPane().add(choldltf);
		
		JLabel lblNewLabel_3_1_2_2 = new JLabel("HDL:");
		lblNewLabel_3_1_2_2.setFont(new Font("Microsoft JhengHei", Font.BOLD, 16));
		lblNewLabel_3_1_2_2.setBounds(10, 605, 46, 20);
		frame.getContentPane().add(lblNewLabel_3_1_2_2);
		
		JLabel lblNewLabel_3_1_2_2_1 = new JLabel("Triglycerides:");
		lblNewLabel_3_1_2_2_1.setFont(new Font("Microsoft JhengHei", Font.BOLD, 16));
		lblNewLabel_3_1_2_2_1.setBounds(181, 607, 100, 18);
		frame.getContentPane().add(lblNewLabel_3_1_2_2_1);
		
		chohdltf = new JTextArea();
		chohdltf.setText(chohdlvalue);
		chohdltf.setFont(new Font("Microsoft JhengHei", Font.BOLD, 16));
		chohdltf.setEditable(false);
		chohdltf.setBounds(50, 607, 130, 23);
		frame.getContentPane().add(chohdltf);
		
		chotritf = new JTextArea();
		chotritf.setText(chotrivalue);
		chotritf.setFont(new Font("Microsoft JhengHei", Font.BOLD, 16));
		chotritf.setEditable(false);
		chotritf.setBounds(286, 607, 138, 23);
		frame.getContentPane().add(chotritf);
		
		JLabel lblHelpfulLinks_1_1 = new JLabel("Helpful links:");
		lblHelpfulLinks_1_1.setFont(new Font("Microsoft JhengHei", Font.BOLD, 12));
		lblHelpfulLinks_1_1.setBounds(10, 654, 86, 19);
		frame.getContentPane().add(lblHelpfulLinks_1_1);
		
		cholink1tf = new JTextArea();
		cholink1tf.setText(chohelplink1value);
		cholink1tf.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		cholink1tf.setEditable(false);
		cholink1tf.setBounds(101, 644, 323, 20);
		frame.getContentPane().add(cholink1tf);
		
		cholink2tf = new JTextArea();
		cholink2tf.setText(chohelplink2value);
		cholink2tf.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		cholink2tf.setEditable(false);
		cholink2tf.setBounds(101, 665, 323, 20);
		frame.getContentPane().add(cholink2tf);
		
		
		//Application Code
		bmibtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				getValuesService1Bmi();
				//getValuesService2Bmi();
			}
		});
		
		bpbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				getValuesService1Bp();
				//getValuesService2Bp();
			}
		});
		
		chobtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				getValuesService1Cho();
				//getValuesService2Cho();
			}
		});
		
	}
	
	public void getValuesService1Bmi() {
			
			bmiheight= Double.parseDouble(heighttf.getText());
			bmiweight= Double.parseDouble(weighttf.getText());
			//service 1
			if (bmiheight >= 2.73||bmiweight>= 443) {
				JOptionPane.showMessageDialog(frame, "Please enter height in meters: '1.70' m "
						+ "\n Please enter weight in kilograms: '67.5' kg");
			}else {
				ManagedChannel channel = ManagedChannelBuilder.forAddress(bmiServiceInfo.getHostAddresses()[0], bmiServiceInfo.getPort()).usePlaintext().build();
				
				BMIBlockingStub blockingStub = BMIGrpc.newBlockingStub(channel);
				
				BmiRequest request1 = BmiRequest.newBuilder().setHeight(bmiheight).setWeight(bmiweight).build();
				
				BmiReply response1 = blockingStub.bmiCalculation(request1);
				
				double d = response1.getBmi();
				bmitotalvalue =  String.valueOf(Math.round(d * 100.0) / 100.0);
				bmiconditionvalue = response1.getBmimessage();
				
				System.out.println(bmitotalvalue);
				System.out.println(bmiconditionvalue);
				
				//setting value in GUI
				bmitotal.setText(bmitotalvalue);
				bmicondition.setText(bmiconditionvalue);
				
				getValuesService2Bmi();
			}
		
	}
	
	public void getValuesService2Bmi() {
		
		//service 2		
		ManagedChannel channel2 = ManagedChannelBuilder.forAddress(bmiServiceInfo.getHostAddresses()[0], bmiServiceInfo.getPort()).usePlaintext().build();
		
		BMIBlockingStub blockingStub2 = BMIGrpc.newBlockingStub(channel2);
		
		grpc.jake.bmi.Empty request2 = grpc.jake.bmi.Empty.newBuilder().build();
		
		BmiAdvice response2 = blockingStub2.bmiAdvice(request2);
		
		bmihelplink1value = response2.getLink1();
		bmihelplink2value = response2.getLink2();
		
		System.out.println(bmihelplink1value);
		System.out.println(bmihelplink2value);
		
		//setting value in GUI
		bmihelplink1.setText(bmihelplink1value);
		bmihelplink2.setText(bmihelplink2value);
	}
	
	public void getValuesService1Bp(){
		try {
			bpsystolic = Integer.parseInt(systf.getText());
			bpdystolic = Integer.parseInt(dystf.getText());
			
			//service 1
			
			ManagedChannel channel3 = ManagedChannelBuilder.forAddress(bpServiceInfo.getHostAddresses()[0], bpServiceInfo.getPort()).usePlaintext().build();
			
			BloodpBlockingStub blockingStub3 = BloodpGrpc.newBlockingStub(channel3);
			
			//prepare request
			BloodpRequest request = BloodpRequest.newBuilder().setSystolic(bpsystolic).setDiastolic(bpdystolic).build();
			
			BloodpReply response = blockingStub3.bloodpCalculation(request);
			
			bptotalvalue = response.getBp();
			bpconditionvalue = response.getBpmessage();
			
			System.out.println(bptotalvalue);
			System.out.println(bpconditionvalue);
			
			//setting value in GUI
			bptotaltf.setText(bptotalvalue);
			bpcontf.setText(bpconditionvalue);
			
			getValuesService2Bp();
		}
		catch (NumberFormatException ignore) {
			JOptionPane.showMessageDialog(frame, "Please enter whole numbers as avlues for Systolic and Dystolic");
	    }
	}
	
	public void getValuesService2Bp() {
		//service 2
		ManagedChannel channel = ManagedChannelBuilder.forAddress(bpServiceInfo.getHostAddresses()[0], bpServiceInfo.getPort()).usePlaintext().build();
		
		BloodpBlockingStub blockingStub = BloodpGrpc.newBlockingStub(channel);
		
		//prepare request
		grpc.jake.bloodp.Empty request2 = grpc.jake.bloodp.Empty.newBuilder().build();
		
		BloodpAnswer response = blockingStub.bloodpAdvice(request2);
		
		bphelplink1value=response.getHelplink1();
		bphelplink2value=response.getHelplink2();
		
		System.out.println(bphelplink1value);
		System.out.println(bphelplink2value);
		
		bplink1tf.setText(bphelplink1value);
		bplink2tf.setText(bphelplink2value);
		
	}
	
	public void getValuesService1Cho() {
		try {
			total = Integer.parseInt(chototalinputtf.getText());
			ldl = Integer.parseInt(choldlinputtf.getText());
			hdl = Integer.parseInt(chohdlinputtf.getText());
			tri = Integer.parseInt(chotriinputtf.getText());
			
			ManagedChannel channel = ManagedChannelBuilder.forAddress(choServiceInfo.getHostAddresses()[0], choServiceInfo.getPort()).usePlaintext().build();
			
			CholesterolBlockingStub blockingStub = CholesterolGrpc.newBlockingStub(channel);
			
			CholesterolRequest request = CholesterolRequest.newBuilder().setTotal(total).setLdl(ldl).setHdl(hdl).setTriglycerides(tri).build();
			
			CholesterolReply response = blockingStub.cholesterolCalculation(request);
			
			chototalvalue = response.getTotal();
			choldlvalue = response.getAnsldl();
			chohdlvalue = response.getAnshdl();
			chotrivalue = response.getAnstri();
			
			chototaltf.setText(choldlvalue);
			choldltf.setText(choldlvalue);
			chohdltf.setText(chohdlvalue);
			chotritf.setText(choldlvalue);
			
			getValuesService2Cho();
		}
		catch (NumberFormatException ignore) {
			JOptionPane.showMessageDialog(frame, "Please enter whole numbers as values for each field");
	    }
	}
	
	public void getValuesService2Cho() {
		
		ManagedChannel channel = ManagedChannelBuilder.forAddress(choServiceInfo.getHostAddresses()[0], choServiceInfo.getPort()).usePlaintext().build();
		
		CholesterolBlockingStub blockingStub = CholesterolGrpc.newBlockingStub(channel);
		
		grpc.jake.cholesterol.Empty request = grpc.jake.cholesterol.Empty.newBuilder().build();
		
		CholesterolAnswer response = blockingStub.cholesterolAdvice(request);
		
		chohelplink1value = response.getHelplink1();
		chohelplink2value = response.getHelplink2();
		
		cholink1tf.setText(chohelplink1value);
		cholink2tf.setText(chohelplink2value);
	}
	
	//service discovery code
	public void discoverBmiService(String service_type) {
		try {
			//get instance of jmDNS
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
			
			//i need to listen for services added/removed etc
			jmdns.addServiceListener(service_type, new ServiceListener() {
			
			@Override
			public void serviceResolved(ServiceEvent event) {
				System.out.println("Service resolved: " + event.getInfo());

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
		Thread.sleep(10000);
		
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
	
	public void discoverBpService(String service_type) {
		
		try {
			//get instance of jmDNS
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
			
			//i need to listen for services added/removed etc
			jmdns.addServiceListener(service_type, new ServiceListener() {
			
			@Override
			public void serviceResolved(ServiceEvent event) {
				System.out.println("Service resolved: " + event.getInfo());

				bpServiceInfo = event.getInfo();

				int port = bpServiceInfo.getPort();
				
				System.out.println("resolving " + service_type + " with properties ...");
				System.out.println("\t port: " + port);
				System.out.println("\t type:"+ event.getType());
				System.out.println("\t name: " + event.getName());
				System.out.println("\t description/properties: " + bpServiceInfo.getNiceTextString());
				System.out.println("\t host: " + bpServiceInfo.getHostAddresses()[0]);
			
				
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
		Thread.sleep(10000);
		
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
	
	public void discoverChoService(String service_type) {
		
		try {
			//get instance of jmDNS
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
			
			//i need to listen for services added/removed etc
			jmdns.addServiceListener(service_type, new ServiceListener() {
			
			@Override
			public void serviceResolved(ServiceEvent event) {
				System.out.println("Service resolved: " + event.getInfo());

				choServiceInfo = event.getInfo();

				int port = choServiceInfo.getPort();
				
				System.out.println("resolving " + service_type + " with properties ...");
				System.out.println("\t port: " + port);
				System.out.println("\t type:"+ event.getType());
				System.out.println("\t name: " + event.getName());
				System.out.println("\t description/properties: " + choServiceInfo.getNiceTextString());
				System.out.println("\t host: " + choServiceInfo.getHostAddresses()[0]);
			
				
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
		Thread.sleep(10000);
		
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
}
