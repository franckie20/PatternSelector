import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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

		try {

			File f = new File("pattern.obj");

			if (f.exists() && f.isFile()) {
				FileInputStream fis = new FileInputStream("pattern.obj");

				ObjectInputStream ois = new ObjectInputStream(fis);
				Object obj = ois.readObject();
				Pattern p = (Pattern) obj;
				sc.addPattern(p);
				ois.close();
			}
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

		Purpose ps1 = new Purpose("Creational");
		Purpose ps2 = new Purpose("Structural");
		Purpose ps3 = new Purpose("Behavorial");

		Scope s1 = new Scope("Class");
<<<<<<< HEAD
		Scope s2 = new Scope("Object");
		
		Pattern p1 = new Pattern("Factory", "Creating objects without specifying the exact class of object that will be created", "test1", "solution1", "consequence1", "http://www.apwebco.com/images/FactoryMethodDetailed.png");
		Pattern p2 = new Pattern("Adapter", "allows the interface of an existing class to be used from another interface", "Class Adapter: introduces only one object,Adapter override some of Adaptee's behaviour ", "solution2", "consequence2", "http://www.dofactory.com/images/diagrams/net/adapter.gif");
		Pattern p3 = new Pattern("Interpreter", "specifies how to evaluate sentences in a language", "problem3", "solution3", "consequence3", "http://www.dofactory.com/images/diagrams/net/interpreter.gif");
		Pattern p4 = new Pattern("Template", "defines the program skeleton of an algorithm in a method", "problem4", "solution4", "consequence4", "http://groovy.codehaus.org/download/attachments/78107/TemplateMethodClasses.gif?version=1&modificationDate=1178589659877&api=v2");
		
=======
		// Scope s2 = new Scope("Object");

		Pattern p1 = new Pattern(
				"Factory",
				"Creating objects without specifying the exact class of object that will be created",
				"test1", "solution1", "consequence1", img);
		Pattern p2 = new Pattern(
				"Adapter",
				"allows the interface of an existing class to be used from another interface",
				"problem2", "solution2", "consequence2", img);
		Pattern p3 = new Pattern("Interpreter",
				"specifies how to evaluate sentences in a language",
				"problem3", "solution3", "consequence3", img);
		Pattern p4 = new Pattern("Template",
				"defines the program skeleton of an algorithm in a method",
				"problem4", "solution4", "consequence4", img);

>>>>>>> origin/master
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
