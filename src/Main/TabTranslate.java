package Main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import MyLib.Languages;

public class TabTranslate extends JPanel {
	private JButton swapLanguage;
	private JScrollPane scrollPane_1;
	public static JTextArea readTranslate;
	private JScrollPane scrollPane_2;
	static JTextArea writeTranslate;
	static JButton speakTranslate1;
	static JButton speakTranslate2;
	static JTable suggestionTable;
	static JComboBox<String> list_Language1;
	static JComboBox<String> list_Language2;
	private JComboBox listVoice2;
	private JComboBox<String> listVoice1;
	static JTextArea synonyms;
	static JTextArea antonyms;
	static JTextArea informations;
	static JButton speakSearch;
	static boolean mute1 = false;
	static boolean mute2 = false;
	Thread showSpeaker = null;
	private JButton translateButton;
	private JSpinner speed1;
	private JSpinner speed2; 
	static JButton detectLanguage;
	private JLabel backGroundTranslate;
	public TabTranslate() {
		setBorder(null);
		setBackground(Color.GRAY);
		setAlignmentY(Component.BOTTOM_ALIGNMENT);
		setAlignmentX(Component.RIGHT_ALIGNMENT);
		setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 83, 496, 453);
		add(panel_2);
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
				Action.findLanguage();
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
					Action.speak(MyLib.TextToSpeech.buildPathKey(readTranslate.getText()), (String) listVoice1.getSelectedItem(), (int) speed1.getValue(), speakTranslate1);		
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
		add(panel_3);
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
					Action.speak(MyLib.TextToSpeech.buildPathKey(writeTranslate.getText()), (String) listVoice2.getSelectedItem(), (int) speed2.getValue(), speakTranslate2);
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
		add(swapLanguage);
		
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
		add(list_Language1);
		
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
		add(list_Language2);
		
		translateButton = new JButton("");
		translateButton.setBackground(new Color(211, 211, 211));
		translateButton.setIcon(new ImageIcon(".\\Icon\\preview.png"));
		translateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Action.translate();
			}
		});
		translateButton.setBounds(506, 83, 25, 397);
		add(translateButton);
		
		detectLanguage = new JButton("");
		detectLanguage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = MyLib.Languages.list.indexOf(Action.languageFinded);
				list_Language1.setSelectedIndex(index);
				detectLanguage.setVisible(false);
				Action.translate();
			}
		});
		detectLanguage.setVisible(false);
		detectLanguage.setBackground(Color.PINK);
		detectLanguage.setBounds(223, 38, 231, 35);
		add(detectLanguage);
		
		backGroundTranslate = new JLabel("");
		backGroundTranslate.setIcon(new ImageIcon(".\\Background\\DarkTheme\\Pink.jpg"));
		backGroundTranslate.setBounds(0, -32, 1104, 731);
		add(backGroundTranslate);
		
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
				list_Language2.setSelectedIndex(76); // Vietnamese
	}

}
