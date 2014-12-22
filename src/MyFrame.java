import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class MyFrame extends JFrame {
	
	
	private ArrayList<Pattern> allPatterns = new ArrayList<Pattern>();
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFrame mf = new MyFrame();
					mf.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ArrayList<Pattern> getAllPatterns() {
		return allPatterns;
	}

	public void setAllBusinessRules(ArrayList<Pattern> allPatterns) {
		this.allPatterns = allPatterns;
	}

	public MyFrame() {
	    
		setTitle("Pattern Application");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));		
		setContentPane(contentPane);
		
	}

	public MyFrame(ArrayList<Pattern> allPatterns2) {
		// TODO Auto-generated constructor stub
	}

	public void addPattern(Pattern p) {
		allPatterns.add(p);
		
	}
}
