import org.junit.*;

import sw.gmit.ie.io.FileParser;

public class TestFileParser {

	String file;
	FileParser fileParser;
	
	@BeforeClass
	public static void runTest() {
		System.out.println("Beginning Tests on FileReader class");
	}
	
	@Before
	public void init() {
		fileParser = null;
		file = null;
	}
	
	@Test
	public void testGetFile() throws Exception{
		file = "test.txt";
		fileParser = new FileParser(file);
	}
	
	@Test
	public void invalidFile() throws Exception {
		file = "";
		fileParser = new FileParser(file);
	}
	
	@AfterClass
	public static void endTest(){
		System.out.println("Finished Testing FileParser class");
	}

}
