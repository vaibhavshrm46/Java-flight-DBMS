import java.awt.BorderLayout;
import java.util.Random;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.mysql.cj.xdevapi.Statement;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class booking extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JTextField amountfield;
	private int flight_id;
	private String username;
	private int userID;
	public void setuserID(int t)
	{
		this.userID=t;
	}
	
	public void setusername(String s)
	{
		this.username=s;
	}
	public void setFlightid(int t)
	{
		this.flight_id=t;
		
	}
	String driverName = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:33306/flight";
	String userName = "root";
	String password = "Vs16656915<>";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					booking frame = new booking();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public void setAmount(String s)
	{
		this.amountfield.setText(s);
	}
	public booking() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 916, 660);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPayment = new JLabel("Payment");
		lblPayment.setBounds(5, 5, 892, 13);
		contentPane.add(lblPayment);
		
		JLabel lblNewLabel = new JLabel("Name on Card");
		lblNewLabel.setBounds(74, 161, 247, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(126, 268, 80, -50);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblExpireDate = new JLabel("Expire date");
		lblExpireDate.setBounds(74, 199, 163, 13);
		contentPane.add(lblExpireDate);
		
		JLabel lblCvv = new JLabel("Cvv\r\n");
		lblCvv.setBounds(74, 228, 94, 13);
		contentPane.add(lblCvv);
		
		JLabel lblPayableAmount = new JLabel("Payable Amount\r\n");
		lblPayableAmount.setBounds(74, 266, 119, 13);
		contentPane.add(lblPayableAmount);
		
		JLabel lblCardNumber = new JLabel("Card number");
		lblCardNumber.setBounds(74, 121, 247, 13);
		contentPane.add(lblCardNumber);
		
		JLabel label = new JLabel("");
		label.setBounds(177, 30, 45, 13);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(199, 118, 327, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(199, 158, 327, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JMonthChooser monthChooser = new JMonthChooser();
		monthChooser.setBounds(202, 199, 94, 19);
		contentPane.add(monthChooser);
		
		JYearChooser yearChooser = new JYearChooser();
		yearChooser.setBounds(348, 199, 46, 19);
		contentPane.add(yearChooser);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(199, 225, 97, 19);
		contentPane.add(passwordField);
		
		amountfield = new JTextField();
		amountfield.setBounds(200, 263, 96, 19);
		contentPane.add(amountfield);
		amountfield.setColumns(10);
		
		JButton btnPay = new JButton("Pay");
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{ 
				Class.forName(driverName); 
				Connection con = DriverManager.getConnection(url, userName, password);
				
					
					
					 
					String sql = "insert into bookedticket(flight_id,ticket_id,price,username)"+" VALUES(?,?,?,?)";
					
					PreparedStatement preparedStmt = con.prepareStatement(sql);
					Random rand = new Random();

					int  n = rand.nextInt(2000) + 1;
				      preparedStmt.setInt (1, flight_id);
				      preparedStmt.setInt (2, flight_id+n);
				      
				      
				      preparedStmt.setInt    (3, Integer.parseInt(amountfield.getText()));
				      preparedStmt.setString(4, username);
					
				      preparedStmt.execute();
				      
				      con.close();
					
					 JOptionPane.showMessageDialog(null,"Booked");
				
			}
				catch(Exception exp)
				{
					JOptionPane.showMessageDialog(null, exp.getMessage(),"Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnPay.setBounds(335, 362, 85, 21);
		contentPane.add(btnPay);
	}
}
