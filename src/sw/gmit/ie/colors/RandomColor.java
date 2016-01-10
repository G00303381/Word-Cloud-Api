package sw.gmit.ie.colors;

import java.awt.Color;
import java.util.Random;

public class RandomColor implements ColourProvider {
	
	private Color color;
	private float rValue;
	private float gValue;
	private float bValue;
	
	@Override
	public void setColor() {
		this.color = randColour(rValue, gValue, bValue);
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return color;
	}
	
	private Color randColour(float r, float g, float b) {
		Random rand = new Random();
		r = rand.nextFloat();
		g = rand.nextFloat();
		b = rand.nextFloat();
		
		color = new Color(r, g, b);
		//System.out.println(r + g + b);
		return color;
	}
}
