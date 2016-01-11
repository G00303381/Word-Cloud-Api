package sw.gmit.ie;


public class Runner {
	
	private static boolean isFile;
	private static String parseFile;
	private static String stopWords;
	
	public static void main(String[] args) throws Exception {
		
		parseFile = args[0];
		stopWords = args[1];
		
		if(args[2].equalsIgnoreCase("false"))
		{
			isFile = false;
		}
		
		else{
			isFile = true;
		}
		
		TagCloudCreator tg = TagCloudCreator.getInstance();
		tg.makeTagCloud(parseFile, stopWords, isFile);
	}

}
