package sw.gmit.ie.io;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

//class that reads in the text file to populate the map
public class ParserHandler {

	private Parser ps;
	private StopWordsParser swp;
	private DataType dt;
	private String swFile = "stopWords.txt";
	
	private Map<String, Integer> wordMap = new HashMap<String, Integer>();
	
	//used for sorting
	private SortMap sm = new SortMap(wordMap);
	private TreeMap<String, Integer> wordsSorted = new TreeMap<String, Integer>(sm);
	
	public ParserHandler() throws Exception {
		dt = new DataType();
		swp = new StopWordsParser(swFile);
		swp.parse();
	}
	
	public TreeMap<String, Integer> getWordsSorted() {
		return wordsSorted;
	}
	
	public void fileParser(String file) throws Exception {
		ps = dt.parserType("file", file);
		populateMap(ps.parse());
		sortWords();
	}
	
	public void populateMap(String word) {
		
		String[] wordList;
		wordList = word.replaceAll("[^a-zA-Z]", " ").toLowerCase().split("\\s+");
		
		for(String words  : wordList) {
			if(word.length() > 1) {
				fillMap(words);
			}
		}
		//System.out.println(wordMap);
	}

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

}
