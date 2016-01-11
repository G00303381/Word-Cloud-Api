package sw.gmit.ie.io;

import java.io.*;

/*
 * Class designed to read in text files
 */
public class FileParser implements Parser{

	private String file;
	
	public FileParser(String file) throws Exception{
		this.file = file;
	}
	
	@Override
	public String parse() throws Exception {
		System.out.println("Parsing File...");
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		StringBuilder sb = new StringBuilder();
		String sentence;

		while ((sentence = br.readLine()) != null) {
			sb.append(sentence);
		}
		br.close();
		return sb.toString();
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}
}
