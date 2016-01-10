package sw.gmit.ie;


public class Runner {
	
	public static void main(String[] args) throws Exception {
		
		TagCloudCreator tg = TagCloudCreator.getInstance();
		tg.makeTagCloud();
	}

}
