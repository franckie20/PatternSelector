import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class EditorFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JButton addPattern, editPattern, removePattern;
	private JTextField tfNm, tfCon, tfProb, tfSol, tfCons, tfDiag;
	@SuppressWarnings("rawtypes")
	private JComboBox box1, box2;
	private JLabel picLabel;
	private SoftwarePatterns control;

	private XStream xstream = new XStream(new DomDriver());

	String xml;

	@SuppressWarnings("rawtypes")
	private JComboBox box;

	public EditorFrame(SoftwarePatterns sc) {
		super("Pattern Application");
		setControl(sc);
		createGUI();
		windowOpen();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void createGUI() {

		readPattern();

		Font f = new Font("SansSerif", Font.BOLD, 12);

		JPanel ps = new JPanel();
		addPattern = new JButton("Add pattern");
		ps.add(addPattern);
		addPattern.addActionListener(this);

		editPattern = new JButton("Save pattern");
		ps.add(editPattern);
		editPattern.addActionListener(editPatternAL);

		removePattern = new JButton("Remove pattern");
		ps.add(removePattern);
		removePattern.addActionListener(this);
		setVisible(true);

		BorderLayout bl_boxPanel = new BorderLayout();
		bl_boxPanel.setHgap(5);
		bl_boxPanel.setVgap(5);
		JPanel boxPanel = new JPanel(bl_boxPanel);
		getContentPane().add(boxPanel, BorderLayout.NORTH);

		JPanel pn = new JPanel();
		boxPanel.add(pn);
		pn.setLayout(new GridLayout(2, 2, 5, 5));

		JLabel lab2 = new JLabel("Pattern editor: ");
		lab2.setFont(f);
		pn.add(lab2);

		// combobox
		box = new JComboBox(control.getAllPatterns().toArray(new Pattern[0]));
		pn.add(box);
		box.addActionListener(this);

		BorderLayout bl_content = new BorderLayout();
		bl_content.setHgap(5);
		bl_content.setVgap(5);
		JPanel content = new JPanel(bl_content);
		content.add(ps, BorderLayout.SOUTH);
		getContentPane().add(content, BorderLayout.CENTER);

		JPanel firstPanel = new JPanel();
		content.add(firstPanel, BorderLayout.NORTH);
		firstPanel.setBorder(new TitledBorder("Pattern editor"));
		firstPanel.setLayout(new GridLayout(9, 1, 1, 5));
		firstPanel.setSize(200, 100);

		// labels & textfields
		JLabel l1 = new JLabel("Name: ");
		l1.setFont(f);
		firstPanel.add(l1);
		tfNm = new JTextField();
		tfNm.setFont(f);
		firstPanel.add(tfNm);

		JLabel l2 = new JLabel("Context: ");
		l2.setFont(f);
		firstPanel.add(l2);
		tfCon = new JTextField();
		tfCon.setFont(f);
		firstPanel.add(tfCon);

		JLabel l3 = new JLabel("Problem: ");
		l3.setFont(f);
		firstPanel.add(l3);
		tfProb = new JTextField();
		tfProb.setFont(f);
		firstPanel.add(tfProb);

		JLabel l4 = new JLabel("Solution: ");
		l4.setFont(f);
		firstPanel.add(l4);
		tfSol = new JTextField();
		tfSol.setFont(f);
		firstPanel.add(tfSol);

		JLabel l6 = new JLabel("Consequence: ");
		l6.setFont(f);
		firstPanel.add(l6);
		tfCons = new JTextField();
		tfCons.setFont(f);
		firstPanel.add(tfCons);

		JLabel l8 = new JLabel("Purpose: ");
		l8.setFont(f);
		firstPanel.add(l8);

		box2 = new JComboBox(control.getAllPurposesByName());
		firstPanel.add(box2);
		box2.setSelectedItem(0);

		JLabel l7 = new JLabel("Scope: ");
		l7.setFont(f);
		firstPanel.add(l7);

		box1 = new JComboBox(control.getAllScopesByName());
		firstPanel.add(box1);
		box1.setSelectedItem(0);

		JLabel l5 = new JLabel("Diagram (URL): ");
		l5.setFont(f);
		firstPanel.add(l5);
		tfDiag = new JTextField();
		tfDiag.setFont(f);
		firstPanel.add(tfDiag);

		content.setBorder(new EmptyBorder(10, 10, 10, 10));

		JPanel picPanel = new JPanel();
		content.add(picPanel, BorderLayout.CENTER);
		picPanel.setLayout(new BorderLayout(5, 0));
		boxPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

		picLabel = new JLabel();
		picPanel.add(picLabel);

		setSize(1020, 750);
		setTitle("Edit Pattern");
		setLocationRelativeTo(null);

	}

	public void savePattern(Pattern p, Purpose pur) {
		control.addPattern(p);
		System.out.println("save pattern XML" + " " + p + " " + pur);
		FileOutputStream fos = null;
		try {
			xml = xstream.toXML(p);
			fos = new FileOutputStream("test.xml");
			fos.write("<?xml version=\"1.0\"?>".getBytes("UTF-8"));
			byte[] bytes = xml.getBytes("UTF-8");
			fos.write(bytes);

		} catch (Exception e) {
			System.err.println("Error in XML Write: " + e.getMessage());
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public Pattern readPattern() {
		System.out.println("read person");
		Pattern p = new Pattern(xml, xml, xml, xml, xml, xml); // if there is an
																// error during
																// deserialization,
																// this is going
																// to be
																// returned, is
																// this what you
																// want?
		try {
			File xmlFile = new File("test.xml");
			p = (Pattern) xstream.fromXML(xmlFile);
			control.addPattern(p);
		} catch (Exception e) {
			System.err.println("Error in XML Read: " + e.getMessage());
		}
		return p;
	}

	private void onSelectedItemChanged() {
		Object obj = box.getSelectedItem();
		if (obj instanceof Pattern) {
			Pattern p = (Pattern) obj;
			tfNm.setText(p.getName());
			tfCon.setText(p.getContext());
			tfProb.setText(p.getProblem());
			tfSol.setText(p.getSolution());
			tfCons.setText(p.getConsequence());
			tfDiag.setText(p.getDiagram());

			// image
			Image img = null;

			try {
				URL url = new URL(p.getDiagram());
				img = ImageIO.read(url);

				ImageIcon icon = new ImageIcon(img);
				picLabel.setIcon(icon);

			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			tfNm.setText("");
			tfCon.setText("");
			tfProb.setText("");
			tfSol.setText("");
			tfCons.setText("");
			tfDiag.setText("");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == box) {
			onSelectedItemChanged();
		}

		else if (e.getSource() == removePattern) {
			Object selectedPattern = box.getSelectedItem();
			if (selectedPattern instanceof Pattern) {
				Pattern selected = (Pattern) selectedPattern;
				JOptionPane.showMessageDialog(null, "Pattern removed!",
						"Succes", JOptionPane.PLAIN_MESSAGE);
				control.removePattern(selected);
				box.repaint();
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(null,
						"Pattern couldn't be removed!", "Error",
						JOptionPane.PLAIN_MESSAGE);
			}
		}

		else if (e.getSource() == addPattern) {
			Pattern newP = null;
			Purpose purp = null;
			String nm = tfNm.getText();
			String con = tfCon.getText();
			String prob = tfProb.getText();
			String sol = tfSol.getText();
			String cons = tfCons.getText();
			String diag = tfDiag.getText();

			if (!nm.equals("") && !con.equals("") && !prob.equals("")
					&& !sol.equals("") && !cons.equals("") && !diag.equals("")) {

				newP = new Pattern(nm, con, prob, sol, cons, diag);
				purp = new Purpose("Test");
				if (control.addPattern(newP)) {
					JOptionPane.showMessageDialog(null, "Adding succesfull!",
							"Succes", JOptionPane.PLAIN_MESSAGE);
					this.dispose();
					savePattern(newP, purp);
				}

				else {
					JOptionPane.showMessageDialog(null,
							"Denied, pattern already exists!", "Error",
							JOptionPane.PLAIN_MESSAGE);
					tfNm.setText("");
					tfCon.setText("");
					tfProb.setText("");
					tfSol.setText("");
					tfCons.setText("");
					tfDiag.setText("");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Adding failed", "OK",
						JOptionPane.PLAIN_MESSAGE);
			}
		}
	}

	ActionListener editPatternAL = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			String nm = tfNm.getText();
			String con = tfCon.getText();
			String prob = tfProb.getText();
			String sol = tfSol.getText();
			String cons = tfCons.getText();
			String diag = tfDiag.getText();

			Object selectedPattern = box.getSelectedItem();
			if (selectedPattern instanceof Pattern) {
				Pattern selected = (Pattern) selectedPattern;
				if (!nm.equals("") && !con.equals("") && !prob.equals("")
						&& !sol.equals("") && !cons.equals("")
						&& !diag.equals("")) {

					selected.setName(nm);
					selected.setConsequence(con);
					selected.setProblem(prob);
					selected.setSolution(sol);
					selected.setConsequence(cons);
					selected.setDiagram(diag);
					JOptionPane.showMessageDialog(null, "Pattern saved", "OK",
							JOptionPane.PLAIN_MESSAGE);

				} else {
					JOptionPane.showMessageDialog(null, "Saving failed", "OK",
							JOptionPane.PLAIN_MESSAGE);
				}
			}
		}

	};

	public SoftwarePatterns getControl() {
		return control;
	}

	public void setControl(SoftwarePatterns control) {
		this.control = control;
	}

	public void windowOpen() {
		onSelectedItemChanged();
	}

}
