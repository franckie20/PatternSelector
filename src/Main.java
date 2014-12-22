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

		Pattern p1 = new Pattern("Factory Method", "test2", "test3", "test4", "test5", img);

		System.out.println(p1);

	}
}
