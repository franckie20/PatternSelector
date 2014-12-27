import javax.xml.bind.annotation.XmlAttribute;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("purpose")
public class Purpose {
	
	@XmlAttribute
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
