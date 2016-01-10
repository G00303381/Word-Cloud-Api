package sw.gmit.ie;


import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;


import javax.imageio.ImageIO;

//Tag Cloud generator, needs work, size can be off
public class TagCloud {

	private Map<String, Integer>map;
	private CollisionDetector cd;
	private FontHandler fh;
	private BufferedImage image;
	private Graphics2D graphics;
	private int imageWidth;
	private int imageHeight;
	private int wordWidth;
	private int wordHeight;
	private int direction;
	private Color c;
	
	public TagCloud(int width, int height) {

		this.map = map;
		cd = new CollisionDetector();
		fh = new FontHandler();
		image = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
		graphics = (Graphics2D) image.getGraphics();
		
		this.imageWidth = width;
		this.imageHeight = height;
		this.wordWidth = width/2;
		this.wordHeight = height/2;
	}
	
	public void drawWord(Font font, Color color, String word, int direction) {
		
		Rectangle rect; 
		fh.setColor();
		graphics.setColor(color);
		graphics.setFont(font);

		rect = getStringMargin(graphics, word, wordWidth, wordHeight);
		
		while(cd.checkCollision(rect)) {
			move(direction, rect);
			rect = getStringMargin(graphics, word, wordWidth, wordHeight);			
		}
		cd.addCollisionMargin(rect);
		
		graphics.drawString(word, wordWidth, wordHeight);
	}
	
	public void createTagCloud(Map<String, Integer> map2) throws Exception {
		int i = 0;
		direction = 0;
		
		for(Map.Entry<String, Integer> word : map2.entrySet()) {
			fh.setFontSize(word.getValue());
			fh.setFont();
			
			drawWord(fh.getFont(), fh.getColor(), word.getKey(), direction);
			
			if(i % 2 == 0){
				changeDirection();
			}
			
			if(i > 90) {
				break;
			}
			i++;
		}
		
		finishedTagCloud();
	}
	
	private void move(int direction, Rectangle2D rect) {
		switch (direction) {
		case 0:
			if (!(rect.getY() < 0)) {
				wordHeight--;
			}
			break;
			
		case 1:
			if(!(rect.getX() + rect.getWidth() > imageWidth))		
				wordWidth++;				
			else
				resetPos();
			break;
			
		case 2:
			if(!(rect.getY() + rect.getHeight() > imageHeight))		
				wordHeight++;				
			else
				resetPos();
			break;
			
		case 3:
			if(!(rect.getX() < 0))				
				wordWidth--;				
			else
				resetPos();
			break;
		}
	}
	
	private void changeDirection() {
		// TODO Auto-generated method stub
		if(direction > 2) {
			direction = 0;
		}
		
		else{
			direction++;
		}
	}
	
	private Rectangle getStringMargin(Graphics2D g2d, String word, int xHeight, int yWidth)
	{
		FontRenderContext frc = g2d.getFontRenderContext();
		GlyphVector gv = g2d.getFont().createGlyphVector(frc,  word);
		return gv.getPixelBounds(null, xHeight, yWidth);
	}
	
	private void resetPos() {
		wordWidth = imageWidth/2;
		wordHeight = imageHeight/2;
		changeDirection();
	}

	public void finishedTagCloud() throws Exception {
		System.out.println("Reached");
		graphics.dispose();
		ImageIO.write(image, "png", new File("tagCloud.png"));
		System.out.println("Word Cloud Generated");
	}

}
