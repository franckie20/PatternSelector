import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private SelectorController control;
	private JButton selector, editor;

	public MainFrame(SelectorController sc) {
		super("Pattern Application");
		control = sc;
		createGUI();
	}

	public void createGUI() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(2, 2, 5, 5));
		setContentPane(contentPane);

		selector = new JButton("Selector");
		selector.addActionListener(selectorAction);
		contentPane.add(selector);
		
		editor = new JButton("Editor");
		editor.addActionListener(editorAction);
		contentPane.add(editor);
	}

	ActionListener selectorAction = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			SelectorFrame sf = new SelectorFrame(control);
			sf.setVisible(true);
		}

	};
	
	ActionListener editorAction = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			EditorFrame ef = new EditorFrame(control);
			ef.setVisible(true);
		}

	};

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
