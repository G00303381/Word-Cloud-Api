package sw.gmit.ie.io;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*
 * Class designed to read the data taken in from either the entered URL
 * or local file. This class then sorts the data using the SortMap class.
 */
public class ParserHandler {
	//Parser types
	private Parser ps;
	private StopWordsParser swp;
	private DataType dt;
	
	//Private String to take in the stop words
	private String swFile = "stopWords.txt";
	
	//used to store words read in
	private Map<String, Integer> wordMap = new HashMap<String, Integer>();
	
	//used for sorting
	private SortMap sortingMap = new SortMap(wordMap);
	private TreeMap<String, Integer> wordsSorted = new TreeMap<String, Integer>(sortingMap);
	
	//Constructor parses the stop words
	public ParserHandler() throws Exception {
		dt = new DataType();
		swp = new StopWordsParser(swFile);
		swp.parse();
	}
	
	//Reads in the data from a file and then populates the map with the data
	public void fileParser(String file) throws Exception {
		ps = dt.parserType("file", file);
		populateMap(ps.parse());
		sortWords();
	}
	
	//Reads in data from a url and populates the map with the data
	public void urlParser(String file) throws Exception {
		ps = dt.parserType("url", file);
		populateMap(ps.parse());
		sortWords();
	}
	
	//Populates the map with the data parsed
	public void populateMap(String word) {
		
		String[] wordList;
		//ignores punctuation and puts the words to lower case
		wordList = word.replaceAll("[^a-zA-Z]", " ").toLowerCase().split("\\s+");
		
		//fills the map with the word list
		for(String words  : wordList) {
			if(word.length() > 1) {
				fillMap(words);
			}
		}
		//System.out.println(wordMap);
	}

	//method to check if the map contains a stop word
	private void fillMap(String words)
	{
		if(!swp.getWords().contains(words)) {
			if(wordMap.containsKey(words)){
				int frequency = wordMap.get(words);
				frequency++;
				wordMap.replace(words, frequency);	
			}
			else{
				wordMap.put(words, 1);
			}
		}
		else{
			swp.setWordsCount(swp.getWordsCount() + 1);
		}
		
	}

	public void sortWords() {
		wordsSorted.clear();
		wordsSorted.putAll(wordMap);
	}
	
	public void clearWordMap() {
		wordMap.clear();
	}
	
	public Map<String, Integer> getWordMap()
	{
		return wordMap;
	}
	
	public TreeMap<String, Integer> getWordsSorted() {
		return wordsSorted;
	}

}
