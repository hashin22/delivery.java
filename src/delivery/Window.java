package delivery;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Window {
	static String driver, url;
	static Connection conn;
	static Statement stmt;
	static ResultSet rs;//static 다른클래스에서 쓸 수 있음.
	static String tmpstr;
	static long count = 0;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login(); //window빌드로 만들었던 화면 객체를 try하면 보이게 되는듯 이게 로그인 화면인듯. 디자인화면에서 하는듯?
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		try {
		}
		catch(Exception e) {
		}
		

	}
	

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

		public static void query(String order, String sql) throws SQLException {
			if (order == "select") {
				rs = stmt.executeQuery(sql);
			} 
			else {
				stmt.executeUpdate(sql);
			}
		}

//		public static void viewData() throws SQLException {
//			if(!rs.next()){
//				System.out.println("!rs.next()");
//				count--;
//			}
//			else{		
//					System.out.println("rs.next()");
//					num_t.setText(String.valueOf(rs.getLong("id"))); //필드명
//		
//					name_t.setText(rs.getString("name"));
//						
//					telNo_t.setText(rs.getString("telNo"));
//			}
//		}

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

		

		
	}

