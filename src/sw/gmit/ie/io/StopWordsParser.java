package sw.gmit.ie.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

//read in the stop words
public class StopWordsParser implements Parser {
	
	private String file;
	private int frequency;
	private TreeSet<String> stopWords = new TreeSet<String>();
		
	public StopWordsParser(String file) throws Exception{
		this.file = file;
	}
	
	//parse in the stop words and then add to the treeset
	@Override
	public String parse() throws Exception {
		try {
			System.out.println("Parsing stopwords.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			StringBuilder sb = new StringBuilder();
			String sentence;

			while ((sentence = br.readLine()) != null) {
				sb.append(sentence);
				stopWords.add(sentence);
			}
			br.close();
			return sb.toString();
		}catch(IOException e){
			System.out.println("Error: " + e.getMessage());
		}
		return "Error Parsing File";
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	
	public TreeSet<String> getWords() {
		return stopWords;
	}

	public int getWordsCount() {
		return frequency;
	}
	
	public void setWordsCount(int frequency) {
		this.frequency = frequency;
	}
}
