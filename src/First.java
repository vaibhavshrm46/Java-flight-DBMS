import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class First extends JFrame {

	private JPanel Loginpane;
	private JButton btnNewAccount;
	private JTextField userName_1;
	private JLabel lblNewLabel;
	private JPasswordField passwordField;
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
					First frame2 = new First();
					frame2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public First() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 953, 517);
		Loginpane = new JPanel();
		Loginpane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Loginpane);
		Loginpane.setLayout(null);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{ 
				Class.forName(driverName); 
				Connection con = DriverManager.getConnection(url, userName, password);
				String s=userName_1.getText();
				String p=passwordField.getSelectedText();
				String sql = "select * from customers where USERNAME='"+s+"'and password='"+p+"'";
				PreparedStatement ps = con.prepareStatement(sql);
				
					ResultSet rs = ps.executeQuery();
					if(rs==null)
					{
						JOptionPane.showMessageDialog(null,"Invalid pasword or username");
						
					}
					else
					{
						LoginPage rgf=new LoginPage();
						rgf.setUsername(s);
						
							rgf.setVisible(true);
							setVisible(false);
							dispose();
							 con.close();
						
					}
					
				
			}
				catch(Exception exp)
				
				{
					JOptionPane.showMessageDialog(null,e);
					
				}
			}
		});
		btnNewButton.setBounds(5, 422, 934, 32);
		Loginpane.add(btnNewButton);
		
		btnNewAccount = new JButton("NEW ACCOUNT");
		btnNewAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewAccount.setBounds(5, 454, 934, 26);
		btnNewAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Frameflight rgf=new Frameflight();
				rgf.frame.setVisible(true);
				setVisible(false);
				dispose();
		        
		       
		      
		        
		       
			}
		});
		Loginpane.add(btnNewAccount);
		
		userName_1 = new JTextField();
		userName_1.setBounds(417, 129, 96, 19);
		Loginpane.add(userName_1);
		userName_1.setColumns(10);
		
		lblNewLabel = new JLabel("USERNAME");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(10, 132, 269, 13);
		Loginpane.add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(417, 243, 96, 19);
		Loginpane.add(passwordField);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setBounds(10, 246, 269, 13);
		Loginpane.add(lblPassword);
		
		
				
				
							
		
	}
}
