package sw.gmit.ie;

import sw.gmit.ie.io.ParserHandler;

//Singleton class that actually makes the tag cloud
public class TagCloudCreator {

	private static TagCloudCreator instance = new TagCloudCreator();
	
	private TagCloudCreator() {}
	
	private int width = 1000;
	private int height = 1000;
	private ParserHandler ph;

	public static TagCloudCreator getInstance() {
		return instance;
	}
	
	public void makeTagCloud(String file, boolean isFile) throws Exception {
		
		if(isFile = true){
			ph = new ParserHandler();
			ph.clearWordMap();
			ph.fileParser(file);
			ph.sortWords();
			TagCloud tg2 = new TagCloud(width, height);
			tg2.createTagCloud(ph.getWordsSorted());
		}
		
		else if(isFile = false){
			ph = new ParserHandler();
			ph.clearWordMap();
			ph.urlParser(file);
			ph.sortWords();
			TagCloud tg2 = new TagCloud(width, height);
			tg2.createTagCloud(ph.getWordsSorted());
		}
		
		else{
			System.out.println("Please enter a valid URL or Text File");
		}
	}

}
