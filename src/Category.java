import java.util.ArrayList;


public class Category {
	
	private String Description;
	private ArrayList<Pattern> allPatterns;
	
	public Category(String De) {
		De = Description;
		allPatterns = new ArrayList<Pattern>();
	}

	public void addPattern(Pattern nwePattern) {
		allPatterns.add(nwePattern);
	}
	
	public void removePattern(Pattern exPattern) {
		allPatterns.remove(exPattern);
	}
	
	public int countedPatterns() {
		return allPatterns.size();
	}
	
	public ArrayList<Pattern> getAllPatterns() {
		return allPatterns;
		
	}
	
	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
	
	



}
