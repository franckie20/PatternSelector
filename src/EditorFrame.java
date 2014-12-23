import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class EditorFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JButton addPattern, removePattern;
	private JTextField tfNm, tfCon, tfProb, tfSol, tfCons;
	private SelectorController control;
	private JComboBox box;

	public EditorFrame(SelectorController sc) {
		super("Pattern Application");
		setControl(sc);
		createGUI();
	}

	public void createGUI() {

		Font f = new Font("SansSerif", Font.BOLD, 12);

		JPanel pn = new JPanel();
		pn.setLayout(new GridLayout(2, 2, 2, 2));

		JLabel lab2 = new JLabel("Pattern editor: ");
		lab2.setFont(f);
		pn.add(lab2);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder("Add a Pattern"));
		panel.setLayout(new GridLayout(9, 1, 1, 1));

		// combobox
		box = new JComboBox(control.getAllPatterns().toArray(new Pattern[0]));
		pn.add(box);
		box.addActionListener(this);

		// labels & textfields
		JLabel l1 = new JLabel("Name: ");
		l1.setFont(f);
		panel.add(l1);
		tfNm = new JTextField();
		tfNm.setFont(f);
		panel.add(tfNm);

		JLabel l2 = new JLabel("Context: ");
		l2.setFont(f);
		panel.add(l2);
		tfCon = new JTextField();
		tfCon.setFont(f);
		panel.add(tfCon);

		JLabel l3 = new JLabel("Problem: ");
		l3.setFont(f);
		panel.add(l3);
		tfProb = new JTextField();
		tfProb.setFont(f);
		panel.add(tfProb);

		JLabel l4 = new JLabel("Solution: ");
		l4.setFont(f);
		panel.add(l4);
		tfSol = new JTextField();
		tfSol.setFont(f);
		panel.add(tfSol);

		JLabel l6 = new JLabel("Consequence: ");
		l6.setFont(f);
		panel.add(l6);
		tfCons = new JTextField();
		tfCons.setFont(f);
		panel.add(tfCons);

		JLabel l5 = new JLabel("Diagram: ");
		l5.setFont(f);
		panel.add(l5);

		JPanel ps = new JPanel();
		addPattern = new JButton("Add pattern");
		ps.add(addPattern);
		addPattern.addActionListener(this);

		removePattern = new JButton("Remove pattern");
		ps.add(removePattern);
		removePattern.addActionListener(this);

		JPanel content = new JPanel(new BorderLayout());
		content.setBorder(new EmptyBorder(10, 10, 10, 10));
		content.add(panel, BorderLayout.CENTER);
		content.add(pn, BorderLayout.NORTH);
		content.add(ps, BorderLayout.SOUTH);
		add(content, BorderLayout.CENTER);

		setSize(580, 350);
		setTitle("Edit Pattern");
		setLocationRelativeTo(null);

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
		} else {
			tfNm.setText("");
			tfCon.setText("");
			tfProb.setText("");
			tfSol.setText("");
			tfCons.setText("");
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
			}
		}

		else if (e.getSource() == addPattern) {
			Pattern newP = null;
			String nm = tfNm.getText();
			String con = tfCon.getText();
			String prob = tfProb.getText();
			String sol = tfSol.getText();
			String cons = tfCons.getText();

			if (!nm.equals("") && !con.equals("") && !prob.equals("")
					&& !sol.equals("") && !cons.equals("")) {

				newP = new Pattern(nm, con, prob, sol, cons, null);
				if (control.addPattern(newP)) {
					JOptionPane.showMessageDialog(null, "Adding succesfull!",
							"Succes", JOptionPane.PLAIN_MESSAGE);
					this.dispose();
				}

				else {
					JOptionPane.showMessageDialog(null,
							"Denied, pattern already exists!", "Fout",
							JOptionPane.PLAIN_MESSAGE);
					tfNm.setText("");
					tfCon.setText("");
					tfProb.setText("");
					tfSol.setText("");
					tfCons.setText("");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Toevoegen Mislukt", "OK",
						JOptionPane.PLAIN_MESSAGE);

			}
		}
	}

	public SelectorController getControl() {
		return control;
	}

	public void setControl(SelectorController control) {
		this.control = control;
	}

}