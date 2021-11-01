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
import com.mysql.cj.jdbc.PreparedStatement;
import com.mysql.cj.x.protobuf.MysqlxCrud.Insert;
import com.mysql.cj.x.protobuf.MysqlxCrud.Update;
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
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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
import javax.swing.JScrollBar;

public class App {

	private JFrame frmDictionary;
	private JPanel tabTranslate;
	private JPanel tabSearch;
	private JPanel TabEdit;
	private JTabbedPane tabbedPane;
	
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
		tabbedPane.setBackground(Color.ORANGE);
		frmDictionary.getContentPane().add(tabbedPane);
	
		 // Add tabSearch
		tabSearch = new TabSearch();
		tabbedPane.addTab("Search", null, tabSearch, null);
		tabbedPane.setBackgroundAt(0, UIManager.getColor("CheckBox.highlight"));
		
		// Add tabTranslate
		tabTranslate = new TabTranslate();
		tabbedPane.addTab("Translate", null, tabTranslate, null);

		// Add tabEdit
		TabEdit = new tabEdit();
		tabbedPane.addTab("    Edit     ", null, TabEdit, null);
		
		
	
	}
	
}
