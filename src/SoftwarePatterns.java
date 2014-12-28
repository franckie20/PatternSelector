import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

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

	public void patternToFile() throws Throwable {
		FileWriter fw = new FileWriter("patterns.txt");
		PrintWriter pw = new PrintWriter(fw);
		for (Pattern p : allPatterns) {
			pw.println(p.getName() + ", " + p.getContext() + ", "
					+ p.getProblem() + ", " + p.getSolution() + ", "
					+ p.getConsequence() + ", " + p.getDiagram() + ", "
					+ p.getScope() + ", " + p.getPurpose());
		}
		pw.close();
	}

	public void readAllPatternsFromFile() throws IOException,
			ClassNotFoundException {
		FileReader fr = new FileReader("patterns.txt");
		BufferedReader br = new BufferedReader(fr);
		while (true) {
			String regel = br.readLine();
			if (regel == null) {
				break;
			}
			Scanner sc = new Scanner(regel);
			sc.useDelimiter("\\s*,\\s*");
			String nm = sc.next();
			String con = sc.next();
			String prob = sc.next();
			String sol = sc.next();
			String cons = sc.next();
			String diag = sc.next();
			Scope scope = new Scope((String) sc.next());
			Purpose purpose = new Purpose((String) sc.next());
			
			Pattern p = new Pattern(nm, con, prob, sol, cons, diag);
			p.setPurpose(purpose);
			p.setScope(scope);
			addPattern(p);
			sc.close();
		}

		br.close();
		for (Pattern p : allPatterns) {
			System.out.println(p);
		}
	}
}
