import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class SelectorFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	// private JPanel contentPanel;
	@SuppressWarnings("unused")
	private JLabel picture, l1, l2, l2Display, l3, l3Display, l4, l4Display, l5, l5Display, l6, l6Display, PatternPic;
	private SelectorController control;
	@SuppressWarnings({ "rawtypes", "unused" })
	private JComboBox box1;
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public SelectorFrame(SelectorController sc) {
		super("Pattern Application");
		control = sc;

		Font f = new Font("SansSerif", Font.BOLD, 12);
		JPanel firstPanel = new JPanel();
		firstPanel.setBorder(new TitledBorder("Pattern Selector"));
		firstPanel.setLayout(new GridLayout(10, 1, 1, 5));
		firstPanel.setSize(200, 100);

		l1 = new JLabel("Context: ");
		l1.setFont(f);
		firstPanel.add(l1);
		box1 = new JComboBox(control.getAllPatternContexts());

		firstPanel.add(box1);
		box1.addActionListener(contextAction);
		l2 = new JLabel("Problem: ");
		l2.setFont(f);
		firstPanel.add(l2);		
		l2Display = new JLabel(" ");
		l2Display.setFont(f);
		firstPanel.add(l2Display);
		
		l3 = new JLabel("Solution: ");
		l3.setFont(f);
		firstPanel.add(l3);
		l3Display = new JLabel(" ");
		l3Display.setFont(f);
		firstPanel.add(l3Display);
		
		
		l4 = new JLabel("Consequence: ");
		l4.setFont(f);
		firstPanel.add(l4);
		l4Display = new JLabel(" ");
		l4Display.setFont(f);
		firstPanel.add(l4Display);
		
		
		l6 = new JLabel("Pattern: ");
		l6.setFont(f);
		firstPanel.add(l6);
		l6Display = new JLabel(" ");
		l6Display.setFont(f);
		firstPanel.add(l6Display);
		
		PatternPic = new JLabel ("Picture:");
		PatternPic.setFont(f);
		firstPanel.add(PatternPic);
		
		
		//image 
		Image image = null;
		try {
		    URL url = new URL("http://www.online-image-editor.com//styles/2014/images/example_image.png");
		    image = ImageIO.read(url);
		} catch (IOException e) {
		}
		//***************
		
		
		JLabel label = new JLabel(new ImageIcon(image));
		getContentPane().add(label);
		setVisible(true);
		
		JPanel content = new JPanel(new BorderLayout());
		content.setBorder(new EmptyBorder(10, 10, 10, 10));
		content.add(firstPanel, BorderLayout.NORTH);
		add(content, BorderLayout.CENTER);

		setSize(760, 360);
		setTitle("Pattern Selector");
		setLocationRelativeTo(null);

		onSelectedItemChanged();
	}



	// CONTEXT OPHALEN???
	private void onSelectedItemChanged() {
		Object context = box1.getSelectedItem();
		
		for (Pattern p : control.getAllPatterns()) {
			if (p.getContext().equals(context)) {
				l2Display.setText(p.getProblem());
				l3Display.setText(p.getSolution());
				l4Display.setText(p.getConsequence());
				l6Display.setText(p.getName());
			}
		}
	}
		
	public SelectorController getSelectorController() {
		return control;
	}

	public void setControl(SelectorController sc) {
		control = sc;
	}

	ActionListener contextAction = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			onSelectedItemChanged();
		}
	};

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
