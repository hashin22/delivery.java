package delivery;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;




public class Join extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	static TextField num_t, name_t, telNo_t;
	JButton reloaddown, reloadup,save,update,delete;
	Panel pan1, pan2, pan3, pan4;
	static String driver, url;//
	static Connection conn;
	static Statement stmt;
	static ResultSet rs;///////////static 다른클래스에서 쓸 수 있음.////////
	static String tmpstr;
	static long count = 0;
	private JTextField textField_3;
	static String id;
	static String pw;
	static String name;
	static String email;
	/**
	 * Launch the application.
	 *//*
	public static void query(String order, String sql) throws SQLException {
		if (order == "select") {
			rs = stmt.executeQuery(sql);
		}
		else if (order == "insert") {
			stmt.executeUpdate(sql);
		}
		else {
			stmt.executeUpdate(sql);
		}
	}

	public static void dbConnect() {
    	driver = "sun.jdbc.odbc.JdbcOdbcDriver";
    	try{
    		Class.forName("com.mysql.jdbc.Driver");
    		System.out.println("드라이버 검색 성공!");        
    	}catch(ClassNotFoundException e){
    		System.err.println("error = " + e);
    	}///////////////////////////////////////////////////
        
    	
        url = "jdbc:odbc:company";
        conn = null;
        stmt = null;
        rs = null;
        String url = "jdbc:mysql://localhost/company";
        String sql = "Select * From login";
		try {
         
            conn = DriverManager.getConnection(url,"root","apmsetup");

            stmt = conn.createStatement( );

            rs = stmt.executeQuery(sql);
            
            System.out.println("데이터베이스 연결 성공!");            
         
        }
        catch(Exception e) {
            System.out.println("데이터베이스 연결 실패!");
        }
	}
*/
	/**
	 * Create the frame.
	 */
	public Join() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("나눔고딕", Font.PLAIN, 18));
		lblNewLabel.setBounds(45, 19, 82, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblPw = new JLabel("PW");
		lblPw.setFont(new Font("나눔고딕", Font.PLAIN, 18));
		lblPw.setBounds(45, 55, 82, 21);
		contentPane.add(lblPw);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setFont(new Font("나눔고딕", Font.PLAIN, 18));
		lblEmail.setBounds(45, 133, 82, 21);
		contentPane.add(lblEmail);
		
		textField = new JTextField();
		textField.setBounds(124, 15, 166, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(124, 51, 166, 27);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(124, 91, 166, 27);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("\uC800\uC7A5");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window.dbConnect();
				 /*id = textField.getText();
				 pw = textField_1.getText();
				 name = textField_2.getText();
				 email = textField_3.getText();*/
				
				try {
					Window.query("insert", "insert into login values('" +textField.getText()+ "','" +textField_1.getText()+ "','" +textField_2.getText()+ "','" +textField_3.getText()+"')");
					//JOptionPane.showMessageDialog(null, "성공");
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				Window.dbDis();
			}
		});
				
		btnNewButton.setFont(new Font("나눔고딕", Font.BOLD, 18));
		btnNewButton.setBounds(58, 181, 129, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uB85C\uADF8\uC778\uD558\uB7EC\uAC00\uAE30");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				new Login().setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("나눔고딕", Font.BOLD, 18));
		btnNewButton_1.setBounds(221, 181, 190, 29);
		contentPane.add(btnNewButton_1);
		
		JLabel lblEmail_1 = new JLabel("\uC774\uB984");
		lblEmail_1.setFont(new Font("나눔고딕", Font.PLAIN, 18));
		lblEmail_1.setBounds(45, 91, 82, 21);
		contentPane.add(lblEmail_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(124, 127, 166, 27);
		contentPane.add(textField_3);
	}
}
