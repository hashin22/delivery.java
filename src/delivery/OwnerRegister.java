package delivery;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.TextArea;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Canvas;
import java.awt.Button;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.SystemColor;

public class OwnerRegister extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OwnerRegister frame = new OwnerRegister();
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
	public OwnerRegister() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\uB9E4\uC7A5 \uC0C1\uD638\uBA85 \uC785\uB825");
		lblNewLabel.setFont(new Font("³ª´®°íµñ", Font.BOLD, 18));
		lblNewLabel.setBounds(138, 15, 151, 21);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\82102\\Documents\\\uCE74\uCE74\uC624\uD1A1 \uBC1B\uC740 \uD30C\uC77C\\KakaoTalk_20201111_202119214.png"));
		btnNewButton_1.setBounds(361, 10, 50, 50);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("\uD544\uC218!");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBackground(Color.ORANGE);
		lblNewLabel_1.setFont(new Font("³ª´®°íµñ", Font.BOLD, 15));
		lblNewLabel_1.setBounds(17, 68, 82, 21);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(46, 91, 326, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("! \uC815\uD655\uD55C \uC0C1\uD638\uBA85\uC744 \uC785\uB825\uD574 \uC8FC\uC138\uC694.\r\n");
		lblNewLabel_2.setFont(new Font("³ª´®°íµñ", Font.BOLD, 18));
		lblNewLabel_2.setBounds(72, 133, 266, 40);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\uC608) \uC54C\uD30C \uB3D9\uC758\uB300\uD559 1\uD638\uC810");
		lblNewLabel_3.setFont(new Font("³ª´®°íµñ", Font.BOLD, 18));
		lblNewLabel_3.setBounds(106, 166, 195, 21);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("\uC800\uC7A5");
		btnNewButton.setFont(new Font("³ª´®°íµñ", Font.BOLD, 18));
		btnNewButton.setBounds(138, 200, 129, 29);
		contentPane.add(btnNewButton);
		setTitle("¸ÅÀåµî·Ï(°ü¸®ÀÚ)");
		
		
	}
}
