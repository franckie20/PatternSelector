import java.util.ArrayList;


public class SelectorController {
	
	private static SelectorController instance = null;
	
	public static synchronized SelectorController getInstance(){
		if (instance == null){
			instance = new SelectorController();
		}
		return instance;
	}
	
	private ArrayList<Pattern> allPatterns = new ArrayList<Pattern>();
	private ArrayList<Purpose> allPurposes = new ArrayList<Purpose>();
	
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
	
	public String[] getAllPatternsByName() {
		String[] array = new String[allPatterns.size()];
		int counter = 0;
		for(Pattern p : allPatterns) {
			array[counter] = p.getName();
			counter++;
		}
		return array;
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
	
	public String[] getAllPurposesByName() {
		String[] array = new String[allPurposes.size()];
		int counter = 0;
		for(Purpose p : allPurposes) {
			array[counter] = p.getType();
			counter++;
		}
		return array;
	}
	
	public void addPurpose(Purpose nwePurpose) {
		allPurposes.add(nwePurpose);
	}

	public void removePurpose(Purpose exPurpose) {
		allPurposes.remove(exPurpose);
	}

	public int countedPurposes() {
		return allPurposes.size();
	}

}
