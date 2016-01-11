import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import sw.gmit.ie.io.URLParser;;

public class TestURLParser {

	String file;
	URLParser urlParser;
	
	@BeforeClass
	public static void runTest() {
		System.out.println("Beginning Tests on URLParser class");
	}
	
	@Before
	public void init() {
		urlParser = null;
		file = null;
	}
	
	@Test
	public void testGetFile() throws Exception{
		file = "test.txt";
		urlParser = new URLParser("http://www.gmit.ie");
	}
	
	@Test
	public void invalidFile() throws Exception {
		file = "";
		urlParser = new URLParser("null");
	}
	
	@AfterClass
	public static void endTest(){
		System.out.println("Finished Testing FileParser class");
	}

}
