package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.table.DefaultTableModel;

public class tabEdit extends JPanel{
	static JTextField inputWord;
	private String oldValueInputWordString = null;
	static JTable historyEdit;
	static JTextArea editInformation;
	static JTextArea editSynonym;
	static JTextArea editAntonym;
	static JButton fixWord;
	static JButton removeWord;
	static JButton insertWord;
	static JTextField editSpell;
	private JLabel lblNewLabel_2;
	private JLabel editBackground;
	public tabEdit() {
		setLayout(null);
		inputWord = new JTextField();
		inputWord.setBackground(new Color(255, 255, 153));
		inputWord.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				String word = inputWord.getText().trim();
				if (oldValueInputWordString == null||!word.equals(oldValueInputWordString)) {
					editInformation.setText("");
					editSynonym.setText("");
					editAntonym.setText("");
					editSpell.setText("");
					
				} 
				oldValueInputWordString = word;
				if (word.length() > 0) {
					if (Action.wordHasInDatabase(word)) {
						Action.setInfomation(word, editInformation , editSynonym, editAntonym, editSpell);
						fixWord.setVisible(true);
						removeWord.setVisible(true);
						insertWord.setVisible(false);
						
					} else {
						fixWord.setVisible(false);
						removeWord.setVisible(false);
						insertWord.setVisible(true);
					}
				} 
			}
		});
		inputWord.setBounds(46, 52, 257, 39);
		add(inputWord);
		inputWord.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nhập từ");
		lblNewLabel_1.setBounds(46, 29, 107, 13);
		add(lblNewLabel_1);
		
		fixWord = new JButton("Sửa từ");
		fixWord.setBackground(new Color(255, 204, 102));
		fixWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Action.fixWord(inputWord.getText().trim());
				Action.showHistoryEdit();
			}
		});
		fixWord.setVisible(false);
		fixWord.setBounds(46, 112, 85, 21);
		add(fixWord);
		
		removeWord = new JButton("Xóa từ");
		removeWord.setBackground(new Color(255, 204, 102));
		removeWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Action.removeWord(inputWord.getText().trim());
				Action.showHistoryEdit();
			}
		});
		removeWord.setVisible(false);
		removeWord.setBounds(155, 112, 85, 21);
		add(removeWord);
		
		insertWord = new JButton("Thêm từ");
		insertWord.setBackground(new Color(255, 204, 102));
		insertWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Action.insertWord();
				Action.showHistoryEdit();
			}
		});
		insertWord.setVisible(false);
		insertWord.setBounds(269, 112, 85, 21);
		add(insertWord);
		
		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(531, 52, 525, 277);
		add(scrollPane_6);
		
		editInformation = new JTextArea();
		editInformation.setBackground(new Color(255, 255, 204));
		editInformation.setLineWrap(true);
		editInformation.setWrapStyleWord(true);
		scrollPane_6.setViewportView(editInformation);
		
		JLabel lblNewLabel_4 = new JLabel("Information");
		lblNewLabel_4.setBackground(new Color(255, 153, 153));
		scrollPane_6.setColumnHeaderView(lblNewLabel_4);
		
		JScrollPane scrollPane_6_1 = new JScrollPane();
		scrollPane_6_1.setBackground(new Color(255, 153, 204));
		scrollPane_6_1.setBounds(531, 349, 525, 110);
		add(scrollPane_6_1);
		
		editSynonym = new JTextArea();
		editSynonym.setBackground(new Color(255, 255, 153));
		editSynonym.setWrapStyleWord(true);
		scrollPane_6_1.setViewportView(editSynonym);
		
		JLabel lblNewLabel_7 = new JLabel("Synonym");
		scrollPane_6_1.setColumnHeaderView(lblNewLabel_7);
		
		JScrollPane scrollPane_7 = new JScrollPane();
		scrollPane_7.setBounds(531, 482, 525, 110);
		add(scrollPane_7);
		
		editAntonym = new JTextArea();
		editAntonym.setBackground(new Color(204, 255, 153));
		editAntonym.setWrapStyleWord(true);
		scrollPane_7.setViewportView(editAntonym);
		
		JLabel lblNewLabel_8 = new JLabel("Antonym");
		lblNewLabel_8.setBackground(new Color(153, 255, 153));
		scrollPane_7.setColumnHeaderView(lblNewLabel_8);
		
		historyEdit = new JTable();
		historyEdit.setBackground(new Color(255, 204, 153));
		historyEdit.setRowHeight(30);
		historyEdit.setForeground(Color.BLACK);
		historyEdit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		historyEdit.setShowGrid(false);
		historyEdit.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		historyEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				///Action
				int[] rows = historyEdit.getSelectedRows();
				if (rows.length > 0) {
					String temp = (String) historyEdit.getValueAt(rows[0], 1);
					inputWord.setText(temp);
					Action.showHistoryEdit();
				}
			}
		});
		historyEdit.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Time", "Words", "Status"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		historyEdit.getColumnModel().getColumn(0).setResizable(false);
		historyEdit.getColumnModel().getColumn(0).setPreferredWidth(120);
		historyEdit.getColumnModel().getColumn(1).setResizable(false);
		historyEdit.getColumnModel().getColumn(2).setResizable(false);
		historyEdit.getColumnModel().getColumn(2).setPreferredWidth(60);
		historyEdit.setBounds(46, 159, 457, 433);
		add(historyEdit);
		
		editSpell = new JTextField();
		editSpell.setBackground(new Color(204, 255, 255));
		editSpell.setBounds(375, 52, 128, 39);
		add(editSpell);
		editSpell.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Phiên âm");
		lblNewLabel_2.setBounds(375, 29, 85, 13);
		add(lblNewLabel_2);
		
		editBackground = new JLabel("");
		editBackground.setIcon(new ImageIcon(".\\Background\\DarkTheme\\Pink.jpg"));
		editBackground.setBounds(0, 0, 1104, 709);
		add(editBackground);
		
		Action.showHistoryEdit();
	}
}
