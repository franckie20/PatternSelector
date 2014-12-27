import java.util.ArrayList;


public class SoftwarePatterns  {
	
	
	private ArrayList<Pattern> allPatterns = new ArrayList<Pattern>();
	private ArrayList<Purpose> allPurposes = new ArrayList<Purpose>();
	private ArrayList<Scope> allScopes = new ArrayList<Scope>();
	
	private static SoftwarePatterns instance = null;
	
	public static synchronized SoftwarePatterns getInstance(){
		if (instance == null){
			instance = new SoftwarePatterns();
		}
		return instance;
	}

	
	public ArrayList<Pattern> getAllPatterns() {
		return allPatterns;
	}
	
	public boolean patternExists(String pat) {
		boolean b = false;
		for (Pattern p : allPatterns) {
			if (p.getName().equals(pat)) {
				b = true;
			}
		}
		return b;
	}	
	
	public boolean addPattern(Pattern nwePattern) {
		if(!patternExists(nwePattern.getName())) {
			allPatterns.add(nwePattern);
			return true;
		}
		return false;
	}

	public void removePattern(Pattern exPattern) {
		if(patternExists(exPattern.getName())) {
			allPatterns.remove(exPattern);
		}
	}

	public int countedPatterns() {
		return allPatterns.size();
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
	
	public String[] getAllPurposesByName() {
		String[] array = new String[allPurposes.size()];
		int counter = 0;
		for(Purpose p : allPurposes) {
			array[counter] = p.getType();
			counter++;
		}
		return array;
	}
	
	public String[] getAllScopesByName() {
		String[] type = new String[allScopes.size()];
		int count = 0;
		for(Scope s : allScopes) {
			type[count] = s.getType();
			count++;
		}
		return type;
	}
	
	
	public String[] getAllPatternContexts() {
		String[] context = new String[allPatterns.size()];
		int count = 0;
		for(Pattern p : allPatterns) {
			context[count] = p.getContext();
			count++;
		}
		return context;
	}

	public void setAllScopes(ArrayList<Scope> allScopes) {
		this.allScopes = allScopes;
	}
}
