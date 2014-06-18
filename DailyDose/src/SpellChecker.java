import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;


public class SpellChecker {

	public void loadDictionary() {
		
		if (new File("dict.properties").exists()){
			return;
		}
		
		BufferedReader reader = null;
		Properties prop = new Properties();
		OutputStream output = null;
		try{
			String curLine;
			output = new FileOutputStream("dict.properties");
			
			reader = new BufferedReader(new FileReader("words.txt"));
			while ((curLine =reader.readLine()) != null ) {
				prop.setProperty(curLine, "");
			}
			prop.store(output, null);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public void checkWords(String[] words){
		Properties prop = new Properties();
		InputStream input = null;
		
		try {
			input = new FileInputStream("dict.properties");
			
			prop.load(input);
			for (String word :  words) {
				System.out.print(word + ": ");
				if (prop.containsKey(word)){
					System.out.print("correct");
				}
				else{
					System.out.print("incorrect");
				}
				
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	
	public static void main(String[] args) {
		SpellChecker spellChecker = new SpellChecker();
		spellChecker.loadDictionary();
		spellChecker.checkWords(args);
	}

}
