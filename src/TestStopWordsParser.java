import static org.junit.Assert.*;


import org.junit.*;

import sw.gmit.ie.io.StopWordsParser;

public class TestStopWordsParser {

	String file;
	StopWordsParser swParser;
	
	@BeforeClass
	public static void runTest() {
		System.out.println("Beginning Tests on StopWordsParser class");
	}
	
	@Before
	public void init() {
		swParser = null;
		file = null;
	}
	
	@Test
	public void testGetFile() throws Exception{
		file = "stopwords.txt";
		swParser = new StopWordsParser(file);
	}
	
	@Test
	public void invalidGetFIle() throws Exception{
		file = "";
		swParser = new StopWordsParser(file);
	}
	
	
	@AfterClass
	public static void endTest(){
		System.out.println("Finished Testing StopWordsParser class");
	}


}
