package delivery;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import java.awt.Button;

public class MainPage extends JFrame {

	private JPanel contentPane;

	public MainPage() {

		String i = "ti";
		Window.dbConnect();
		
		JButton btnNewButton = new JButton("New button");
		getContentPane().add(btnNewButton, BorderLayout.SOUTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 531);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.desktop);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(10, 306, 250, 25);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("My Page");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\uAC1C\uC778\uC815\uBCF4\uC218\uC815");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				new ChangePassword().setVisible(true);
			}
		});

		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\uC8FC\uBB38\uB0B4\uC5ED\uC870\uD68C");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				new WindowBuilder().setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\uC8FC\uBB38\uD558\uAE30");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				new Order().setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("\uB85C\uADF8\uC544\uC6C3");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				new Login().setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_1 = new JMenu("\uBA54\uB274\uD310\uBCF4\uAE30");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("\uD53C\uC790");
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\uCE58\uD0A8");
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("\uD584\uBC84\uAC70");
		mnNewMenu_1.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("\uCCA0\uD310\uC21C\uB300\uBCF6\uC74C");
		mnNewMenu_1.add(mntmNewMenuItem_7);
		
		JMenu mnNewMenu_2 = new JMenu("\uAC8C\uC2DC\uD310");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("\uAC8C\uC2DC\uD310 \uC791\uC131");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Write().setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("\uAC8C\uC2DC\uD310 \uBCF4\uAE30");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new List().setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_9);
		
		JButton btnNewButton_2 = new JButton("\uB85C\uADF8\uC544\uC6C3");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Login().setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("³ª´®°íµñ", Font.BOLD, 18));
		btnNewButton_2.setBounds(17, 108, 129, 29);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("\uBA54\uB274\uD310\uBCF4\uAE30");
		lblNewLabel.setFont(new Font("±¼¸²", Font.ITALIC, 18));
		lblNewLabel.setBounds(332, 306, 114, 21);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_4 = new JButton("\uC8FC\uBB38\uB0B4\uC5ED\uBCF4\uAE30");
		btnNewButton_4.setFont(new Font("³ª´®°íµñ", Font.BOLD, 16));
		btnNewButton_4.setBounds(17, 152, 129, 29);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel_1 = new JLabel("\uB098\uC758 \uAC1C\uC778\uC815\uBCF4");
		lblNewLabel_1.setBackground(SystemColor.activeCaption);
		lblNewLabel_1.setFont(new Font("³ª´®°íµñ ExtraBold", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 15, 136, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("_______\uB2D8 \uC5B4\uC11C\uC624\uC138\uC694^^");
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setForeground(new Color(255, 204, 255));
		lblNewLabel_2.setFont(new Font("³ª´®°íµñ", Font.ITALIC, 14));
		lblNewLabel_2.setBounds(98, 56, 178, 50);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_2_1 = new JButton("");
		btnNewButton_2_1.setIcon(new ImageIcon("C:\\Users\\82102\\Documents\\\uCE74\uCE74\uC624\uD1A1 \uBC1B\uC740 \uD30C\uC77C\\KakaoTalk_20201111_202119214.png"));
		btnNewButton_2_1.setBounds(10, 45, 50, 50);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_1 = new JButton("\uC774\uB3D9");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new MenuPage(i).setVisible(true);
				Window.dbConnect();
				
			}
			
		});
		btnNewButton_1.setBounds(445, 302, 86, 29);
		contentPane.add(btnNewButton_1);
		
		JFormattedTextField frmtdtxtfldMyharan = new JFormattedTextField();
		frmtdtxtfldMyharan.setText("myharan");
		frmtdtxtfldMyharan.setBounds(69, 66, 77, 27);
		contentPane.add(frmtdtxtfldMyharan);
		
		JButton btnNewButton_2_1_1 = new JButton("");
		btnNewButton_2_1_1.setIcon(new ImageIcon("C:\\Users\\82102\\Desktop\\\uD654\uBA74 \uCEA1\uCC98 2020-11-25 212721.png"));
		btnNewButton_2_1_1.setBounds(259, 32, 272, 200);
		contentPane.add(btnNewButton_2_1_1);

		setTitle("¸ÞÀÎÈ­¸é");
		
	

		
	
		
	
		
		
	}
}
