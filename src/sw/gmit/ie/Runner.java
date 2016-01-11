package sw.gmit.ie;


public class Runner {
	
	private static boolean isFile;
	private static String parseFile;
	
	public static void main(String[] args) throws Exception {
		
		TagCloudCreator tg = TagCloudCreator.getInstance();
		
		parseFile = args[0];
		
		if(args[1].equalsIgnoreCase("false"))
		{
			isFile = false;
		}
		
		else{
			isFile = true;
		}
		
		tg.makeTagCloud(parseFile, isFile);
	}

}
