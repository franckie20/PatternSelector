import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;



public class Main {
	

	
	public static void main(String[] args) throws FileNotFoundException {
		
		SoftwarePatterns sc = SoftwarePatterns.getInstance();
		
		sc.readPatternFromFile();

		Purpose ps1 = new Purpose("Creational");
		Purpose ps2 = new Purpose("Structural");
		Purpose ps3 = new Purpose("Behavorial");

		Scope s1 = new Scope("Class");
		Scope s2 = new Scope("Object");
		
		sc.addPurpose(ps1);
		sc.addPurpose(ps2);
		sc.addPurpose(ps3);
		
		sc.addScope(s1);
		sc.addScope(s2);
		

		new MainFrame(sc);

	}
}
