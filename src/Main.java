
public class Main {

	public static void main(String[] args) {

		SoftwarePatterns sc = SoftwarePatterns.getInstance();
		
		//XStream xstream = new XStream();
		
		//xstream.alias("pattern", Pattern.class);
		//xstream.alias("purpose", Purpose.class);
		//xstream.alias("scope", Scope.class);

		Purpose ps1 = new Purpose("Creational");
		Purpose ps2 = new Purpose("Structural");
		Purpose ps3 = new Purpose("Behavorial");

		Scope s1 = new Scope("Class");
		//Scope s2 = new Scope("Object");
		
		Pattern p1 = new Pattern("Factory", "Creating objects without specifying the exact class of object that will be created", "test1", "solution1", "consequence1", "http://www.apwebco.com/images/FactoryMethodDetailed.png");
		Pattern p2 = new Pattern("Adapter", "allows the interface of an existing class to be used from another interface", "Class Adapter: introduces only one object,Adapter override some of Adaptee's behaviour ", "solution2", "consequence2", "http://www.dofactory.com/images/diagrams/net/adapter.gif");
		Pattern p3 = new Pattern("Interpreter", "specifies how to evaluate sentences in a language", "problem3", "solution3", "consequence3", "http://www.dofactory.com/images/diagrams/net/interpreter.gif");
		Pattern p4 = new Pattern("Template", "defines the program skeleton of an algorithm in a method", "problem4", "solution4", "consequence4", "http://groovy.codehaus.org/download/attachments/78107/TemplateMethodClasses.gif?version=1&modificationDate=1178589659877&api=v2");

		sc.addPattern(p1);
		sc.addPattern(p2);
		sc.addPattern(p3);
		sc.addPattern(p4);

		p1.setPurpose(ps1);
		p2.setPurpose(ps2);
		p3.setPurpose(ps3);
		p4.setPurpose(ps3);

		sc.addPurpose(ps1);

		p1.setScope(s1);
		p2.setScope(s1);
		p3.setScope(s1);
		p4.setScope(s1);

		new MainFrame(sc);

	}
}
