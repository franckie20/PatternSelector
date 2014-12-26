import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;

import javax.imageio.ImageIO;


public class Main {
	
	public static void main(String[] args) throws ClassNotFoundException {
		
		SelectorController sc = SelectorController.getInstance();
		
		BufferedImage img = null;

		try {
			img = ImageIO.read(new URL("http://www.dofactory.com/images/diagrams/net/factory.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		try {
			FileInputStream fis = new FileInputStream("pattern.obj");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object obj = ois.readObject();
			Pattern p = (Pattern)obj;
			sc.addPattern(p);
			ois.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		Purpose ps1 = new Purpose("Creational");
		Purpose ps2 = new Purpose("Structural");
		Purpose ps3 = new Purpose("Behavorial");

		
		Scope s1 = new Scope("Class");
		//Scope s2 = new Scope("Object");
		
		Pattern p1 = new Pattern("Factory", "Creating objects without specifying the exact class of object that will be created", "test3", "test4", "test5", img);
		Pattern p2 = new Pattern("Adapter", "allows the interface of an existing class to be used from another interface", "test3", "test4", "test5", img);
		Pattern p3 = new Pattern("Interpreter", "specifies how to evaluate sentences in a language", "test3", "test4", "test5", img);
		Pattern p4 = new Pattern("Template", "defines the program skeleton of an algorithm in a method", "test3", "test4", "test5", img);
		
		sc.addPattern(p1);
		sc.addPattern(p2);
		sc.addPattern(p3);
		sc.addPattern(p4);
		
		p1.setPurpose(ps1);
		p2.setPurpose(ps2);
		p3.setPurpose(ps3);

		
		sc.addPurpose(ps1);
		
		p1.setScope(s1);
		p2.setScope(s1);
		p3.setScope(s1);
		p4.setScope(s1);

		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		System.out.println(p4);

		new MainFrame(sc);
		
	}		
}
