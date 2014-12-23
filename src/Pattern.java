import java.awt.Image;

public class Pattern {

	private String name;
	private String context;
	private String problem;
	private String solution;
	private String consequence;
	private Image diagram;
	
	private Purpose hasPurpose;

	public Pattern(String nm, String con, String pro, String sol, String conseq, Image dia) {
		name = nm;
		context = con;
		problem = pro;
		solution = sol;
		consequence = conseq;
		diagram = dia;
	}
	
	public Purpose getPurpose() {
		return hasPurpose;
	}
	
	public void setPurpose(Purpose p) {
		hasPurpose = p;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	public Image getDiagram() {
		return diagram;
	}

	public void setDiagram(Image diagram) {
		this.diagram = diagram;
	}

	public String getConsequence() {
		return consequence;
	}

	public void setConsequence(String consequence) {
		this.consequence = consequence;
	}
	
	public String toString() {
		String s = "" + name + " " + "- " + context + " - " + problem + " - " + solution + " - " + consequence + " - " + hasPurpose ;
		return s;
		
	}

}
