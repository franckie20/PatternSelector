import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Main {

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

		BufferedImage img = null;

		try {
			img = ImageIO.read(new URL("http://www.dofactory.com/images/diagrams/net/factory.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		Purpose ps1 = new Purpose("Creational");
		//Purpose ps2 = new Purpose("Structural");
		//Purpose ps3 = new Purpose("Behavorial");
		
		Scope s1 = new Scope("Class");
		//Scope s2 = new Scope("Object");
		
		Pattern p1 = new Pattern("Factory Method", "test2", "test3", "test4", "test5", img);
		Pattern p2 = new Pattern("Adapter (Class)", "test2", "test3", "test4", "test5", img);
		Pattern p3 = new Pattern("Interpreter", "test2", "test3", "test4", "test5", img);
		Pattern p4 = new Pattern("Template Method", "test2", "test3", "test4", "test5", img);
		
		p1.setPurpose(ps1);
		p2.setPurpose(ps1);
		p3.setPurpose(ps1);
		p4.setPurpose(ps1);
		
		p1.setScope(s1);
		p2.setScope(s1);
		p3.setScope(s1);
		p4.setScope(s1);

		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		System.out.println(p4);

	}
}
