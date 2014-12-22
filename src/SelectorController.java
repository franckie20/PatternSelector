import java.util.ArrayList;


public class SelectorController {
	
	
	private ArrayList<Pattern> allPatterns = new ArrayList<Pattern>();
	
	public String[] getAllPatternsBySearchName(String t) {
		String[] array = new String[allPatterns.size()];
		int counter = 0;
		for(Pattern p : allPatterns) {
			if(p.getName().equals(t)){
				array[counter] = p.getName();
				counter++;
			}
		}
		return array;
	}
	
	public ArrayList<Pattern> getAllPatterns() {
		return allPatterns;
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

}
