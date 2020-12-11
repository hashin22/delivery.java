package delivery;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.sql.*;
import java.sql.SQLException;
import java.util.Scanner;


public class List extends JFrame{
	
	private JPanel contentPane;
	private JTable table;
	private JTextField tf1;
	static String driver, url;
	static Statement stmt;
	static String tmpstr;
	static Connection conn;
	PreparedStatement pstmt;
	static ResultSet rs;
	JScrollPane scrollBar;
	private JTable table_3;
	
	
	
	private void dbconnect() { 
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
	public static void dbDis(){
		try {
			if (conn != null)
				conn.close();
			if (stmt != null)
				stmt.close();
			System.out.println("데이터베이스 연결 해제!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public List() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 546);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.desktop);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("[\uAC8C\uC2DC\uD310]");
		lblNewLabel.setForeground(SystemColor.window);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("[\uAC8C\uC2DC\uD310 \uBAA9\uB85D]");
		lblNewLabel_1.setToolTipText("\uC548\uB155\uD558\uC138\uC694");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(364, 15, 129, 40);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				new MainPage().setVisible(true);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\82102\\Documents\\\uCE74\uCE74\uC624\uD1A1 \uBC1B\uC740 \uD30C\uC77C\\KakaoTalk_20201111_202119214.png"));
		btnNewButton_1.setBounds(35, 15, 50, 50);
		contentPane.add(btnNewButton_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(17, 80, 806, 368);
		contentPane.add(scrollPane);
		String[] head = {"title","content"};
		DefaultTableModel model = new DefaultTableModel(head,0);
		dbconnect();
		String sql = "select * from board";
		try {
			rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				model.addRow(new Object[] {rs.getString("title"),
						rs.getString("content")
				});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table_3 = new JTable(model);
		scrollPane.setViewportView(table_3);

		JLabel lblNewLabel_2 = new JLabel("<- \uB3CC\uC544\uAC00\uAE30");
		lblNewLabel_2.setFont(new Font("나눔고딕", Font.BOLD, 16));
		lblNewLabel_2.setBounds(102, 25, 82, 21);
		contentPane.add(lblNewLabel_2);

		JButton btnNewButton = new JButton("\uC218\uC815");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String title = title.getText();
				String content = content.getText();
			
//				번호를 기준으로 수정된 이름과 주소를 수정하는 메소드 
				update(title, content);
//				삭제처리 데이터를 데이터베이스에서 다시 읽어와서 result 벡터에 저장 
				Vector result = selectAll();
//				변경된 데이터(벡터)로 모델 갱신 -> 테이블 표시 갱신됨
				model.setDataVector(result, title);
				
		
			
			});
		btnNewButton.setFont(new Font("나눔고딕", Font.BOLD, 16));
		btnNewButton.setBounds(554, 36, 129, 29);
		
		
		contentPane.add(btnNewButton);
	
		
	
		
		JButton btnNewButton_2 = new JButton("\uC0AD\uC81C");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				삭제 버튼에 이벤트(클릭시) 처리 -> 텍스트 필드에 입력된 번호값으로 데이터베이스에 
//				해당 번호의 레코드를 삭제(Delete) 하는 영역
//						텍스트필드에 있는 번호값 변수에 대입
						String num = title.getText();	
//						번호값으로 데이터베이스에서 해당 레크드를 삭제하는 메소드
						delete(title);
//						삭제처리 데이터를 데이터베이스에서 다시 읽어와서 result 벡터에 저장 
						Vector result = selectAll();
//						변경된 데이터(벡터)로 모델 갱신 -> 테이블 표시 갱신됨
						model.setDataVector(result, title);
			}		
		});
		btnNewButton_2.setFont(new Font("나눔고딕", Font.BOLD, 15));
		btnNewButton_2.setBounds(700, 36, 129, 29);
		contentPane.add(btnNewButton_2);
		
		Window.dbDis();
		
		

		
		
		
		
	
	
		
		setTitle("게시판");
			
	}
}
