import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Main {

	public static void main(String[] args ) {
		
		BufferedImage img = null;
		
		try {
			img = ImageIO.read(new URL("http://www.dofactory.com/images/diagrams/net/factory.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		Category c1 = new Category("Test");
		
		Pattern p1 = new Pattern("Factory Method", "test2", "test3", "test4", "test5", img);
		c1.addPattern(p1);

		
		System.out.println(p1);
		
	}
}
