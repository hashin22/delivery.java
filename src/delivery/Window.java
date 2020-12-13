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
	static ResultSet rs;//static �ٸ�Ŭ�������� �� �� ����.
	static String tmpstr;
	static long count = 0;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login(); //window����� ������� ȭ�� ��ü�� try�ϸ� ���̰� �Ǵµ� �̰� �α��� ȭ���ε�. ������ȭ�鿡�� �ϴµ�?
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
	    		System.out.println("����̹� �˻� ����!");        
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
	            
	            System.out.println("�����ͺ��̽� ���� ����!");            
	         
	        }
	        catch(Exception e) {
	            System.out.println("�����ͺ��̽� ���� ����!");
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
//					num_t.setText(String.valueOf(rs.getLong("id"))); //�ʵ��
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
				System.out.println("�����ͺ��̽� ���� ����!");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		

		
	}

