import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import net.miginfocom.swing.MigLayout;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDayChooser;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class LoginPage extends JFrame {

	private JPanel Loginpane;
	JFrame frame, frame1;
	JTextField textbox;
	JLabel label;
	JButton button;
	JPanel panel;
	private JLabel UserName;
	String driverName = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:33306/flight";
	String userName = "root";
	String password = "Vs16656915<>";
	String[] columnNames = {"Flight ID", "Name", "Departure", "Arrival","Seats","Price"};
	private JTextField textField;
	private JTextField textField1;
	private String username;
	private int ID;
	private JTable table_1;
	public void setuserid(int t)
	{
		this.ID=t;
	}
	
	
	public void setUsername(String s)
	{
		this.username=s;
		UserName.setText("Welcome "+username);;
		
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame3 = new LoginPage();
					frame3.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
		
	
	public  void showTableData()
	{

	/*frame1 = new JFrame("Database Search Result");
	frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame1.getContentPane().setLayout(new BorderLayout());*/
	
	//TableModel tm = new TableModel();
	DefaultTableModel model = new DefaultTableModel();
	model.setColumnIdentifiers(columnNames);
	//DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames()); 
	//table = new JTable(model);
	//table1 = new JTable();
	table_1.setModel(model); 
	table_1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	table_1.setFillsViewportHeight(true);
	/*JScrollPane scroll = new JScrollPane(table_1);
	scroll.setHorizontalScrollBarPolicy(
	JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	scroll.setVerticalScrollBarPolicy(
	JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); */
	/*JPanel tablePanel=new JPanel(new Absolut);
	tablePanel.add(table_1,BorderLayout.CENTER);
	tablePanel.add(table_1.getTableHeader(),BorderLayout.NORTH);*/
	String name= "";
	String departure= "";
	String arrival= "";
	int id,seats,price;
	
	try
	{ 
	Class.forName(driverName); 
	Connection con = DriverManager.getConnection(url, userName, password);
	String sql = "select * from light";
	PreparedStatement ps = con.prepareStatement(sql);
	
		ResultSet rs = ps.executeQuery();
		int i =0;
		
		if(rs.next())
		{
			id=rs.getInt("flight_id");
		name= rs.getString("fName");
		departure = rs.getString("dFrom");
		arrival = rs.getString("arrivesto");
		seats = rs.getInt("Seats"); 
		price=rs.getInt("Price");
		model.addRow(new Object[]{id,name,departure,arrival,seats,price});
		i++; 
		}
	
	
	if(i <1)
	{
	JOptionPane.showMessageDialog(null, "No Record Found","Error",
	JOptionPane.ERROR_MESSAGE);
	}
	con.close();
	/*if(i ==1)
	{
	System.out.println(i+" Record Found");
	}
	else
	{
	System.out.println(i+" Records Found");
	}*/
		
	}
	catch(Exception ex)
	{
	JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
	JOptionPane.ERROR_MESSAGE);
	}
	/*frame1.getContentPane().add(scroll);
	frame1.setVisible(true);
	frame1.setSize(400,300);*/
	}

	/**
	 * Create the frame.
	 */
	
	public LoginPage() 
		{
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 918, 737);
			Loginpane = new JPanel();
			Loginpane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(Loginpane);
			
			JLabel label = new JLabel("");
			label.setBounds(349, 19, 0, 0);
			
			JLabel lblFrom = new JLabel("FROM");
			lblFrom.setBounds(132, 142, 95, 13);
			
			JComboBox comboBox = new JComboBox();
			comboBox.setBounds(251, 139, 129, 19);
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Delhi", "Mumbai", "Ahmedabad", "Hyderabad", "Pune"}));
			comboBox.setToolTipText("");
			
			JLabel lblTo = new JLabel("TO");
			lblTo.setBounds(442, 137, 34, 22);
			
			JComboBox comboBox_1 = new JComboBox();
			comboBox_1.setBounds(562, 139, 129, 19);
			comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Delhi", "Mumbai", "Ahmedabd", "Pune", "Hyderabad"}));
			Loginpane.setLayout(null);
			Loginpane.add(label);
			Loginpane.add(lblFrom);
			Loginpane.add(comboBox);
			Loginpane.add(lblTo);
			Loginpane.add(comboBox_1);
			
			JCalendar calendar = new JCalendar();
			calendar.setBounds(251, 180, 206, 135);
			Loginpane.add(calendar);
			
			JLabel lblDate = new JLabel("DATE");
			lblDate.setBounds(132, 180, 95, 13);
			Loginpane.add(lblDate);
			
			
				
			
			
			
			JButton btnLogOut = new JButton("Log out");
			btnLogOut.setBounds(759, 10, 145, 21);
			btnLogOut.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					First rgf=new First();
					rgf.setVisible(true);
					 setVisible(false);
					 dispose();
				}
			});
			Loginpane.add(btnLogOut);
			
			JButton btnSearch = new JButton("Search");
			btnSearch.setBounds(0, 334, 904, 28);
			btnSearch.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					showTableData();
				}
			});
			Loginpane.add(btnSearch);
			
			JButton btnMyBookings = new JButton("My Bookings");
			btnMyBookings.setBounds(0, 84, 155, 21);
			btnMyBookings.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					PreviousBooking rgf=new PreviousBooking();
					rgf.setusername(username);
					
						rgf.setVisible(true);
						setVisible(false);
						dispose();
						 
					
				}
			});
			Loginpane.add(btnMyBookings);
			
			JButton btnNewButton = new JButton("Book");
			btnNewButton.setBounds(408, 642, 85, 21);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					booking rgf=new booking();
					String s=textField1.getText();
						rgf.setAmount(s);
						int result = Integer.parseInt(textField.getText());
						s=username;
						rgf.setFlightid(result);
						rgf.setusername(s);
						
					rgf.setVisible(true);
					
					setVisible(false);
					dispose();
			        
				}
			});
			Loginpane.add(btnNewButton);
			
			JLabel lblFlightId = new JLabel("Flight Id");
			lblFlightId.setBounds(132, 646, 95, 13);
			Loginpane.add(lblFlightId);
			
			textField = new JTextField();
			textField.setBounds(253, 643, 96, 19);
			Loginpane.add(textField);
			textField.setColumns(10);
			
			textField1 = new JTextField();
			textField1.setBounds(562, 643, 96, 19);
			Loginpane.add(textField1);
			textField1.setColumns(10);
			
			UserName = new JLabel("New label");
			UserName.setBounds(0, 10, 155, 13);
			Loginpane.add(UserName);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(31, 401, 800, 162);
			Loginpane.add(scrollPane);
			
			table_1 = new JTable();
			table_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int index=table_1.getSelectedRow();
					textField.setText(table_1.getValueAt(index, 0).toString());
					textField1.setText(table_1.getValueAt(index, 5).toString());
				}
			});
			scrollPane.setViewportView(table_1);
			
			
			
			
			
			
			
		}
	}

