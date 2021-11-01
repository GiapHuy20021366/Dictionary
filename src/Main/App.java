package Main;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Toolkit;
import java.io.FileNotFoundException;

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
		
		// Create tabbedPane to insert tabs
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
