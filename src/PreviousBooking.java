import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PreviousBooking extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private String username;
	String driverName = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:33306/flight";
	String userName = "root";
	String password = "Vs16656915<>";
	String[] columnNames = {"Ticket Id", "Flight Id","Flight Name", "Departure", "Arrival","Price","Status"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PreviousBooking frame = new PreviousBooking();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void setusername(String s)
	{
		this.username=s;
	}
	/**
	 * Create the frame.
	 */
	
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
	table.setModel(model); 
	table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	table.setFillsViewportHeight(true);
	/*JScrollPane scroll = new JScrollPane(table_1);
	scroll.setHorizontalScrollBarPolicy(
	JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	scroll.setVerticalScrollBarPolicy(
	JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); */
	/*JPanel tablePanel=new JPanel(new Absolut);
	tablePanel.add(table_1,BorderLayout.CENTER);
	tablePanel.add(table_1.getTableHeader(),BorderLayout.NORTH);*/
	String fname= "";
	String departure= "";
	String arrival= "";
	String status="confirmed";
	int ticketid,flightid,price;
	
	try
	{ 
	Class.forName(driverName); 
	Connection con = DriverManager.getConnection(url, userName, password);
	String sql = "select flight_id,ticket_id,price from bookedticket where username='"+username+"'";
	PreparedStatement ps = con.prepareStatement(sql);
	
		ResultSet rs = ps.executeQuery();
		int i =0;
		
		while(rs.next())
		{
			flightid=rs.getInt("flight_id");
		ticketid=rs.getInt("ticket_id");
		price = rs.getInt("price"); 
		sql="select fName , dFrom,arrivesto from light where flight_id="+flightid;
		ps=con.prepareStatement(sql);
		System.out.println("Vaibhav");
		rs=ps.executeQuery();
		fname=rs.getString(1);
		departure=rs.getString(2);
		arrival=rs.getString(3);
		
			
		
		model.addRow(new Object[]{ticketid,flightid,fname,departure,arrival,price,status});
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

	public PreviousBooking() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 972, 716);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnHome = new JButton("Home");
		btnHome.setBounds(0, 0, 129, 26);
		contentPane.add(btnHome);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 79, 898, 347);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		showTableData();
	}
}
