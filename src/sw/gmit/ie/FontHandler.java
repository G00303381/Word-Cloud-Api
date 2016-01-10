package sw.gmit.ie;

import java.awt.*;
import java.util.Random;

//class used to set the font, color and weight of the word
public class FontHandler {

	private String word;
	private int frequency;
	
	private int fontSize;
	private Color color;
	private Font font;
	private Font fonts[];
	
	private float rValue;
	private float bValue;
	private float gValue;
	
	private GraphicsEnvironment ge;
	
	public FontHandler() {
		super();
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


	public void setColor() {
		this.color = randColour(rValue, gValue, bValue);
	}

	public Color getColor() {
		return color;
	}

	public void setFont(String fontName, int fontWeight, int fontSize) {
		font = new Font(fontName, fontWeight, fontSize);
	}
	
	public void setFont()
	{
		setFont(randomiseFonts(), Font.PLAIN, getFontSize());
	}

	public GraphicsEnvironment getG2d() {
		return ge;
	}

	public void setG2d(GraphicsEnvironment ge) {
		this.ge = ge;
	}
	
	private String randomiseFonts() {
		final int index = (int) (Math.random() * ( fonts.length -1 ));
		return fonts[index].toString();
	}
	
	private Color randColour(float r, float g, float b) {
		Random rand = new Random();
		r = rand.nextFloat();
		g = rand.nextFloat();
		b = rand.nextFloat();
		color = new Color(r, g, b);
		return color;
	}
	
}
