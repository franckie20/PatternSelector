import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Main {

	public static void main(String[] args ) {
		
		BufferedImage img = null;
		
		try {
			img = ImageIO.read(new File("C:/Users/FranckV/Dropbox/Assignment 2/images/factory.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Pattern p1 = new Pattern("Factory Method", "test2", "test3", "test4", "test5", img);
		
		
		System.out.println(p1);
	}
}
