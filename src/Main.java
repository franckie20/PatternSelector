import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Main {
	
	public static void main(String[] args) {

		SelectorController sc = SelectorController.getInstance();
		
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
		
		Pattern p1 = new Pattern("Factory", "Creating objects without specifying the exact class of object that will be created", "test3", "test4", "test5", img);
		Pattern p2 = new Pattern("Adapter", "test2", "test3", "test4", "test5", img);
		Pattern p3 = new Pattern("Interpreter", "test2", "test3", "test4", "test5", img);
		Pattern p4 = new Pattern("Template", "test2", "test3", "test4", "test5", img);
		
		sc.addPattern(p1);
		sc.addPattern(p2);
		sc.addPattern(p3);
		sc.addPattern(p4);
		
		p1.setPurpose(ps1);
		//p2.setPurpose(ps2);
		//p3.setPurpose(ps3);
		//p4.setPurpose(ps4);
		
		sc.addPurpose(ps1);
		
		p1.setScope(s1);
		p2.setScope(s1);
		p3.setScope(s1);
		p4.setScope(s1);

		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		System.out.println(p4);

		new SelectorFrame(sc);
		
	}		
}
