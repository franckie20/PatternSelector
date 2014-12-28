import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SoftwarePatterns {

	private ArrayList<Pattern> allPatterns = new ArrayList<Pattern>();
	private ArrayList<Purpose> allPurposes = new ArrayList<Purpose>();
	private ArrayList<Scope> allScopes = new ArrayList<Scope>();

	private static SoftwarePatterns instance = null;

	public static synchronized SoftwarePatterns getInstance() {
		if (instance == null) {
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
		if (!patternExists(nwePattern.getName())) {
			allPatterns.add(nwePattern);
			return true;
		}
		return false;
	}

	public void removePattern(Pattern exPattern) {
		if (patternExists(exPattern.getName())) {
			allPatterns.remove(exPattern);
		}
	}

	public int countedPatterns() {
		return allPatterns.size();
	}

	public boolean purposeExists(String pur) {
		boolean b = false;
		for (Purpose p : allPurposes) {
			if (p.getType().equals(pur)) {
				b = true;
			}
		}
		return b;
	}

	public boolean addPurpose(Purpose nwePurpose) {
		if (!purposeExists(nwePurpose.getType())) {
			allPurposes.add(nwePurpose);
			return true;
		}
		return false;
	}

	public void removePurpose(Purpose exPurpose) {
		if (purposeExists(exPurpose.getType())) {
			allPatterns.remove(exPurpose);
		}
	}

	public boolean scopeExists(String sco) {
		boolean b = false;
		for (Scope s : allScopes) {
			if (s.getType().equals(sco)) {
				b = true;
			}
		}
		return b;
	}

	public boolean addScope(Scope nweScope) {
		if (!scopeExists(nweScope.getType())) {
			allScopes.add(nweScope);
			return true;
		}
		return false;
	}

	public void removeScope(Scope exScope) {
		if (scopeExists(exScope.getType())) {
			allScopes.remove(exScope);
		}
	}

	public int countedPurposes() {
		return allPurposes.size();
	}

	public String[] getAllPatternsBySearchName(String t) {
		String[] array = new String[allPatterns.size()];
		int counter = 0;
		for (Pattern p : allPatterns) {
			if (p.getName().equals(t)) {
				array[counter] = p.getName();
				counter++;
			}
		}
		return array;
	}

	public String[] getAllPatternsByName() {
		String[] array = new String[allPatterns.size()];
		int counter = 0;
		for (Pattern p : allPatterns) {
			array[counter] = p.getName();
			counter++;
		}
		return array;
	}

	public String[] getAllPurposesByName() {
		String[] array = new String[allPurposes.size()];
		int counter = 0;
		for (Purpose p : allPurposes) {
			array[counter] = p.getType();
			counter++;
		}
		return array;
	}

	public String[] getAllScopesByName() {
		String[] type = new String[allScopes.size()];
		int count = 0;
		for (Scope s : allScopes) {
			type[count] = s.getType();
			count++;
		}
		return type;
	}

	public String[] getAllPatternContexts() {
		String[] context = new String[allPatterns.size()];
		int count = 0;
		for (Pattern p : allPatterns) {
			context[count] = p.getContext();
			count++;
		}
		return context;
	}

	public void setAllScopes(ArrayList<Scope> allScopes) {
		this.allScopes = allScopes;
	}

	public void patternToFile(Pattern p) throws Throwable {
		Pattern fileP = new Pattern();
		fileP.setConsequence(p.getConsequence());
		fileP.setName(p.getName());
		fileP.setProblem(p.getProblem());
		fileP.setContext(p.getContext());
		fileP.setSolution(p.getSolution());
		fileP.setDiagram(p.getDiagram());
		fileP.setPurpose(p.getPurpose());
		fileP.setScope(p.getScope());
		
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("pattern.bin", true));
			os.writeObject(fileP);
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Done writing!");
	}
	
	public void readAllPatternsFromFile() throws IOException, ClassNotFoundException {
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("pattern.bin"));
			Pattern p = (Pattern) is.readObject();
			addPattern(p);
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
