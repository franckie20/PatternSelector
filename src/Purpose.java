import java.io.Serializable;


public class Purpose implements Serializable {
	
	private static final long serialVersionUID = 713077749286702637L;

	private String type;
	
	private Pattern hasPattern;
	
	public Purpose(String typ) {
		type = typ;
	}
	
	public Pattern getPattern() {
		return hasPattern;
	}
	
	public void setPattern(Pattern p) {
		hasPattern = p;
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
