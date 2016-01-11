package sw.gmit.ie.io;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class URLParser implements Parser{

	private String file;
	
	public URLParser(String file) throws Exception{
		this.file = file;
	}

	@Override
	public String parse() throws Exception {
		 URL oracle = new URL(file);
	        BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));
	        StringBuilder sb = new StringBuilder();
	        String inputLine;
	        while ((inputLine = in.readLine()) != null)
	            sb.append(inputLine);
	        	//System.out.println(inputLine);
	        in.close();
			return sb.toString();
	}

}
