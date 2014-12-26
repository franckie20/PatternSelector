import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;


@SuppressWarnings("serial")
public class SelectorController implements Serializable {
	
	
	private ArrayList<Pattern> allPatterns = new ArrayList<Pattern>();
	private ArrayList<Purpose> allPurposes = new ArrayList<Purpose>();
	
	private static SelectorController instance = null;
	
	public static synchronized SelectorController getInstance(){
		if (instance == null){
			instance = new SelectorController();
		}
		return instance;
	}
	
	
	public void savePatternData()
	{
	      try
	      {
	         FileOutputStream fileOut = new FileOutputStream("pattern.obj");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);

	         out.writeObject(this);

	         out.close();
	         fileOut.close();
	      }
	      catch(IOException i)
	      {
	          i.printStackTrace();
	      }
	}

	public void loadPatternData()
	{
	      try
	      {
	         FileInputStream fileIn = new FileInputStream("pattern.obj");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         Pattern tmp = (Pattern) in.readObject();
	         
	         addPattern(tmp);

	         in.close();
	         fileIn.close();
	      }
	      catch(IOException i)
	      {
	         i.printStackTrace();
	         return;
	      }
	      catch(ClassNotFoundException c)
	      {
	         c.printStackTrace();
	         return;
	      }
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
	
	public String[] getAllPatternContexts() {
		String[] context = new String[allPatterns.size()];
		int count = 0;
		for(Pattern p : allPatterns) {
			context[count] = p.getContext();
			count++;
		}
		return context;
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
			savePatternData();
			return true;
		}
		return false;
	}

	public void removePattern(Pattern exPattern) {
		if(patternExists(exPattern.getName())) {
			allPatterns.remove(exPattern);
			savePatternData();
		}
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
