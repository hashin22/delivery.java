package delivery;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import java.awt.Button;
import java.awt.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class ten extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ten frame = new ten();
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
	public ten() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.desktop);
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\uC8FC\uBB38\uB0B4\uC5ED\uBCF4\uAE30");
		lblNewLabel.setFont(new Font("³ª´®°íµñ ExtraBold", Font.BOLD, 18));
		lblNewLabel.setBounds(17, 15, 117, 21);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(17, 51, 361, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		List list = new List();
		list.setBounds(17, 84, 361, 132);
		contentPane.add(list);
		setTitle("ÁÖ¹®³»¿ªÈ®ÀÎ");
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\82102\\Documents\\\uCE74\uCE74\uC624\uD1A1 \uBC1B\uC740 \uD30C\uC77C\\KakaoTalk_20201111_202119214.png"));
		btnNewButton_1.setBounds(141, 0, 50, 50);
		contentPane.add(btnNewButton_1);
	}
}
