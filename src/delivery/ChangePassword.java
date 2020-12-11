package delivery;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class ChangePassword extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	static String driver, url;

	static Connection conn;

	static Statement stmt;

	static ResultSet rs;
	
	static String id;
	static String pw;
	static String login;
	/**
	 * Launch the application.
	 */

	public static void dbConnect() {
		String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
		try{
    		Class.forName("com.mysql.jdbc.Driver");
    		System.out.println("드라이버 검색 성공!");        
    	}catch(ClassNotFoundException e){
    		System.err.println("error = " + e);
    	}
	
	  url = "jdbc:odbc:company";

      conn = null;

      stmt = null;

      rs = null;

      String url = "jdbc:mysql://localhost/company";
      String sql = "Select * From login";
      
  	try {
  		conn = (Connection) DriverManager.getConnection(url,"root","apmsetup");
        stmt = (Statement) conn.createStatement( );
        rs = stmt.executeQuery(sql);
        System.out.println("데이터베이스 연결 성공!");   
    }
  	
    catch(Exception e) {

        System.out.println("데이터베이스 연결 실패!");

    }

}
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

	/**
	 * Create the frame.
	 */
	public ChangePassword() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 569, 377);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setTitle("비밀번호변경하기");
		
		JLabel lblNewLabel = new JLabel("\uBE44\uBC00\uBC88\uD638 \uBCC0\uACBD\uD558\uAE30");
		lblNewLabel.setFont(new Font("나눔고딕", Font.BOLD, 18));
		lblNewLabel.setBounds(29, 29, 161, 21);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\uD68C\uC6D0\uD0C8\uD1F4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new OutMember().setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("나눔고딕", Font.BOLD, 18));
		btnNewButton.setBounds(389, 24, 119, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("\uAE30\uC874 PW");
		lblNewLabel_1.setFont(new Font("나눔고딕", Font.ITALIC, 14));
		lblNewLabel_1.setBounds(29, 84, 68, 23);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(116, 80, 215, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\uD655\uC778");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dbConnect();
				pw = textField.getText();

				String sql = "select * from login where pw like '" + Login.login + "'";
				try {
					rs = stmt.executeQuery(sql);
					if(true) {
						JOptionPane.showConfirmDialog(null, "기존 비밀번호가 맞습니다.", "성공", JOptionPane.PLAIN_MESSAGE);

						if(rs.next()) {
							query("update", "updeat login set pw = '"+pw+"'");
						}
					}
					else {
						JOptionPane.showConfirmDialog(null, "음", "실패", JOptionPane.ERROR_MESSAGE);
					}
				}
				catch(SQLException e1) {
				e1.printStackTrace();
			}
			Window.dbDis();

		
		}
	});
		btnNewButton_1.setFont(new Font("나눔고딕", Font.BOLD, 18));
		btnNewButton_1.setBounds(353, 80, 68, 29);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\uBCC0\uACBD PW");
		lblNewLabel_1_1.setFont(new Font("나눔고딕", Font.ITALIC, 14));
		lblNewLabel_1_1.setBounds(29, 129, 82, 21);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("\uBCC0\uACBD PW \uD655\uC778");
		lblNewLabel_1_1_1.setFont(new Font("나눔고딕", Font.ITALIC, 14));
		lblNewLabel_1_1_1.setBounds(29, 181, 119, 21);
		contentPane.add(lblNewLabel_1_1_1);
		
		JButton btnNewButton_2 = new JButton("\uBCC0\uACBD");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Window.dbConnect();
				pw = textField.getText();

				String sql = "select * from login where pw like '" + Login.login + "'";
				try {
					rs = stmt.executeQuery(sql);
					if(true) {
						JOptionPane.showConfirmDialog(null, "기존 비밀번호가 변경되었습니다.", "성공", JOptionPane.PLAIN_MESSAGE);

						if(rs.next()) {
							query("update", "updeat login set pw = '"+pw+"'");
						}
					}
					else {
						JOptionPane.showConfirmDialog(null, "비밀번호가 맞지않습니다", "실패", JOptionPane.ERROR_MESSAGE);
					}
				}
				catch(SQLException e1) {
				e1.printStackTrace();
			}
			Window.dbDis();

		
		}
	});
		btnNewButton_2.setFont(new Font("나눔고딕", Font.BOLD, 18));
		btnNewButton_2.setBounds(353, 176, 74, 29);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("E-mail");
		lblNewLabel_1_1_1_1.setFont(new Font("나눔고딕", Font.ITALIC, 14));
		lblNewLabel_1_1_1_1.setBounds(29, 231, 74, 21);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(116, 226, 102, 27);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel_2 = new JLabel("@");
		lblNewLabel_2.setFont(new Font("Gulim", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(223, 229, 36, 21);
		contentPane.add(lblNewLabel_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(252, 226, 112, 27);
		contentPane.add(textField_4);
		
		JButton btnNewButton_2_1 = new JButton("\uD655\uC778");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbConnect();
				pw = textField.getText();

				String sql = "select * from login where pw like '" + Login.login + "'";
				try {
					rs = stmt.executeQuery(sql);
					if(true) {
						JOptionPane.showConfirmDialog(null, "기존의 이메일 주소가 맞습니다.", "성공", JOptionPane.PLAIN_MESSAGE);

						if(rs.next()) {
							query("update", "updeat login set pw = '"+pw+"'");
						}
					}
					else {
						JOptionPane.showConfirmDialog(null, "기존의 이메일 주소가 맞지않습니다", "실패", JOptionPane.ERROR_MESSAGE);
					}
				}
				catch(SQLException e1) {
				e1.printStackTrace();
			}
			Window.dbDis();

		
		}
	});
		
		btnNewButton_2_1.setFont(new Font("나눔고딕", Font.BOLD, 18));
		btnNewButton_2_1.setBounds(381, 225, 74, 29);
		contentPane.add(btnNewButton_2_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(115, 124, 216, 27);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(126, 176, 205, 27);
		contentPane.add(passwordField_1);
		
		JButton btnNewButton_3 = new JButton("\uB85C\uADF8\uC778 \uCC3D\uAC00\uAE30");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Login().setVisible(true);
			}
		});
		btnNewButton_3.setFont(new Font("나눔고딕", Font.BOLD, 15));
		btnNewButton_3.setBounds(252, 24, 129, 29);
		contentPane.add(btnNewButton_3);
		
		
	}
}
