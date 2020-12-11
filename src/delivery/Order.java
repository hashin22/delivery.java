package delivery;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Order extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Order frame = new Order();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Order() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 712, 474);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.desktop);
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		textField = new JTextField();
		textField.setBounds(53, 68, 166, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\uBA54\uB274\uAC80\uC0C9");
		lblNewLabel.setFont(new Font("³ª´®°íµñ", Font.BOLD, 18));
		lblNewLabel.setBounds(53, 37, 82, 21);
		contentPane.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(53, 147, 221, 256);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\uBA54\uB274 \uBAA9\uB85D");
		lblNewLabel_1.setFont(new Font("³ª´®°íµñ", Font.BOLD, 18));
		lblNewLabel_1.setBounds(53, 111, 82, 21);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_2 = new JButton("\uC8FC\uBB38\uD558\uAE30");
		btnNewButton_2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				Object frame = null;
				int result = 0 ;
				JOptionPane.showConfirmDialog((Component) frame, "ÁÖ¹®ÇÏ½Ã°Ú½À´Ï±î?", "¸Þ´ºÁÖ¹® Ã¢", JOptionPane.YES_NO_OPTION);
//				String result;
				System.out.println("¼±ÅÃ°á°ú : " + result);
				if(result == JOptionPane.YES_OPTION) {
					System.exit(0);
				}else {
				System.out.println("Ãë¼Ò");
				}
			}
	
		});
		btnNewButton_2.setFont(new Font("³ª´®°íµñ", Font.BOLD, 17));
		btnNewButton_2.setBounds(291, 221, 141, 66);
		contentPane.add(btnNewButton_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(449, 146, 166, 257);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\uC8FC\uBB38 \uB0B4\uC5ED");
		lblNewLabel_2.setFont(new Font("³ª´®°íµñ", Font.BOLD, 18));
		lblNewLabel_2.setBounds(450, 110, 82, 21);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new MainPage().setVisible(true);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\82102\\Documents\\\uCE74\uCE74\uC624\uD1A1 \uBC1B\uC740 \uD30C\uC77C\\KakaoTalk_20201111_202119214.png"));
		btnNewButton_1.setBounds(565, 50, 50, 50);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("");
		btnNewButton_1_1.setIcon(new ImageIcon("C:\\Users\\82102\\Desktop\\\uB3CB\uBCF4\uAE30.png"));
		btnNewButton_1_1.setBounds(236, 50, 50, 50);
		contentPane.add(btnNewButton_1_1);
		setTitle("ÁÖ¹®ÇÏ±â");
		
	}

}
