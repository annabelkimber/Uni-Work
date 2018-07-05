/**
 * Rect.java
 * @version 1.0.0
 * @author Annabel Kimber
 */

import java.awt.*;

/**
 * Rectangle is a shape that can be drawn to the screen, either
 * filled with colour or opaque.
 * Its position is determined by the upper left corner of
 * the rectangle's bounding rectangle.
 */

public class Rect extends ClosedShape {
	private int height;
	private int width;
	
	/**
     * Creates a rectangle.
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param width The width of the rectangle.
     * @param height The height of the rectangle.
     * @param colour The line colour or fill colour.
     * @param isFilled True if the rectangle is filled with colour, false if opaque.
     */
	
	public Rect(int insertionTime, int px, int py, int vx, int vy, int height, int width, Color colour,
			boolean isFilled) {
		super(insertionTime, px, py, vx, vy, colour, isFilled);
		this.height = height;
		this.width = width;
	}
	
	 /**
     * Method to convert a rectangle to a string.
     */

	public String toString() {
		String result = "This is a rectangle\n";
		result += super.toString();
		return result;
	}

	/**
	 * @return The height of the rectangle.
	 */

	public int getHeight() {
		return height;
	}

	/**
	 * @return The width of the rectangle.
	 */

	public int getWidth() {
		return width;
	}

	/**
	 * Draws the rectangle on the screen.
	 * 
	 * @param g The graphics object of the drawable component.
	 */

	public void draw(Graphics g) {
		g.setColor(colour);
		if (isFilled) {
			g.fillRect(xPos, yPos, width, height);
		} else {
			g.drawRect(xPos, yPos, width, height);
		}
	}
}
