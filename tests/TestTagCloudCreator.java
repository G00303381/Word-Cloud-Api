import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import sw.gmit.ie.TagCloudCreator;

public class TestTagCloudCreator {
 
	private TagCloudCreator tg;
	private String fileParser;
	private boolean isFile;

	@BeforeClass
	public static void runTest() {
		System.out.println("Beginning Tests on TagCloudCreator class");
	}

	@Before
	public void init() {
		fileParser = null;
		isFile = true;
		tg = TagCloudCreator.getInstance();
	}

	@Test
	public void makeTagCloud() throws Exception{
		fileParser = "test.txt";
		tg.makeTagCloud(fileParser, isFile);
		
	}

	@AfterClass
	public static void endTest(){
		System.out.println("Finished Testing TagCloudCreator class");
	}

}
