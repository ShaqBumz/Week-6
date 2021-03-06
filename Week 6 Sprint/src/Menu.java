import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Menu {

	private JFrame frame;
	private JTextField txtSN;
	private JTextField txtAS;
	private JTextField txtPN;
	private JTextField txtJT;
	private JTextField txtFN;
	private JTextField txtCDS;
	private JTextField txtST;
	private JTextField txtAN;
	private JButton btnSub;
	private JButton btnSub2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
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
	public Menu() {
		initialize();
	}

	/**
	 * Initialise the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 521, 368);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLoginMenu = new JLabel("Login Menu");
		lblLoginMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginMenu.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblLoginMenu.setBounds(25, 25, 459, 34);
		frame.getContentPane().add(lblLoginMenu);
		
		txtSN = new JTextField();
		txtSN.setText("Student Name");
		txtSN.setBounds(25, 68, 179, 20);
		frame.getContentPane().add(txtSN);
		txtSN.setColumns(10);
		txtSN.setVisible(false);
		
		txtAS = new JTextField();
		txtAS.setText("Admin Surname");
		txtAS.setBounds(305, 112, 179, 20);
		frame.getContentPane().add(txtAS);
		txtAS.setColumns(10);
		txtAS.setVisible(false);
		
		txtPN = new JTextField();
		txtPN.setText("Parent Name");
		txtPN.setBounds(25, 112, 179, 20);
		frame.getContentPane().add(txtPN);
		txtPN.setColumns(10);
		txtPN.setVisible(false);
		
		txtJT = new JTextField();
		txtJT.setText("Job Title");
		txtJT.setBounds(305, 152, 179, 20);
		frame.getContentPane().add(txtJT);
		txtJT.setColumns(10);
		txtJT.setVisible(false);
		
		txtFN = new JTextField();
		txtFN.setText("Family Name");
		txtFN.setBounds(25, 152, 179, 20);
		frame.getContentPane().add(txtFN);
		txtFN.setColumns(10);
		txtFN.setVisible(false);
		
		txtCDS = new JTextField();
		txtCDS.setText("Child's Desired Sport");
		txtCDS.setBounds(25, 192, 179, 20);
		frame.getContentPane().add(txtCDS);
		txtCDS.setColumns(10);
		txtCDS.setVisible(false);
		
		txtST = new JTextField();
		txtST.setText("Sport Taught");
		txtST.setBounds(305, 192, 179, 20);
		frame.getContentPane().add(txtST);
		txtST.setColumns(10);
		txtST.setVisible(false);
		
		txtAN = new JTextField();
		txtAN.setText("Admin Name");
		txtAN.setBounds(305, 70, 179, 20);
		frame.getContentPane().add(txtAN);
		txtAN.setColumns(10);
		txtAN.setVisible(false);
		
		JButton btnAdm = new JButton("Administration");
		btnAdm.setFont(new Font("Sitka Display", Font.BOLD, 18));
		btnAdm.setBounds(305, 234, 179, 84);
		frame.getContentPane().add(btnAdm);
		
		JLabel lblQuery = new JLabel("Select a form to access:\r\n");
		lblQuery.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblQuery.setBounds(182, 70, 158, 14);
		frame.getContentPane().add(lblQuery);
		
		btnSub = new JButton("Submit");
		btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Create a variable for the connection string.
				String connectionUrl = "jdbc:sqlserver://localhost:1433;"
						+ "databaseName= Week6Sprint;integratedSecurity=true;";

				// Declare the JDBC Objects.
				Connection con = null;
				Statement stmt = null;

				try {
					// Establish the connection.
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					con = DriverManager.getConnection(connectionUrl);

					String SN = txtSN.getText();
					String PN = txtPN.getText();
					String FN = txtFN.getText();
					String CDS = txtCDS.getText();
					

					// Create and execute an SQL statement that returns some data
					String SQLstart = "INSERT INTO [dbo].[SnP] ([Student Name],[Parent Name],[Family Name],[Child Sport]) VALUES ('"
							+ SN + "','" + PN + "','" + FN + "','" + CDS + "')";

					stmt = con.createStatement();
					stmt.execute(SQLstart);

					System.out.println("Your Info Has Successfully Been Added");

				}

				catch (Exception e1) {

					e1.printStackTrace();
				}
				
			}
		});
		btnSub.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSub.setBounds(206, 70, 89, 62);
		frame.getContentPane().add(btnSub);
		btnSub.setVisible(false);
		
		btnSub2 = new JButton("Submit");
		btnSub2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Create a variable for the connection string.
				String connectionUrl = "jdbc:sqlserver://localhost:1433;"
						+ "databaseName= Week6Sprint;integratedSecurity=true;";

				// Declare the JDBC Objects.
				Connection con = null;
				Statement stmt = null;

				try {
					// Establish the connection.
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					con = DriverManager.getConnection(connectionUrl);

					String AN = txtAN.getText();
					String AS = txtAS.getText();
					String JT = txtJT.getText();
					String ST = txtST.getText();
					

					// Create and execute an SQL statement that returns some data
					String SQLstart = "INSERT INTO [dbo].[Admin Form] ([Admin Name],[Admin Surname],[Job Title],[Sport Taught]) VALUES ('"
							+ AN + "','" + AS + "','" + JT + "','" + ST + "')";

					stmt = con.createStatement();
					stmt.execute(SQLstart);

					System.out.println("Your Info Has Successfully Been Added");

				}

				catch (Exception e1) {

					e1.printStackTrace();
				}
				
			}
		});
		btnSub2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSub2.setBounds(206, 151, 89, 61);
		frame.getContentPane().add(btnSub2);
		btnSub2.setVisible(false);
		
		
		JButton btnSnP = new JButton("Student & Parent\r\n");
		btnSnP.setFont(new Font("Sitka Display", Font.BOLD, 18));
		btnSnP.setBounds(25, 234, 179, 84);
		frame.getContentPane().add(btnSnP);
		
		
		
		
		
		
		btnAdm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtAN.setVisible(true);
				txtAS.setVisible(true);
				txtJT.setVisible(true);
				txtST.setVisible(true);
				
				lblQuery.setVisible(false);
				lblLoginMenu.setText("Administration Form");
				
				btnSnP.setVisible(false);
				btnAdm.setVisible(false);
				btnSub2.setVisible(true);
				
				
			}
		});

		
		
		btnSnP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtSN.setVisible(true);
				txtPN.setVisible(true);
				txtFN.setVisible(true);
				txtCDS.setVisible(true);
				
				lblQuery.setVisible(false);
				lblLoginMenu.setText("Student & Parent Form");
				
				btnSnP.setVisible(false);
				btnAdm.setVisible(false);
				btnSub.setVisible(true);
				
				
			}
		});

		
		
		
		
		
		
		
		
	}
}
