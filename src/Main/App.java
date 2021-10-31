package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSlider;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JSplitPane;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet.ColorAttribute;
import javax.xml.stream.events.StartDocument;

import com.mysql.cj.api.jdbc.Statement;
import com.mysql.cj.x.protobuf.MysqlxNotice.Frame;

import DectectedLanguageLib.DetectLanguage;
import MyLib.Languages;
import MyLib.TextToSpeech;
import MyLib.Translator;

import java.awt.Color;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import java.awt.List;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.JList;
import java.awt.Button;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.ScrollPaneConstants;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Scrollbar;
import java.awt.ScrollPane;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

import java.awt.Choice;
import javax.swing.DefaultComboBoxModel;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.event.InputMethodListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.InputMethodEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.synth.ColorType;
import javax.swing.event.ChangeEvent;
import java.awt.Toolkit;

public class App {

	private JFrame frmDictionary;
	private JPanel tabTranslate;
	private JPanel tabSearch;
	private JTabbedPane tabbedPane;
	private JTextField searchTranslate;
	private JPanel panel;
	private JPanel panel_1;
	private JTabbedPane tabbedPane_1;
	private JPanel tabSynonym;
	private JPanel tabAnonym;
	private JLabel lblNewLabel;
	private JButton swapLanguage;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JScrollPane scrollPane_1;
	private JTextArea readTranslate;
	private JScrollPane scrollPane_2;
	private JTextArea writeTranslate;
	private JButton speakTranslate1;
	private JButton speakTranslate2;
	private JTable suggestionTable;
	private JComboBox<String> list_Language1;
	private JComboBox<String> list_Language2;
	private JComboBox listVoice2;
	private JComboBox<String> listVoice1;
	private JTextArea synonyms;
	private JTextArea antonyms;
	private JTextArea informations;
	private JButton speakSearch;
	private JComboBox englishSearchVoices;
	private JScrollPane scrollPane_3;
	private JPanel tabInformation;
	private boolean mute1 = false;
	private boolean mute2 = false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frmDictionary.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws FileNotFoundException 
	 */
	public App() throws FileNotFoundException {
		// Set API Key
		MyLib.API.setAPI();
		
		initialize();
		//AutoCompleteDecorator.decorate(comboBox);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDictionary = new JFrame();
		frmDictionary.setResizable(false);
		frmDictionary.setTitle("Dictionary");
		frmDictionary.setIconImage(Toolkit.getDefaultToolkit().getImage(".\\Icon\\Dictionary2.png"));
		frmDictionary.setBackground(Color.PINK);
		frmDictionary.getContentPane().setBackground(Color.PINK);
		frmDictionary.setBounds(100, 100, 1120, 768);
		frmDictionary.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDictionary.getContentPane().setLayout(null);
		
		
		UIManager.put("TabbedPane.selected", Color.YELLOW);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(new Color(0, 0, 0));
		tabbedPane.setBackground(new Color(255, 255, 255));
		tabbedPane.setFocusable(false);
		tabbedPane.setBorder(null);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tabbedPane.setBounds(0, 0, 1109, 733);
		frmDictionary.getContentPane().add(tabbedPane);
	
		 
		tabSearch = new JPanel();
		tabSearch.setBackground(new Color(255, 69, 0));
		tabSearch.setSize(new Dimension(1000, 1000));
		tabSearch.setPreferredSize(new Dimension(1000, 1000));
		tabSearch.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		tabSearch.setMinimumSize(new Dimension(100, 100));
		tabbedPane.addTab("Search", null, tabSearch, null);
		tabbedPane.setBackgroundAt(0, UIManager.getColor("CheckBox.highlight"));
		tabSearch.setLayout(null);
		

		
		lblNewLabel = new JLabel("Search Word");
		lblNewLabel.setBounds(10, 16, 193, 21);
		tabSearch.add(lblNewLabel);
		
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
						setInfomation(searchTranslate.getText());
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
		tabSearch.add(suggestionTable);
		
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
						speak(searchTranslate.getText(),(String) englishSearchVoices.getSelectedItem(),(int) speedSearch.getValue(), speakSearch);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}});
		speakSearch.setBounds(262, 39, 41, 44);
		tabSearch.add(speakSearch);
		
		searchTranslate = new JTextField();
		searchTranslate.setBackground(new Color(255, 239, 213));
		searchTranslate.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				speakSearch.setVisible(false);
				englishSearchVoices.setVisible(false);
				speedSearch.setVisible(false);
				String text = searchTranslate.getText();
				autoSuggestion(searchTranslate.getText().trim());
			}
		});
		searchTranslate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		searchTranslate.setBounds(10, 39, 253, 44);
		tabSearch.add(searchTranslate);
		searchTranslate.setColumns(10);
		
		englishSearchVoices = new JComboBox();
		englishSearchVoices.setVisible(false);
		englishSearchVoices.setFocusable(false);
		englishSearchVoices.setBorder(new EmptyBorder(0, 0, 0, 0));
		englishSearchVoices.setBackground(new Color(176, 224, 230));
		englishSearchVoices.setFont(new Font("Tahoma", Font.PLAIN, 20));
		englishSearchVoices.setModel(new DefaultComboBoxModel(new String[] {"Linda", "Amy", "Mary", "John", "Mike"}));
		englishSearchVoices.setBounds(307, 39, 72, 44);
		tabSearch.add(englishSearchVoices);
		
		speedSearch = new JSpinner();
		speedSearch.setVisible(false);
		speedSearch.setBorder(new EmptyBorder(1, 0, 1, 0));
		speedSearch.setModel(new SpinnerNumberModel(0, -4, 4, 1));
		speedSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		speedSearch.setBounds(380, 39, 55, 44);
		JFormattedTextField typeMode = ((JSpinner.DefaultEditor) speedSearch.getEditor ()). getTextField ();
		typeMode.setBackground(Color.WHITE);
		typeMode.setEditable(false);
		tabSearch.add(speedSearch);
		
		
		
		tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tabbedPane_1.setBounds(471, 16, 609, 650);
		tabSearch.add(tabbedPane_1);
		
		
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
		tabSearch.add(backgroundSearch);
		
		
		lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(".\\Background\\DarkTheme\\Pink.jpg"));
		lblNewLabel_3.setBounds(-20, 0, 699, 714);
		
		tabTranslate = new JPanel();
		tabTranslate.setBorder(null);
		tabTranslate.setBackground(Color.GRAY);
		tabTranslate.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		tabTranslate.setAlignmentX(Component.RIGHT_ALIGNMENT);
		tabbedPane.addTab("Translate", null, tabTranslate, null);
		tabTranslate.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 83, 496, 453);
		tabTranslate.add(panel_2);
		panel_2.setLayout(null);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 496, 398);
		panel_2.add(scrollPane_1);
		
		readTranslate = new JTextArea();
		readTranslate.setBackground(new Color(255, 245, 238));
		readTranslate.setFont(new Font("Monospaced", Font.PLAIN, 15));
		readTranslate.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				detectLanguage.setVisible(false);
				findLanguage();
			}
		});
		readTranslate.setLineWrap(true);
		readTranslate.setWrapStyleWord(true);
		scrollPane_1.setViewportView(readTranslate);
		
		speakTranslate1 = new JButton("");
		speakTranslate1.setBorder(null);
		speakTranslate1.setBackground(Color.WHITE);
		speakTranslate1.setIcon(new ImageIcon(".\\Icon\\volume32pixels.png"));
		speakTranslate1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mute2) {
					MyLib.TextToSpeech.closePlayer();
					mute2 = false;
					speakTranslate2.setIcon(new ImageIcon(".\\Icon\\volume32pixels.png"));
					speakTranslate2.setEnabled(true);
					}
				
				if (mute1) {
					MyLib.TextToSpeech.closePlayer();
					mute1 = false;
					speakTranslate1.setIcon(new ImageIcon(".\\Icon\\volume32pixels.png"));
					return;
				}
				try {
					String language = MyLib.Languages.allLanguageSupported.get((String) list_Language1.getSelectedItem());
					
					MyLib.TextToSpeech.dowloadVoiceText(readTranslate.getText(),language, (String) listVoice1.getSelectedItem() , (int) speed1.getValue());
					mute1 = true;
					speak(MyLib.TextToSpeech.buildPathKey(readTranslate.getText()), (String) listVoice1.getSelectedItem(), (int) speed1.getValue(), speakTranslate1);		
					speakTranslate1.setIcon(new ImageIcon(".\\Icon\\mute.png"));
					//)
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		speakTranslate1.setBounds(10, 408, 65, 41);
		panel_2.add(speakTranslate1);
		
		listVoice1 = new JComboBox<>();
		listVoice1.setBackground(Color.WHITE);
		listVoice1.setBounds(85, 423, 130, 26);
		panel_2.add(listVoice1);
		
		speed1 = new JSpinner();
		speed1.setModel(new SpinnerNumberModel(0, -4, 4, 1));
		speed1.setBounds(225, 423, 36, 26);
		JFormattedTextField typeMode1 = ((JSpinner.DefaultEditor) speed1.getEditor ()). getTextField ();
		typeMode1.setBackground(Color.WHITE);
		typeMode1.setEditable(false);
		panel_2.add(speed1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(533, 83, 551, 453);
		tabTranslate.add(panel_3);
		panel_3.setLayout(null);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 0, 551, 396);
		panel_3.add(scrollPane_2);
		
		writeTranslate = new JTextArea();
		writeTranslate.setBackground(new Color(255, 250, 205));
		writeTranslate.setFont(new Font("Monospaced", Font.PLAIN, 15));
		writeTranslate.setEditable(false);
		writeTranslate.setLineWrap(true);
		writeTranslate.setWrapStyleWord(true);
		scrollPane_2.setViewportView(writeTranslate);
		
		speakTranslate2 = new JButton("");
		speakTranslate2.setIcon(new ImageIcon(".\\Icon\\volume32pixels.png"));
		speakTranslate2.setBorder(null);
		speakTranslate2.setBackground(Color.WHITE);
		speakTranslate2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (mute1) {
					MyLib.TextToSpeech.closePlayer();
					mute1 = false;
					speakTranslate1.setIcon(new ImageIcon(".\\Icon\\volume32pixels.png"));
					speakTranslate1.setEnabled(true);
					}
				if (mute2) {
					MyLib.TextToSpeech.closePlayer();
					mute2 = false;
					speakTranslate2.setIcon(new ImageIcon(".\\Icon\\volume32pixels.png"));
					return;
				}
				try {
					String language = MyLib.Languages.allLanguageSupported.get((String) list_Language2.getSelectedItem());
					
					MyLib.TextToSpeech.dowloadVoiceText(writeTranslate.getText(),language, (String) listVoice2.getSelectedItem() , (int) speed2.getValue());
					speak(MyLib.TextToSpeech.buildPathKey(writeTranslate.getText()), (String) listVoice2.getSelectedItem(), (int) speed2.getValue(), speakTranslate2);
					mute2 = true;
					speakTranslate2.setIcon(new ImageIcon(".\\Icon\\mute.png"));
					//)
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		speakTranslate2.setBounds(22, 406, 57, 38);
		panel_3.add(speakTranslate2);
		
		listVoice2 = new JComboBox();
		listVoice2.setBackground(Color.WHITE);
		listVoice2.setBounds(105, 418, 130, 26);
		panel_3.add(listVoice2);
		
		speed2 = new JSpinner();
		speed2.setModel(new SpinnerNumberModel(0, -4, 4, 1));
		speed2.setBounds(245, 418, 30, 26);
		JFormattedTextField typeMode3 = ((JSpinner.DefaultEditor) speed2.getEditor ()). getTextField ();
		typeMode3.setBackground(Color.WHITE);
		typeMode3.setEditable(false);
		panel_3.add(speed2);
		
		swapLanguage = new JButton("");
		swapLanguage.setIcon(new ImageIcon(".\\Icon\\swap.png"));
		swapLanguage.setBorder(null);
		swapLanguage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index1 = list_Language1.getSelectedIndex();
				int index2 = list_Language2.getSelectedIndex();
				list_Language1.setSelectedIndex(index2);
				list_Language2.setSelectedIndex(index1);
				String text1 = writeTranslate.getText();
				writeTranslate.setText(readTranslate.getText());
				readTranslate.setText(text1);
			}
		});
		swapLanguage.setBackground(new Color(255, 228, 225));
		swapLanguage.setFont(new Font("Tahoma", Font.PLAIN, 27));
		swapLanguage.setBounds(506, 38, 25, 35);
		tabTranslate.add(swapLanguage);
		
		list_Language1 = new JComboBox<>();
		list_Language1.setBackground(Color.PINK);
		list_Language1.setAutoscrolls(true);
		list_Language1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Boolean isSupported = Languages.isSupportVoiceInVietnamese((String)list_Language1.getSelectedItem());
				if(!isSupported) {
					listVoice1.setEnabled(false);
					speakTranslate1.setEnabled(false);
					speed1.setEnabled(false);
					return;				
				} else {
					listVoice1.removeAllItems();
					listVoice1.setEnabled(true);
					speakTranslate1.setEnabled(true);
					String languageCurrent = (String)list_Language1.getSelectedItem();
					String codeLanguageCurrentString = Languages.getCodeOfLanguageInVietnamese(languageCurrent);
					String[] voices = Languages.listVoicesOf(Languages.languageOf(codeLanguageCurrentString));
					for (int i =0; i<voices.length ; i++) {
						listVoice1.addItem(voices[i]);
					}
				}
				
			}
			
		});
		Languages.loadLanguages();
		ArrayList<String> languages = Languages.listLanguageInVietnamese();
		for (String string : languages) {
			list_Language1.addItem(string);
		}
		list_Language1.setBounds(10, 35, 172, 38);
		tabTranslate.add(list_Language1);
		
		list_Language2 = new JComboBox<String>();
		list_Language2.setBackground(Color.PINK);
		list_Language2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Boolean isSupported = Languages.isSupportVoiceInVietnamese((String)list_Language2.getSelectedItem());
				if(!isSupported) {
					listVoice2.setEnabled(false);
					speakTranslate2.setEnabled(false);
					speed2.setEnabled(false);
					return;				
				} else {
					listVoice2.removeAllItems();
					listVoice2.setEnabled(true);
					speakTranslate2.setEnabled(true);
					String languageCurrent = (String)list_Language2.getSelectedItem();
					String codeLanguageCurrentString = Languages.getCodeOfLanguageInVietnamese(languageCurrent);
					String[] voices = Languages.listVoicesOf(Languages.languageOf(codeLanguageCurrentString));
					for (int i =0; i<voices.length ; i++) {
						listVoice2.addItem(voices[i]);
					}
				}
			}
		});
		for (String string : languages) {
			list_Language2.addItem(string);
		}
		list_Language2.setBounds(912, 35, 172, 38);
		tabTranslate.add(list_Language2);
		
		translateButton = new JButton("");
		translateButton.setBackground(new Color(211, 211, 211));
		translateButton.setIcon(new ImageIcon(".\\Icon\\preview.png"));
		translateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				translate();
			}
		});
		translateButton.setBounds(506, 83, 25, 397);
		tabTranslate.add(translateButton);
		
		detectLanguage = new JButton("");
		detectLanguage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = MyLib.Languages.list.indexOf(languageFinded);
				list_Language1.setSelectedIndex(index);
				detectLanguage.setVisible(false);
				translate();
			}
		});
		detectLanguage.setVisible(false);
		detectLanguage.setBackground(Color.PINK);
		detectLanguage.setBounds(223, 38, 231, 35);
		tabTranslate.add(detectLanguage);
		
		backGroundTranslate = new JLabel("");
		backGroundTranslate.setIcon(new ImageIcon(".\\Background\\DarkTheme\\Pink.jpg"));
		backGroundTranslate.setBounds(0, -32, 1104, 731);
		tabTranslate.add(backGroundTranslate);
		
		//Set listLanguage1
		String languageCurrent = (String)list_Language1.getSelectedItem();
		String codeLanguageCurrentString = Languages.getCodeOfLanguageInVietnamese(languageCurrent);
		String[] voices = Languages.listVoicesOf(Languages.languageOf(codeLanguageCurrentString));
		for (int i =0; i<voices.length ; i++) {
			listVoice1.addItem(voices[i]);
		}
		//Set listLanguage2
		for (int i =0; i<voices.length ; i++) {
			listVoice2.addItem(voices[i]);
		}
		
		setColorForTab();
		
//		tabbedPane.setForeground(Color.RED);
	}
	private void setColorForTab() {
		tabbedPane.setBackground(Color.ORANGE);
		
		tabbedPane_1.setBackgroundAt(0, Color.ORANGE);
		tabbedPane_1.setBackgroundAt(1, Color.ORANGE);
		tabbedPane_1.setBackgroundAt(2, Color.ORANGE);
	}
	public void setInfomation(String word) {
		Connection conn = null;
		java.sql.Statement statement = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/dataenglish", "root", "");
			String sql = "select * from data where word = '" + word +"';";
			statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				speakSearch.setEnabled(true);
				String info = resultSet.getString("information");
				String spell = resultSet.getString("spell");
				String antonym = resultSet.getString("antonyms");
				String synonym = resultSet.getString("synonyms");
				informations.setText(spell +"\n" +info);
				synonyms.setText(synonym.replace(",", ", "));
				antonyms.setText("");
				if (antonym.indexOf(word) != 0) {
					antonyms.setText(antonym);
				}			
			}
			
		} catch (Exception e1) {
			
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
			}
		}
	}
	public void autoSuggestion(String word) {
		Connection conn = null;
		java.sql.Statement statement = null;
		DefaultTableModel tblModel = (DefaultTableModel) suggestionTable.getModel();
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/dataenglish", "root", "");
			String sql = "select word from data where word like'" + word +"%' limit 10;";
			statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			tblModel.setRowCount(0); // delete
			while (resultSet.next()) {
				String wordSuggestion = resultSet.getString("word");
				tblModel.addRow(new Object[] {wordSuggestion});
			}
			int x = suggestionTable.getRowCount();
			if (x == 1) {
				setInfomation(word);
				speakSearch.setVisible(true);
				englishSearchVoices.setVisible(true);
				speedSearch.setVisible(true);
//				panel_1.setVisible(true);
			}
		} catch (Exception e) {
			
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	Thread showSpeaker = null;
	private JSpinner speedSearch;
	private JButton translateButton;
	private JSpinner speed1;
	private JSpinner speed2;
	private void speak(String keyPath, String voiceName, int speed, JButton speaker) {
		speaker.setEnabled(false);
		if (showSpeaker != null ) {
			if(showSpeaker.isAlive()) {
				showSpeaker.stop();
			}
		}
		showSpeaker = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					if (fileIsExist(keyPath, voiceName, speed)) {
						break;
					}
				}
				speaker.setEnabled(true);
				try {
					speaker.setIcon(new ImageIcon(".\\Icon\\mute.png"));
					MyLib.TextToSpeech.playerIsPlaying = true; 
					TextToSpeech.speech(voiceName, speed, keyPath);
					while (true) {
						if (!MyLib.TextToSpeech.playerIsPlaying) {
							break;
						}
						System.out.print("");

					}
					if (speaker == speakTranslate1) mute1 = false;
					if (speaker == speakTranslate2) mute2 = false;
					speaker.setEnabled(true);
					speaker.setIcon(new ImageIcon(".\\Icon\\volume32pixels.png"));			
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		showSpeaker.start();
	}
	
	private boolean fileIsExist(String keyPath, String voice, int speed) {
		File file = new File(".//MP3//"+keyPath+voice+speed+".mp3");
		return file.exists();
	}
	
	private Thread findLanguage = null;
	private String languageFinded = ""; 
	private JButton detectLanguage;
	private JLabel backGroundTranslate;
	private JLabel lblNewLabel_3;
	private JLabel backgroundSearch;
	private void findLanguage() {
		if (findLanguage != null) {
			if (findLanguage.isAlive()) {
				findLanguage.stop();
			}
		}
		findLanguage = new Thread(new Runnable() {
			@Override
			public void run() {
				String text = readTranslate.getText().trim();
				if (text.length() < 1) return;
				languageFinded = MyLib.DetectLanguage.findLanguage(text);
				languageFinded = Languages.languageInVietnamese(languageFinded);
				if (!list_Language1.getSelectedItem().equals(languageFinded)) {
					detectLanguage.setText("Phát hiện: " + languageFinded);
					detectLanguage.setVisible(true);
				}
				
			}
		});
		findLanguage.start();
	}
	private void translate() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				String fromLanguage = Languages.allLanguageSupported.get((String)list_Language1.getSelectedItem());
				String toLanguage = Languages.allLanguageSupported.get((String)list_Language2.getSelectedItem());
				String translatedText = null;
				String text = ((String) readTranslate.getText()).replace('"', ' ').trim();
				try {
					translatedText = Translator.translate(fromLanguage, toLanguage, text);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				writeTranslate.setText(translatedText);
			}
		}).start();
	}
}
