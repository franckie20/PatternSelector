public class Purpose {
	
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

	private String type;

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
