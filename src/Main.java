
public class Main {
	public static void main(String[] args) throws Throwable {
		
		SoftwarePatterns sc = SoftwarePatterns.getInstance();

		sc.readAllPatternsFromFile();
		
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
		
		Pattern p1 = new Pattern("Test", "Test", "Test", "Test", "Test", "Test");
		p1.setScope(s1);
		p1.setPurpose(ps1);
		sc.addPattern(p1);

		new MainFrame(sc);

	}
}
