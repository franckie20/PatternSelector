import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private SoftwarePatterns control;
	private JButton selector, editor;

	public MainFrame(SoftwarePatterns sc) {
		super("Pattern Application");
		control = sc;
		createGUI();
	}

	public void createGUI() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);

		FlowLayout layout = new FlowLayout();

		// logo
		Image image = null;
		try {
			URL url = new URL("http://www.franckie20.com/images/logo.png");
			image = ImageIO.read(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(layout);
		setContentPane(contentPane);

		selector = new JButton("Selector");
		selector.addActionListener(selectorAction);
		contentPane.add(selector);

		editor = new JButton("Editor");
		editor.addActionListener(editorAction);
		contentPane.add(editor);

		setSize(460, 300);
		setTitle("Main Frame");
		setLocationRelativeTo(null);

		JLabel label = new JLabel(new ImageIcon(image));
		getContentPane().add(label);
		setVisible(true);
	}

	ActionListener selectorAction = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			SelectorFrame sf;
			try {
				sf = new SelectorFrame(control);
				sf.setVisible(true);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}

	};

	ActionListener editorAction = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			EditorFrame ef;
			try {
				ef = new EditorFrame(control);
				ef.setVisible(true);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}

	};

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
