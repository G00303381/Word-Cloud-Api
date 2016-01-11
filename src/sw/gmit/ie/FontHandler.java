package sw.gmit.ie;

import java.awt.*;

import sw.gmit.ie.colors.RandomColor;

//class used to set the font, color and weight of the word
public class FontHandler {

	private RandomColor rc;
	
	private String word;
	private int frequency;
	private int fontSize;
	private Font font;
	
	private Font fonts[];
	
	private GraphicsEnvironment ge;
	
	public FontHandler() {
		rc = new RandomColor();
		ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		fonts = ge.getAllFonts();
	}
	
	public FontHandler(String word, int frequency, int fontSize) {
		super();
		this.setWord(word);
		this.setFrequency(frequency);
		this.setFontSize(fontSize);
		this.setFont();
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fSize) {
		fontSize = (int)(12 + fSize);
		if (fontSize > 40) {
			fontSize = 40;
		}
	}
	
	public Font getFont() {
		return font;
	}

	public Color getColor() {
		return rc.getColor();
	}

	public void setFont(String fontName, int fontWeight, int fontSize) {
		font = new Font(fontName, fontWeight, fontSize);
	}
	
	public void setFont()
	{
		setFont(randomiseFonts(), Font.PLAIN, getFontSize());
	}
	
	private String randomiseFonts() {
		final int index = (int) (Math.random() * ( fonts.length -1 ));
		return fonts[index].getFontName();
	}

}
