import java.io.Serializable;

public class Scope implements Serializable {

	private static final long serialVersionUID = -5184019743435376246L;
	
	private String type;
	private Pattern hasPattern;

	public Scope(String typ) {
		type = typ;
	}
	
	public Pattern getPattern() {
		return hasPattern;
	}

	public String getType() {
		return type;
	}

	public void setType(String typ) {
		type = typ;
	}
	
	public String toString() {
		String s = type;
		return s;
	}
}
