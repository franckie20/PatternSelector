import java.io.IOException;

public class Main {
	

	
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		
		SoftwarePatterns sc = SoftwarePatterns.getInstance();
		
		sc.readPatternFromFile();

		Purpose ps1 = new Purpose("Creational");
		Purpose ps2 = new Purpose("Structural");
		Purpose ps3 = new Purpose("Behavorial");

		Scope s1 = new Scope("Class");
		Scope s2 = new Scope("Object");
		
		sc.addPurpose(ps1);
		sc.addPurpose(ps2);
		sc.addPurpose(ps3);
		
		sc.addScope(s1);
		sc.addScope(s2);
		

		new MainFrame(sc);

	}
}
