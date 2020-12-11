package delivery;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JEditorPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;

public class Write extends JFrame {
	static String driver, url;
	static Connection conn;
	static Statement stmt;
	static ResultSet rs;///////////static 다른클래스에서 쓸 수 있음.////////
	static String tmpstr;
	static long count = 0;
	
	private JPanel contentPane;
	private JButton btnNewButton;
	private JTextField textField_2;
	private JTextField textField;
	private JButton btnNewButton_2;

	public static void dbConnect() { 
    	driver = "sun.jdbc.odbc.JdbcOdbcDriver";
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
        String url = "jdbc:mysql://localhost/company?useUnicode=yes&characterEncoding=UTF-8";
        String sql = "Select * From board";
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
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Write() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 675, 531);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.desktop);
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		btnNewButton = new JButton("\uC644\uB8CC");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbConnect();
				String sql = "insert into board(title, content) values('" +textField_2.getText()+ "','" +textField.getText()+"')";
				try {
					stmt.executeUpdate(sql); 
					//JOptionPane.showMessageDialog(null, "성공");
					setVisible(false);
					new List().setVisible(true);
				} catch (Exception e1) {
				e1.printStackTrace();
			}
				Window.dbDis();
				
			}
		
		});

		btnNewButton.setBounds(317, 15, 129, 29);
		contentPane.add(btnNewButton);
		
		textField_2 = new JTextField();
		textField_2.setForeground(Color.GRAY);
		textField_2.setText("\uC81C\uBAA9\uC744 \uC791\uC131\uD574\uC8FC\uC138\uC694.");
		textField_2.setBounds(29, 15, 271, 27);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField = new JTextField();
		textField.setForeground(Color.GRAY);
		textField.setText("\uB0B4\uC6A9\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694.");
		textField.setBounds(10, 60, 609, 400);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				new MainPage().setVisible(true);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\82102\\Documents\\\uCE74\uCE74\uC624\uD1A1 \uBC1B\uC740 \uD30C\uC77C\\KakaoTalk_20201111_202119214.png"));
		btnNewButton_2.setBounds(549, 4, 50, 50);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("\uB3CC\uC544\uAC00\uAE30 ->");
		lblNewLabel.setFont(new Font("나눔고딕", Font.BOLD, 15));
		lblNewLabel.setBounds(463, 19, 82, 21);
		contentPane.add(lblNewLabel);
		
		setTitle("게시판");
		
		textField.addMouseListener(new MouseAdapter(){
	            @Override
	            public void mouseClicked(MouseEvent e){
	            	textField.setText("");
	            }
	        });
	     
		textField_2.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
            	textField_2.setText("");
            }
        });
	}
}
