package sw.gmit.ie;

import java.awt.geom.Rectangle2D;
import java.util.*;

/*
 * class used to detect if a word collides with another word being drawn
 */
public class CollisionDetector {

	private Set<Rectangle2D> rectList;
	
	public CollisionDetector() {
		rectList = new HashSet<Rectangle2D>();
	}
	
	public boolean checkCollision(Rectangle2D r2d) {
		
		boolean collisionDetect = false;
		
		for (Rectangle2D item : rectList) {
			if (item.intersects(r2d)) {
				collisionDetect = true;
				return collisionDetect;
			}
		}
		return collisionDetect;
	}
	
	public void addCollisionMargin(Rectangle2D r2d) {
		rectList.add(r2d);
	}
	
	public void remove(Rectangle2D rect) {
		rectList.remove(rect);
	}
	
	public Set<Rectangle2D> getList() {
		return rectList;
	}
}
