import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private JLabel picture, l1, l2, l3, l4, l5, l6, l8;
	private SelectorController control;
	@SuppressWarnings({ "rawtypes", "unused" })
	private JComboBox box1, box2, box3, box4, box5, box6;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public SelectorFrame(SelectorController sc) {
		super("Pattern Application");
		control = sc;

		Font f = new Font("SansSerif", Font.BOLD, 12);
		JPanel firstPanel = new JPanel();
		firstPanel.setBorder(new TitledBorder("Pattern Selector"));
		firstPanel.setLayout(new GridLayout(5, 1, 1, 1));

		l1 = new JLabel("Context: ");
		l1.setFont(f);
		firstPanel.add(l1);
		box1 = new JComboBox(control.getAllPatternContexts());

		firstPanel.add(box1);
		box1.addActionListener(contextAction);
		l2 = new JLabel("Problem: ");
		l2.setFont(f);
		firstPanel.add(l2);
		box2 = new JComboBox();
		firstPanel.add(box2);
		box2.addActionListener(this);
		l3 = new JLabel("Solution: ");
		l3.setFont(f);
		firstPanel.add(l3);
		box3 = new JComboBox();
		firstPanel.add(box3);
		box3.addActionListener(this);
		l4 = new JLabel("Consequence: ");
		l4.setFont(f);
		firstPanel.add(l4);
		box4 = new JComboBox();
		firstPanel.add(box4);
		box4.addActionListener(this);
		l8 = new JLabel("Pattern: ");
		l8.setFont(f);
		firstPanel.add(l8);
		l6 = new JLabel("Selected Pattern");
		l6.setFont(f);
		firstPanel.add(l6);

		JPanel content = new JPanel(new BorderLayout());
		content.setBorder(new EmptyBorder(10, 10, 10, 10));
		content.add(firstPanel, BorderLayout.NORTH);
		add(content, BorderLayout.CENTER);

		setSize(560, 360);
		setTitle("Pattern Selector");
		setLocationRelativeTo(null);

		onSelectedItemChanged();
	}

	// String[] listPatterns = control.getAllPatternsByName();
	// JComboBox<String> patternList = new JComboBox<String>(listPatterns);

	// patternList.setSelectedIndex(1);
	// patternList.addActionListener(contextAction);
	// pn.add(patternList);

	// CONTEXT OPHALEN???
	private void onSelectedItemChanged() {
		Object context = box1.getSelectedItem();
		if (control.getAllPatterns().contains(context)) {
			System.out.println("Test");
		} else {

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

// Set up the picture.
/*
 * picture = new JLabel();
 * picture.setFont(picture.getFont().deriveFont(Font.ITALIC));
 * picture.setHorizontalAlignment(JLabel.CENTER);
 * updateLabel(listPatterns[patternList.getSelectedIndex()]);
 * picture.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
 * 
 * // The preferred size is hard-coded to be the width of the // widest image
 * and the height of the tallest image + the border. // A real program would
 * compute this. picture.setPreferredSize(new Dimension(315, 320 + 10));
 * 
 * add(l1, BorderLayout.BEFORE_LINE_BEGINS); //add(l2, BorderLayout.LINE_END);
 * add(patternList, BorderLayout.PAGE_START); add(picture,
 * BorderLayout.PAGE_END); picture.setBorder(BorderFactory.createEmptyBorder(20,
 * 20, 20, 20)); }
 */

/*
 * @Override public void actionPerformed(ActionEvent e) {
 * 
 * @SuppressWarnings("rawtypes") JComboBox cb = (JComboBox) e.getSource();
 * String patternName = (String)cb.getSelectedItem(); updateLabel(patternName);
 * } };
 * 
 * protected void updateLabel(String name) { ImageIcon icon =
 * createImageIcon("images/" + name.toLowerCase() + ".gif");
 * picture.setIcon(icon); picture.setToolTipText("The " + name.toLowerCase() +
 * " pattern"); if (icon != null) { picture.setText(null); } else {
 * picture.setText("Image not found"); } }
 * 
 * 
 * /** Returns an ImageIcon, or null if the path was invalid.
 */
/*
 * protected static ImageIcon createImageIcon(String path) { BufferedImage img =
 * null; try { img = ImageIO.read(new URL("http://www.franckie20.com/" + path));
 * } catch (MalformedURLException e) { e.printStackTrace(); } catch (IOException
 * e) { e.printStackTrace(); }
 * 
 * if (img != null) { return new ImageIcon(img); } else {
 * System.err.println("Couldn't find file: " + path); return null; } }
 */

