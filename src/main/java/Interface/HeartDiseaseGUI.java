package Interface;

import java.awt.EventQueue;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.CardLayout;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextPane;

import classes.BmiOutput;
import clients.BmiClient;

import java.awt.Font;
import java.awt.Canvas;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;

public class HeartDiseaseGUI {

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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Microsoft JhengHei", Font.PLAIN, 11));
		frame.setBounds(100, 100, 450, 800);
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
		separator_1.setBounds(-29, 400, 483, 2);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(-29, 600, 483, 2);
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
		bmibiota.setText("The body mass index (BMI) is a measurement \r\that uses your height and weight to work \r\nout if your weight is healthy. \r\nThe BMI calculation divides an adult's \r\nweight in kilograms by their height in \r\nmetres squared.");
		bmibiota.setBounds(10, 9, 262, 106);
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
		
		
		//Application Code
		bmibtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getValuesBmi();
			}
		});
		
	}
	
	public void getValuesBmi() {
		BmiClient ans = new BmiClient();
		BmiOutput bmians = new BmiOutput(); 
		bmitotalvalue = bmians.getBmitotalvalue();
		bmiconditionvalue = bmians.getBmiconditionvalue();
		bmihelplink1value = bmians.getBmihelplink1value();
		bmihelplink2value = bmians.getBmihelplink2value();
		
		System.out.println(bmitotalvalue);
		
		bmitotal.setText(bmitotalvalue);
		bmicondition.setText(bmiconditionvalue);
		bmihelplink1.setText(bmihelplink1value);
		bmihelplink2.setText(bmihelplink2value);
		
	}
}
