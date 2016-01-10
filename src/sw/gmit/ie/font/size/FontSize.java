package sw.gmit.ie.font.size;

public class FontSize {

	private int fontSize;
	
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
}
