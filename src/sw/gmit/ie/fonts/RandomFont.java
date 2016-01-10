package sw.gmit.ie.fonts;

import java.awt.Font;
import java.awt.GraphicsEnvironment;

public class RandomFont implements FontProvider{
	
	private int fontSize;
	
	private GraphicsEnvironment ge;
	private Font[] fonts;
	private Font font;
	
	
	public RandomFont() {
		ge= GraphicsEnvironment.getLocalGraphicsEnvironment();
		fonts = ge.getAllFonts();
	}
		
	public void setFont(String fontName, int fontWeight, int fontSize) {
		font = new Font(fontName, fontWeight, fontSize);
	}
	
	public void setFont()
	{
		setFont(randomiseFonts(), Font.PLAIN, getSize());
	}
	
	
	public void setSize(int size) {
		fontSize = (int)(12 + size);
		if (fontSize > 40) {
			fontSize = 40;
		}
	}
	
	public int getSize() {
		// TODO Auto-generated method stub
		return fontSize;
	}

	@Override
	public Font getFont() {
		return font;
		
		/*for(Font font : fonts) {
			System.out.println(font.getFontName() + " : ");
			System.out.println(font.getFamily());
		}*/
	}
	
	private String randomiseFonts() {
		final int index = (int) (Math.random() * ( fonts.length -1 ));
		//System.out.println(fonts[index].toString());
		return fonts[index].toString();
	}
	
	/*public static void main(String[] args) {
		RandomFont rf = new RandomFont();
		System.out.println(rf.randomiseFonts());
		
	}*/

}
