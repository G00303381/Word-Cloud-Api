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
	
	public void makeTagCloud() throws Exception {
		ph = new ParserHandler();
		ph.clearWordMap();
		ph.fileParser("test.txt");
		
		TagCloud tg2 = new TagCloud(width, height);
		tg2.createTagCloud(ph.getWordsSorted());
	}

}
