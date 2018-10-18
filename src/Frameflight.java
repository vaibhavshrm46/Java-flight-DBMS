import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JEditorPane;
import java.awt.BorderLayout;
import javax.swing.JPasswordField;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Frameflight  {

	public JFrame frame;
	private JList list;
	private JButton btnSignIn;
	private JLabel label;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JLabel lblNewLabel;
	private JLabel lblPassword;
	private JLabel lblName;
	private JLabel lblAge;
	private JLabel lblAddress;
	private JLabel lblPhoneNum;
	private JLabel lblEmail;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel lblBirthdate;

	/** 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frameflight window = new Frameflight();
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
	public Frameflight() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Flight Management");
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 20));
		frame.setBounds(100, 100, 948, 594);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		label.setBounds(467, 3, 467, 50);
		frame.getContentPane().add(label);
		
		label_1 = new JLabel("");
		label_1.setBounds(467, 3, 467, 50);
		frame.getContentPane().add(label_1);
		
		lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(0, 53, 467, 50);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(467, 53, 467, 50);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		lblPassword = new JLabel("Password");
		lblPassword.setBounds(0, 103, 467, 50);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frame.getContentPane().add(lblPassword);
		
		textField_1 = new JTextField();
		textField_1.setBounds(467, 103, 467, 50);
		textField_1.setColumns(10);
		frame.getContentPane().add(textField_1);
		
		lblName = new JLabel("Name");
		lblName.setBounds(0, 153, 467, 50);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frame.getContentPane().add(lblName);
		
		textField_2 = new JTextField();
		textField_2.setBounds(467, 153, 467, 50);
		textField_2.setColumns(10);
		frame.getContentPane().add(textField_2);
		
		lblAge = new JLabel("age");
		lblAge.setBounds(0, 203, 467, 50);
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frame.getContentPane().add(lblAge);
		
		textField_3 = new JTextField();
		textField_3.setBounds(467, 203, 467, 50);
		textField_3.setColumns(10);
		frame.getContentPane().add(textField_3);
		
		lblAddress = new JLabel("address");
		lblAddress.setBounds(0, 253, 467, 50);
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frame.getContentPane().add(lblAddress);
		
		textField_4 = new JTextField();
		textField_4.setBounds(467, 253, 467, 50);
		textField_4.setColumns(10);
		frame.getContentPane().add(textField_4);
		
		lblPhoneNum = new JLabel("phone num");
		lblPhoneNum.setBounds(0, 303, 467, 50);
		lblPhoneNum.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frame.getContentPane().add(lblPhoneNum);
		
		textField_5 = new JTextField();
		textField_5.setBounds(467, 303, 467, 50);
		textField_5.setColumns(10);
		frame.getContentPane().add(textField_5);
		
		lblEmail = new JLabel("email");
		lblEmail.setBounds(0, 353, 467, 50);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frame.getContentPane().add(lblEmail);
		
		textField_6 = new JTextField();
		textField_6.setBounds(467, 353, 467, 50);
		textField_6.setColumns(10);
		frame.getContentPane().add(textField_6);
		
		label_2 = new JLabel("");
		label_2.setBounds(0, 403, 467, 50);
		frame.getContentPane().add(label_2);
		
		label_4 = new JLabel("");
		label_4.setBounds(0, 453, 467, 50);
		frame.getContentPane().add(label_4);
		
		btnSignIn = new JButton("CREATE ACCOUNT");
		btnSignIn.setBounds(467, 453, 467, 50);
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:33306/flight","root","Vs16656915<>");
					Statement stmt=con.createStatement();
					String sql="insert into CUSTOMERS(USERNAME,PASSWORD,NAME,AGE,ADDRESS,PHONE_NO,EMAIL)"+" VALUES('"+textField.getText()+"','"+textField_1.getText()+"','"+textField_2.getText()+
							"','"+textField_3.getText()+"','"+textField_4.getText()+"','"+textField_5.getText()+"','"+textField_6.getText()+"')";
					stmt.executeUpdate(sql);
					con.close();
					JOptionPane.showMessageDialog(null,"customer added");
					
							
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null,e);
				}
			}
		});
		frame.getContentPane().add(btnSignIn);
		
		label_5 = new JLabel("");
		label_5.setBounds(0, 503, 467, 50);
		frame.getContentPane().add(label_5);
		
		label_6 = new JLabel("");
		label_6.setBounds(467, 503, 467, 50);
		frame.getContentPane().add(label_6);
		
		JLabel lblX = new JLabel("X");
		lblX.setForeground(Color.RED);
		lblX.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblX.setBounds(889, 3, 45, 50);
		frame.getContentPane().add(lblX);
		
		lblBirthdate = new JLabel("BirthDATE");
		lblBirthdate.setBounds(0, 426, 45, 13);
		frame.getContentPane().add(lblBirthdate);
		
		
	}
	public JList getList() {
		return list;
	}
}
