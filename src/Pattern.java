import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("pattern")
public class Pattern implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7145052309161516555L;
	
	@XmlAttribute
	private String name;
	@XmlAttribute
	private String context;
	@XmlAttribute
	private String problem;
	@XmlAttribute
	private String solution;
	@XmlAttribute
	private String consequence;
	@XmlAttribute
	private String diagram;
	
	@XmlAttribute
	private Purpose hasPurpose;
	@XmlAttribute
	private Scope hasScope;

	public Pattern(String nm, String con, String pro, String sol, String conseq, String dia) {
		name = nm;
		context = con;
		problem = pro;
		solution = sol;
		consequence = conseq;
		diagram = dia;
	}
	
	public String getPurpose() {
		return hasPurpose.getType();
	}
	
	public void setPurpose(Purpose p) {
		hasPurpose = p;
	}
	
	public String getScope() {
		return hasScope.getType();
	}
	
	public void setScope(Scope s) {
		hasScope = s;
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

	public String getDiagram() {
		return diagram;
	}

	public void setDiagram(String diagram) {
		this.diagram = diagram;
	}

	public String getConsequence() {
		return consequence;
	}

	public void setConsequence(String consequence) {
		this.consequence = consequence;
	}
	
	public String toString() {
		String s = "" + name + " " + "- " + context + " - " + problem + " - " + solution + " - " + consequence + " - " + hasPurpose + " - " + hasScope;
		return s;
		
	}
}
