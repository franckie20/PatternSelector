import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class SelectorFrame extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JLabel picture;
	private SelectorController control;
	
	public SelectorFrame(SelectorController sc) {
		super("Pattern Application");
		control = sc;
		createGUI();
	}
	
	public void createGUI() {
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));		
		setContentPane(contentPane);
		
		String[] listPatterns = control.getAllPatternsByName();
		JComboBox<String> patternList = new JComboBox<String>(listPatterns);
		
		patternList.setSelectedIndex(1);
		patternList.addActionListener(this);
		contentPane.add(patternList);
		
		String[] listContexts = control.getAllPatternContexts();
		JComboBox<String> contextList = new JComboBox<String>(listContexts);
		
		contextList.setSelectedIndex(0);
		contextList.addActionListener(contextAction);
		contentPane.add(contextList);
		
		//Set up the picture.
        picture = new JLabel();
        picture.setFont(picture.getFont().deriveFont(Font.ITALIC));
        picture.setHorizontalAlignment(JLabel.CENTER);
        updateLabel(listPatterns[patternList.getSelectedIndex()]);
        picture.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
 
        //The preferred size is hard-coded to be the width of the
        //widest image and the height of the tallest image + the border.
        //A real program would compute this.
        picture.setPreferredSize(new Dimension(315, 320+10));
 
        //Lay out the demo.
        add(contextList, BorderLayout.PAGE_START);
        add(picture, BorderLayout.PAGE_END);
        picture.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));		
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
			@SuppressWarnings("rawtypes")
			JComboBox cb = (JComboBox)e.getSource();
			String patternContext = (String)cb.getSelectedItem();
			for(String patterns : control.getAllPatternsByName()) {
				if(patternContext.equals((String)cb.getSelectedItem())) {
					updateLabel(patterns);
				}
			}
		}
		
	};
	
	
	protected void updateLabel(String name) {
        ImageIcon icon = createImageIcon("images/" + name.toLowerCase() + ".gif");
        picture.setIcon(icon);
        picture.setToolTipText("The " + name.toLowerCase() + " pattern");
        if (icon != null) {
            picture.setText(null);
        } else {
            picture.setText("Image not found");
        }
    }
	
	/** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
    	BufferedImage img = null;
    	try {
			img = ImageIO.read(new URL("http://www.franckie20.com/" + path));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
        if (img != null) {
            return new ImageIcon(img);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
