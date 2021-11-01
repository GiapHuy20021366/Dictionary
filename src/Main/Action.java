package Main;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import com.mysql.cj.api.jdbc.Statement;
import MyLib.Languages;
import MyLib.TextToSpeech;
import MyLib.Translator;

public class Action {
	static Thread showSpeaker = null;
	static void speak(String keyPath, String voiceName, int speed, JButton speaker) {
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
					if (speaker == TabSearch.speakTranslate1) TabSearch.mute1 = false;
					if (speaker == TabSearch.speakTranslate2) TabSearch.mute2 = false;
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
	
	static boolean fileIsExist(String keyPath, String voice, int speed) {
		File file = new File(".//MP3//"+keyPath+voice+speed+".mp3");
		return file.exists();
	}
	
	// Set information, synonym, antonym, spell with data from DATABASE
	static void setInfomation(String word, JTextArea informations_, JTextArea synonyms_, JTextArea antonyms_, JTextField spell_) {
		Connection conn = null;
		java.sql.Statement statement = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/dataenglish", "root", "");
			String sql = "select * from data where word = '" + word +"';";
			statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				TabSearch.speakSearch.setEnabled(true);
				String info = resultSet.getString("information");
				String spell = resultSet.getString("spell");
				String antonym = resultSet.getString("antonyms");
				String synonym = resultSet.getString("synonyms");
				antonyms_.setText("");
				if (spell_ != null) {
					spell_.setText(spell);
					informations_.setText(info);
					synonyms_.setText(synonym);				
				} else {
					informations_.setText(spell +"\n" +info);
					synonyms_.setText(synonym.replace(",", ", "));
				}
				if (antonym.indexOf(word) != 0) {
					antonyms_.setText(antonym);
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
	
	// Auto Suggestion with word and data from DATABASE
	static void autoSuggestion(String word) {
		Connection conn = null;
		java.sql.Statement statement = null;
		DefaultTableModel tblModel = (DefaultTableModel) TabSearch.suggestionTable.getModel();
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
			int x = TabSearch.suggestionTable.getRowCount();
			if (x == 1) {
				setInfomation(word, TabSearch.informations, TabSearch.synonyms, TabSearch.antonyms, null);
				TabSearch.speakSearch.setVisible(true);
				TabSearch.englishSearchVoices.setVisible(true);
				TabSearch.speedSearch.setVisible(true);
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
	static Thread findLanguage = null;
	static String languageFinded = ""; 
	static void findLanguage() {
		if (findLanguage != null) {
			if (findLanguage.isAlive()) {
				findLanguage.stop();
			}
		}
		findLanguage = new Thread(new Runnable() {
			@Override
			public void run() {
				String text = TabTranslate.readTranslate.getText().trim();
				if (text.length() < 1) return;
				languageFinded = MyLib.DetectLanguage.findLanguage(text);
				languageFinded = Languages.languageInVietnamese(languageFinded);
				if (!TabTranslate.list_Language1.getSelectedItem().equals(languageFinded)) {
					TabTranslate.detectLanguage.setText("Phát hiện: " + languageFinded);
					TabTranslate.detectLanguage.setVisible(true);
				}
				
			}
		});
		findLanguage.start();
	}
	
	// Use API Google to translate, go to MyLib.Translator
	static void translate() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				String fromLanguage = Languages.allLanguageSupported.get((String)TabTranslate.list_Language1.getSelectedItem());
				String toLanguage = Languages.allLanguageSupported.get((String)TabTranslate.list_Language2.getSelectedItem());
				String translatedText = null;
				String text = ((String) TabTranslate.readTranslate.getText()).replace('"', ' ').trim();
				try {
					translatedText = Translator.translate(fromLanguage, toLanguage, text);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				TabTranslate.writeTranslate.setText(translatedText);
			}
		}).start();
	}
	
	/////////////////////////////////////////////////////////////////////////////////////USE FOR TAB EDIT/////////////////////////////////////////////////////////////////////////
	
	// Check word has exist on database or not
	static boolean wordHasInDatabase(String word) {
		Connection conn = null;
		java.sql.Statement statement = null;
		boolean hasExist = false;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/dataenglish", "root", "");
			String sql = "select word from data where word like'" + word +"' limit 1;";
			statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				hasExist = true;
				break;
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
			return hasExist;
		}
		
	}
	
	// Fix word
	 static void fixWord(String word) {
		String information = tabEdit.editInformation.getText();
		String synonym = tabEdit.editSynonym.getText();
		String antonym = tabEdit.editAntonym.getText();
		String spell = tabEdit.editSpell.getText();
		String sql1 = "UPDATE data SET informations ='"+information+"' WHERE word = '"+word+"'";
		String sql2 = "UPDATE data SET spell ='"+spell+"' WHERE word = '"+word+"'";
		String sql3 = "UPDATE data SET synonyms ='"+synonym+"' WHERE word = '"+word+"'";
		String sql4 = "UPDATE data SET antonyms ='"+antonym+"' WHERE word = '"+word+"'";
		excuteQueryUpdate(sql1);
		excuteQueryUpdate(sql2);
		excuteQueryUpdate(sql3);
		excuteQueryUpdate(sql4);
		synonym.replace(" ", "");
		String sql =  "INSERT INTO historyedit VALUES('" + getTime()+"','"+word +"','UPDATE');";
        excuteQueryUpdate(sql);
        
		
	}
	 
	 // Excute Query Statement for UPDATE, DELETE, INSERT
	 static void excuteQueryUpdate(String sql) {
		Connection conn = null;
		Statement statement = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/dataenglish", "root", "");
			statement = (Statement)conn.createStatement();
			int updateCount = statement.executeUpdate(sql);
		
		} catch (SQLException e) {
			
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
	 
	 // Remove word on DATABASE
	 static void removeWord(String word) {
		String sql =  "Delete FROM data where word like'" + word + "'";
		excuteQueryUpdate(sql);
		tabEdit.fixWord.setVisible(false);
		tabEdit.removeWord.setVisible(false);
		tabEdit.insertWord.setVisible(true);
		String sql1 =  "INSERT INTO historyedit VALUES('" + getTime()+"','"+word +"','REMOVE');";
        excuteQueryUpdate(sql1);
	}
	
	 // Insert word into DATABASE
	 static void insertWord() {
		String word = tabEdit.inputWord.getText().trim();
		String spell = tabEdit.editSpell.getText();
		String information = tabEdit.editInformation.getText();
		String synonym = tabEdit.editSynonym.getText();
		String antonym = tabEdit.editAntonym.getText();
		String sql ="INSERT INTO data VALUES('"+word+"','"+spell+"','"+information+"','"+synonym+"','" +antonym +"');";
		excuteQueryUpdate(sql);
		tabEdit.fixWord.setVisible(true);
		tabEdit.removeWord.setVisible(true);
		tabEdit.insertWord.setVisible(false);
		
		//History of word - INSERT WORD
		String sql1 =  "INSERT INTO historyedit VALUES('" + getTime()+"','"+word +"','INSERT');";
		excuteQueryUpdate(sql1);
	}
	 
	 // Get Time NOW
	 static String getTime() {
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String datetime = sdf3.format(timestamp);
		return datetime;
	}
	
	 // Show History Edit
	 static void showHistoryEdit() {
			Connection conn = null;
			java.sql.Statement statement = null;
			DefaultTableModel model = (DefaultTableModel) tabEdit.historyEdit.getModel();
			try {
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/dataenglish", "root", "");
				String sql = "SELECT Word, Date,  Status FROM historyedit ORDER BY Date DESC LIMIT 10" ;
				statement = conn.createStatement();
				ResultSet resultSet = statement.executeQuery(sql);
				model.setRowCount(0); // delete
				while (resultSet.next()) {
					
					String date = resultSet.getString("Date");
					String word = resultSet.getString("Word");
					String status = resultSet.getString("Status");
					model.addRow(new Object[] {date, word, status});
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
	
}
