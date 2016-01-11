package sw.gmit.ie.colors;

import java.awt.Color;
/*
 * Random Color Generator class
 * Class implements CoulorProvider
 * Class is used to return a Color 
 */
public class RandomColor implements ColourProvider {
	
	private Color color;	
	
	@Override
	public Color getColor() {
		randColour();
		return color;
	}
	
	private Color randColour() {
		int r = (int) (Math.random() * 255);
		int b = (int) (Math.random() * 255);
		int g = (int) (Math.random() * 255);
		color = new Color(r, g, b);
		//System.out.println(r + g + b);
		return color;
	}
}
