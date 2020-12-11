package delivery;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;

public class OutMember extends JFrame {
	static String driver, url;
	static Connection conn;
	static Statement stmt;
	static ResultSet rs;
	static String tmpstr;
	static long count = 0;
	
	private JPanel contentPane;
	private JTextField textField;
	
	/**
	 * Create the frame.
	 */
	
	public OutMember() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 428, 20);
		contentPane.add(menuBar);
		
		JButton btnNewButton = new JButton("\uBA54\uC778\uD654\uBA74\uC73C\uB85C \uAC00\uAE30");
		btnNewButton.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				new MainPage().setVisible(true);
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.PINK);
		menuBar.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(31, 109, 283, 53);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\uD0C8\uD1F4\uC0AC\uC720");
		lblNewLabel.setFont(new Font("³ª´®°íµñ", Font.BOLD, 15));
		lblNewLabel.setBounds(31, 59, 56, 53);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("\uD0C8\uD1F4");
		btnNewButton_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				Object frame = null;
				int result = 0 ;
				JOptionPane.showConfirmDialog((Component) frame, "ÁøÂ¥·Î Å»ÅðÇÏ½Ê´Ï±î", "È¸¿ø Å»Åð Ã¢", JOptionPane.YES_NO_OPTION);
//				String result;
				System.out.println("¼±ÅÃ°á°ú : " + result);
				if(result == JOptionPane.YES_OPTION) {
					System.exit(0);
					
				}else {
				System.out.println("Ãë¼Ò");
				}
			}
		});
		
	
	
		btnNewButton_1.setFont(new Font("³ª´®°íµñ", Font.BOLD, 18));
		btnNewButton_1.setBounds(324, 109, 87, 53);
		contentPane.add(btnNewButton_1);
		
		setTitle("È¸¿øÅ»Åð");
	}
}
