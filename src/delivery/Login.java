package delivery;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtId;
	private JTextField txtPw;

	
	static String driver, url;

	static Connection conn;

	static Statement stmt;

	static ResultSet rs;
	
	static String id;
	static String pw;
	static String login;
	
//	static TextField id, password, name, number, address;
	static long count = 0;
	
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
	

	public Login() {
		dbConnect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.desktop);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		textField = new JTextField();
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\uB85C\uADF8\uC778");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbConnect();
	            id = txtId.getText();
	            pw = txtPw.getText();
	            
	               String sql = "select * from login where id like '" + id + "'";
	               try {
	                  rs = stmt.executeQuery(sql);
	               if(rs.next()) {
	                  if(pw.equals(rs.getString("pw"))) {
	                     login =txtId.getText();
	                     JOptionPane.showMessageDialog(null, "환영합니다.", "로그인 성공", JOptionPane.INFORMATION_MESSAGE);
	                     setVisible(false);
	                     new MainPage().setVisible(true);
	                  }
	                  else if(!(pw.equals(rs.getString("pw")))) {
	                     JOptionPane.showMessageDialog(null, "비밀번호가 틀렸습니다.", "비밀번호 오류", JOptionPane.WARNING_MESSAGE);
	                  }
	                  
	                                    
	               }
	            } catch (SQLException e1) {
	               // TODO Auto-generated catch block
	               e1.printStackTrace();
	            }
	               Window.dbDis();
			}
		});
		btnNewButton.setFont(new Font("나눔고딕", Font.BOLD, 18));
		btnNewButton.setBounds(245, 39, 129, 78);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btnNewButton_1.setFont(new Font("나눔고딕", Font.BOLD, 18));
		btnNewButton_1.setForeground(SystemColor.text);
		btnNewButton_1.setBackground(SystemColor.inactiveCaption);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Join().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(62, 142, 312, 29);
		contentPane.add(btnNewButton_1);
		
		txtId = new JTextField();
		
		txtId.setForeground(SystemColor.textInactiveText);
		txtId.setText(" ID");
		txtId.setBounds(72, 39, 149, 27);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		txtPw = new JTextField();
		txtPw.setHorizontalAlignment(SwingConstants.LEFT);
		txtPw.setForeground(SystemColor.textInactiveText);
		txtPw.setText("PW");
		txtPw.setBounds(72, 90, 144, 27);
		contentPane.add(txtPw);
		txtPw.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("\uBE44\uBC00\uBC88\uD638 \uBCC0\uACBD\uD558\uAE30");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbConnect();
	            id = txtId.getText();
	            pw = txtPw.getText();
	            
	               String sql = "select * from login where id like '" + id + "'";
	               try {
	                  rs = stmt.executeQuery(sql);
	               if(rs.next()) {
	                  if(pw.equals(rs.getString("pw"))) {
	                     login =txtPw.getText();
	                     JOptionPane.showMessageDialog(null, "환영합니다.", "로그인 성공", JOptionPane.PLAIN_MESSAGE);
	                     setVisible(false);
	                     new MainPage().setVisible(true);
	                  }
	                  else if(!(pw.equals(rs.getString("pw")))) {
	                     JOptionPane.showMessageDialog(null, "비밀번호가 틀렸습니다.", "비밀번호 오류", JOptionPane.WARNING_MESSAGE);
	                  }
	                  
	                                    
	               }
	            } catch (SQLException e1) {
	               // TODO Auto-generated catch block
	               e1.printStackTrace();
	            }
	               Window.dbDis();
			}
		});
		btnNewButton_2.setBackground(SystemColor.inactiveCaption);
		btnNewButton_2.setForeground(SystemColor.text);
		btnNewButton_2.setBounds(62, 186, 312, 29);
		contentPane.add(btnNewButton_2);
		setTitle("로그인화면");
		
		txtId.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
               txtId.setText("");
            }
        });
		
		txtPw.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
               txtPw.setText("");
            }
        });
		
	}
}
