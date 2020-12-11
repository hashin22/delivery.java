package delivery;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class MenuPage extends JFrame implements ActionListener {

	static Label num, name, telNo;
	static TextField id, name_t, telNo_t;
	JButton reloaddown, reloadup,save,update,delete;
	Panel pan1, pan2, pan3, pan4;
	static String driver, url;//
	static Connection conn;
	static Statement stmt;
	static ResultSet rs;
	static String tmpstr;
	static long count = 0;
	private JButton btnNewButton;


	public MenuPage(String title) {
		super(title);
		getContentPane().setLayout(new GridLayout(4, 1));
		num = new Label("번호");
		name = new Label("이름");
		telNo = new Label("가격");
		telNo.setFont(new Font("나눔고딕", Font.BOLD, 16));

		id = new TextField(20);
		name_t = new TextField(20);
		telNo_t = new TextField(20);
		reloadup = new JButton(">");
		reloadup.setFont(new Font("나눔고딕", Font.BOLD, 18));
		reloadup.addActionListener(this);		

		pan1 = new Panel();
		pan1.setBackground(SystemColor.desktop);
		pan2 = new Panel();
		pan2.setBackground(SystemColor.desktop);
		pan3 = new Panel();
		pan3.setBackground(SystemColor.desktop);
		pan4 = new Panel();
		pan4.setBackground(SystemColor.desktop);

		pan1.add(num);
		pan1.add(id);
		pan2.add(name);
		pan2.add(name_t);
		pan3.add(telNo);
		pan3.add(telNo_t);
		
				reloaddown = new JButton("<");
				reloaddown.setFont(new Font("나눔고딕", Font.BOLD, 18));
				reloaddown.addActionListener(this);
				pan4.add(reloaddown);
		
		btnNewButton = new JButton("\uBA54\uC778\uD654\uBA74\uC73C\uB85C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				new MainPage().setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("나눔고딕", Font.BOLD, 18));
		pan4.add(btnNewButton);
		pan4.add(reloadup);

		getContentPane().add(pan1);
		save = new JButton("\u2665");		
		pan1.add(save);
		save.setFont(new Font("나눔고딕", Font.BOLD, 18));
		save.addActionListener(this);
		getContentPane().add(pan2);
		update = new JButton("\u2665");
		pan2.add(update);
		update.setFont(new Font("나눔고딕", Font.BOLD, 18));
		update.addActionListener(this);
		getContentPane().add(pan3);
		delete = new JButton("\u2665");
		pan3.add(delete);
		delete.setFont(new Font("나눔고딕", Font.BOLD, 18));
		delete.addActionListener(this);
		getContentPane().add(pan4);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(490,520);
		setVisible(true);
		

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
        String sql = "Select * From customer";
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
		else if (order == "insert") {
			stmt.executeUpdate(sql);
		}
		else {
			stmt.executeUpdate(sql);
		}
	}

	public static void viewData() throws SQLException {
		if(!rs.next()){
			System.out.println("!rs.next()");
			count--;
		}
		else{		
				System.out.println("rs.next()");
				id.setText(String.valueOf(rs.getLong("id")));
	
				name_t.setText(rs.getString("name"));
					
				telNo_t.setText(rs.getString("telNo"));
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

	public static void main(String[] args) throws SQLException {

		new MenuPage("메뉴보기");
		dbConnect();
		query("select", "select * from customer where id = 1");
		count = 1;
		viewData();
		dbDis();
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		int a = Integer.parseInt(id.getText());
		if (e.getSource() == save) {
			dbConnect();
			try {
				query("insert", "insert into customer values('" + a + "','" + name + "','" + telNo + "')");
				JOptionPane.showMessageDialog(null, "성공");
				setVisible(false);
//				new 창이동할거
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}			
			System.out.println("새항목 추가완료");
			dbDis();

			//num_t.setText("");
			name_t.setText("");
			telNo_t.setText("");
		} 
		else if (e.getSource() == reloaddown) {
			dbConnect();
			try	{

				count--;
				if(count < 1){
					System.out.println("count error");
					count++;
				}
				id.setText(String.valueOf(count));
				query("select", "select * from customer where id = " +count + "");
				viewData();
				System.out.println("데이터베이스 로드완료");
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			dbDis();
		}
		else if (e.getSource() == reloadup) {
			dbConnect();
			try {
				count++;
				id.setText(String.valueOf(count));
				query("select", "select * from customer where id = " +count + "");
				viewData();
				System.out.println("데이터베이스 로드완료");
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			dbDis();
		}
		else if (e.getSource() == update) {
			dbConnect();
			try {
				query("update", "update customer set telNo = '" + telNo_t.getText() + "' , name = '" + name_t.getText() + "' where id = " + count + "");
				//viewData();
				System.out.println("데이터베이스 수정완료");
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			dbDis();
		}
		else if (e.getSource() == delete) {
			dbConnect();
			try {
				query("delete", "delete from customer where id = " +id.getText() + " ");
				//viewData();
				System.out.println("데이터베이스 삭제완료");
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			dbDis();
		}
	}
}
