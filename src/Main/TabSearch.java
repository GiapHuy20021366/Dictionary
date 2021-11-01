package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.table.DefaultTableModel;

import MyLib.TextToSpeech;

public class TabSearch extends JPanel{
	private JTextField searchTranslate;
	private JTabbedPane tabbedPane_1;
	private JPanel tabSynonym;
	private JPanel tabAnonym;
	private JLabel lblNewLabel;
	static JButton speakTranslate1;
	static JButton speakTranslate2;
	static JTable suggestionTable;
	static JTextArea synonyms;
	static JTextArea antonyms;
	static JTextArea informations;
	static JButton speakSearch;
	static JComboBox englishSearchVoices;
	private JScrollPane scrollPane_3;
	private JPanel tabInformation;
	static boolean mute1 = false;
	static boolean mute2 = false;
	static JSpinner speedSearch;
	private JLabel lblNewLabel_3;
	private JLabel backgroundSearch;
	public TabSearch() {
		setBackground(new Color(255, 69, 0));
		setSize(new Dimension(1000, 1000));
		setPreferredSize(new Dimension(1000, 1000));
		setFont(new Font("Times New Roman", Font.PLAIN, 17));
		setMinimumSize(new Dimension(100, 100));
		setLayout(null);
		
		lblNewLabel = new JLabel("Search Word");
		lblNewLabel.setBounds(10, 16, 193, 21);
		add(lblNewLabel);
		
		suggestionTable = new JTable();
		suggestionTable.setSurrendersFocusOnKeystroke(true);
		suggestionTable.setSize(new Dimension(300, 300));
		suggestionTable.setEditingRow(10);
		suggestionTable.setAutoCreateRowSorter(true);
		suggestionTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		suggestionTable.setGridColor(Color.WHITE);
		suggestionTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (suggestionTable.getRowCount() > 0) {
					ListSelectionModel listSelectionModel = suggestionTable.getSelectionModel();
					listSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					int[] rows = suggestionTable.getSelectedRows();
					if (rows.length > 0) {
						String temp = (String) suggestionTable.getValueAt(rows[0], 0);
						searchTranslate.setText(temp);
						Action.setInfomation(searchTranslate.getText(), informations, synonyms, antonyms, null);
					}
					speakSearch.setVisible(true);
					englishSearchVoices.setVisible(true);
					speedSearch.setVisible(true);
				}
				
				
			}
		});
		suggestionTable.setFillsViewportHeight(true);
		suggestionTable.setSelectionForeground(Color.BLACK);
		suggestionTable.setSelectionBackground(Color.YELLOW);
		suggestionTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		suggestionTable.setShowGrid(false);
		suggestionTable.setBackground(new Color(255, 255, 224));
		suggestionTable.setForeground(Color.BLACK);
		suggestionTable.setBorder(new EmptyBorder(0, 0, 0, 0));
		suggestionTable.setRowHeight(36);
		suggestionTable.setRowMargin(5);
		suggestionTable.setFont(new Font("Tahoma", Font.PLAIN, 22));
		suggestionTable.setColumnSelectionAllowed(true);
		suggestionTable.setCellSelectionEnabled(true);
		suggestionTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"HiWeOenRD"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		suggestionTable.getColumnModel().getColumn(0).setResizable(false);
		suggestionTable.getColumnModel().getColumn(0).setMinWidth(75);
		suggestionTable.setBounds(10, 93, 407, 573);
		add(suggestionTable);
		
		speakSearch = new JButton("");
		speakSearch.setVisible(false);
		speakSearch.setFocusPainted(false);
		speakSearch.setHideActionText(true);
		speakSearch.setHorizontalTextPosition(SwingConstants.CENTER);
		speakSearch.setVerifyInputWhenFocusTarget(false);
		speakSearch.setBorder(null);
		speakSearch.setIcon(new ImageIcon(".\\Icon\\volume32pixels.png"));
		speakSearch.setSelectedIcon(new ImageIcon(".\\Icon\\speaker.png"));
		speakSearch.setForeground(Color.WHITE);
		speakSearch.setBackground(new Color(255, 248, 220));
		speakSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (suggestionTable.getRowCount() > 0 ) {
					try {
						TextToSpeech.downloadEnglishVoice(searchTranslate.getText(),(String) englishSearchVoices.getSelectedItem(),(int) speedSearch.getValue());
						Action.speak(searchTranslate.getText(),(String) englishSearchVoices.getSelectedItem(),(int) speedSearch.getValue(), speakSearch);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}});
		speakSearch.setBounds(262, 39, 41, 44);
		add(speakSearch);
		
		searchTranslate = new JTextField();
		searchTranslate.setBackground(new Color(255, 239, 213));
		searchTranslate.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				speakSearch.setVisible(false);
				englishSearchVoices.setVisible(false);
				speedSearch.setVisible(false);
				String text = searchTranslate.getText();
				Action.autoSuggestion(searchTranslate.getText().trim());
			}
		});
		searchTranslate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		searchTranslate.setBounds(10, 39, 253, 44);
		add(searchTranslate);
		searchTranslate.setColumns(10);
		
		englishSearchVoices = new JComboBox();
		englishSearchVoices.setVisible(false);
		englishSearchVoices.setFocusable(false);
		englishSearchVoices.setBorder(new EmptyBorder(0, 0, 0, 0));
		englishSearchVoices.setBackground(new Color(176, 224, 230));
		englishSearchVoices.setFont(new Font("Tahoma", Font.PLAIN, 20));
		englishSearchVoices.setModel(new DefaultComboBoxModel(new String[] {"Linda", "Amy", "Mary", "John", "Mike"}));
		englishSearchVoices.setBounds(307, 39, 72, 44);
		add(englishSearchVoices);
		
		speedSearch = new JSpinner();
		speedSearch.setVisible(false);
		speedSearch.setBorder(new EmptyBorder(1, 0, 1, 0));
		speedSearch.setModel(new SpinnerNumberModel(0, -4, 4, 1));
		speedSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		speedSearch.setBounds(380, 39, 55, 44);
		JFormattedTextField typeMode = ((JSpinner.DefaultEditor) speedSearch.getEditor ()). getTextField ();
		typeMode.setBackground(Color.WHITE);
		typeMode.setEditable(false);
		add(speedSearch);
		tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tabbedPane_1.setBounds(471, 16, 609, 650);
		add(tabbedPane_1);
		
		
		tabInformation = new JPanel();
		tabInformation.setBackground(new Color(240, 230, 140));
		tabbedPane_1.addTab("Information", null, tabInformation, null);
		tabbedPane_1.setBackgroundAt(0, Color.WHITE);
		tabbedPane_1.setForegroundAt(0, Color.BLACK);
		tabInformation.setLayout(null);
		
		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBackground(Color.WHITE);
		scrollPane_3.setBorder(null);
		scrollPane_3.setBounds(0, 0, 604, 611);
		tabInformation.add(scrollPane_3);
		
		informations = new JTextArea();
		informations.setForeground(Color.BLACK);
		informations.setLineWrap(true);
		informations.setWrapStyleWord(true);
		informations.setBackground(new Color(238, 232, 170));
		informations.setBorder(null);
		informations.setFont(new Font("Monospaced", Font.PLAIN, 15));
		informations.setEditable(false);
		scrollPane_3.setViewportView(informations);
		
		tabSynonym = new JPanel();
		tabSynonym.setBackground(new Color(221, 160, 221));
		tabbedPane_1.addTab("Synonym", null, tabSynonym, null);
		tabbedPane_1.setBackgroundAt(1, Color.WHITE);
		tabSynonym.setLayout(null);
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBackground(Color.WHITE);
		scrollPane_5.setBorder(null);
		scrollPane_5.setBounds(0, 0, 604, 611);
		tabSynonym.add(scrollPane_5);
		
		synonyms = new JTextArea();
		synonyms.setBackground(new Color(255, 228, 196));
		synonyms.setFont(new Font("Monospaced", Font.PLAIN, 15));
		synonyms.setLineWrap(true);
		synonyms.setWrapStyleWord(true);
		synonyms.setEditable(false);
		scrollPane_5.setViewportView(synonyms);
		
		tabAnonym = new JPanel();
		tabAnonym.setBackground(new Color(240, 230, 140));
		tabbedPane_1.addTab("Atonym", null, tabAnonym, null);
		tabbedPane_1.setBackgroundAt(2, Color.WHITE);
		tabAnonym.setLayout(null);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBackground(Color.WHITE);
		scrollPane_4.setBorder(null);
		scrollPane_4.setBounds(0, 0, 604, 611);
		tabAnonym.add(scrollPane_4);
		
		antonyms = new JTextArea();
		antonyms.setBackground(new Color(250, 235, 215));
		antonyms.setFont(new Font("Monospaced", Font.PLAIN, 15));
		antonyms.setEditable(false);
		antonyms.setLineWrap(true);
		antonyms.setWrapStyleWord(true);
		scrollPane_4.setViewportView(antonyms);
		
		backgroundSearch = new JLabel("");
		backgroundSearch.setIcon(new ImageIcon(".\\Background\\DarkTheme\\Pink.jpg"));
		backgroundSearch.setBounds(0, 0, 1121, 712);
		add(backgroundSearch);
		
		
		lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(".\\Background\\DarkTheme\\Pink.jpg"));
		lblNewLabel_3.setBounds(-20, 0, 699, 714);
		
		tabbedPane_1.setBackgroundAt(0, Color.ORANGE);
		tabbedPane_1.setBackgroundAt(1, Color.ORANGE);
		tabbedPane_1.setBackgroundAt(2, Color.ORANGE);
		
	}

}
