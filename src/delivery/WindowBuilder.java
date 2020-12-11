package delivery;
import java.awt.BorderLayout; 
import java.awt.Dimension; 
import java.awt.EventQueue; 
import java.awt.FileDialog; 
import java.awt.GridLayout; 
import java.awt.Toolkit; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.io.BufferedWriter; 
import java.io.FileWriter; 
import java.nio.file.Files; 
import java.nio.file.Paths; 
import java.util.List; 
import javax.swing.JButton; 
import javax.swing.JFrame; 
import javax.swing.JOptionPane; 
import javax.swing.JPanel; 
import javax.swing.JScrollPane; 
import javax.swing.JTable; 
import javax.swing.border.EmptyBorder; 
import javax.swing.table.DefaultTableModel;
import java.awt.Color; 
public class WindowBuilder extends JFrame { 
  private static final long serialVersionUID = 3556819813305947955L; 
  private static final int FRAME_WIDTH = 600; 
  private static final int FRAME_HEIGHT = 300; 
  protected static final int DATE = 0; 
  protected static final int WEIGHT = 1; 
  protected static final int MEMO = 2; 
  private JPanel contentPane; 
  private JTable table; 
  private DefaultTableModel dtmStorage; 
  /** 
  * Launch the application. 
  */ 
  public static void main(String[] args) { 
    EventQueue.invokeLater(new Runnable() { 
      public void run() { 
        try { 
          WindowBuilder frame = new WindowBuilder(); 
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
public WindowBuilder() { 
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
  Dimension screen = Toolkit.getDefaultToolkit().getScreenSize(); 
  setBounds((screen.width - FRAME_WIDTH) / 2, (screen.height - FRAME_HEIGHT) / 2, FRAME_WIDTH, FRAME_HEIGHT); 
  contentPane = new JPanel(new BorderLayout()); 
  contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); 
  setContentPane(contentPane); 
  JScrollPane scrollPane = new JScrollPane(); 
  contentPane.add(scrollPane, BorderLayout.NORTH); 
  JPanel buttonPanel = new JPanel(new GridLayout(2, 0)); 
  JButton saveButton = new JButton("SAVE"); 
  JButton loadButton = new JButton("LOAD"); 
  buttonPanel.add(saveButton); 
  buttonPanel.add(loadButton); 
  saveButton.addActionListener(new ActionListener() { 
    @Override 
    public void actionPerformed(ActionEvent e) { 
      FileDialog dialog = new FileDialog(WindowBuilder.this, "����", FileDialog.SAVE); 
      dialog.setDirectory("."); // .�� �������� 
      dialog.setVisible(true); 
      // 2. FileDialog�� ������ ����Ǿ����� 
      if (dialog.getFile() == null) 
      return; // �̰ɻ��� ��Ҹ� �ص� �����̵� 
      // 3. ��θ� ���ϸ� ���� 
      String dfName = dialog.getDirectory() + dialog.getFile(); 
      // 4. ���� ���� 
      try { 
        BufferedWriter writer = new BufferedWriter(new FileWriter(dfName)); 
        DefaultTableModel dtm = (DefaultTableModel) table.getModel(); 
        for (int i = 0; i < table.getRowCount(); i++) { 
          String date = String.valueOf(dtm.getValueAt(i, DATE)); 
          String weight = String.valueOf(dtm.getValueAt(i, WEIGHT)); 
          String memo = String.valueOf(dtm.getValueAt(i, MEMO)); 
          writer.write(String.format("%s|%s|%s\n", date, weight, memo)); 
       } 
       writer.flush(); 
       writer.close(); 
       setTitle(dialog.getFile() + " - �޸���"); 
       } catch (Exception e2) { 
       JOptionPane.showMessageDialog(WindowBuilder.this, "���� ����"); 
    } 
 } 
}); 
loadButton.addActionListener(new ActionListener() { 
  @Override 
  public void actionPerformed(ActionEvent e) { 
    // 1. FileDialog�� ���� �ҷ��� ���� ���� 
    FileDialog dialog = new FileDialog(WindowBuilder.this, "����", FileDialog.LOAD); 
    dialog.setDirectory("."); // .�� �������� 
    dialog.setVisible(true); 
    // 2. FileDialog�� ������ ����Ǿ����� 
    if (dialog.getFile() == null) 
    return; 
    // 3. �ҷ��� ������ ��θ� ���� 
    String dfName = dialog.getDirectory() + dialog.getFile(); 
    // 4. ���� ����, TextArea�� �ѷ��ֱ� 
    try { 
      List<String> lines = Files.readAllLines(Paths.get(dfName)); 
      String line = null; 
      String[] splitedLine = null; 
      DefaultTableModel dtm = (DefaultTableModel) table.getModel(); 
      for (int i = 0; i < lines.size(); i++) { 
        line = lines.get(i); 
        splitedLine = line.split("\\|"); 
        dtm.setValueAt(splitedLine.length >= 1 ? String.valueOf(splitedLine[0]) : "", i, DATE); 
        dtm.setValueAt(splitedLine.length >= 2 ? String.valueOf(splitedLine[1]) : "", i, WEIGHT); 
        dtm.setValueAt(splitedLine.length >= 3 ? String.valueOf(splitedLine[2]) : "", i, MEMO); 
     } 
     setTitle(dialog.getFile()); 
     } catch (Exception e2) { 
     e2.printStackTrace(); 
     JOptionPane.showMessageDialog(WindowBuilder.this, "���� ����"); 
  } 
} 
}); 
contentPane.add(buttonPanel, BorderLayout.EAST); 
String[] column = { "", "", "", "" }; // �÷� �̸� ���� 
// ���̺��� ����Ҷ� DefaultTablemodel�� ����ؾ� �پ��� ��� ��밡�� 
dtmStorage = new DefaultTableModel(column, 0) { 
  private static final long serialVersionUID = -1660428736713367350L; 
  public boolean isCellEditable(int row, int column) {// ���̺��� ����Ŭ���Ҷ� �������� 
    return true;// �� �������� 
 } 
}; 
table = new JTable(dtmStorage); 
table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN); 
table.setAutoCreateRowSorter(true); 
table.setCellSelectionEnabled(rootPaneCheckingEnabled); 
// ���̺��� JScrollPane ���� ���ƾ��� ��ũ���� ����� ��� �ڷḦ�������� 
scrollPane.setViewportView(table); 
dtmStorage.setColumnIdentifiers(new String[] { "��¥", "�ֹ��� ���ĸ޴�", "�޸�" }); 
// ���̺� �� ������ �ڷ���� 
for (int i = 1; i <= 31; i++) { 
  dtmStorage.addRow(new String[] { i + "��", "", "" }); 
} 
table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 
JButton btnNewButton = new JButton("\uBA54\uC778\uD654\uBA74\uC73C\uB85C \uAC00\uAE30");
btnNewButton.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
		setVisible(false);
		new MainPage().setVisible(true);
	}
});
btnNewButton.setForeground(Color.WHITE);
btnNewButton.setBackground(new Color(255, 192, 203));
contentPane.add(btnNewButton, BorderLayout.SOUTH);
setTitle("�ֹ�������ȸ");
table.getColumnModel().getColumn(0).setPreferredWidth(30); 
table.getColumnModel().getColumn(1).setPreferredWidth(100); 
table.getColumnModel().getColumn(2).setPreferredWidth(300); 
pack(); 
} 
} 