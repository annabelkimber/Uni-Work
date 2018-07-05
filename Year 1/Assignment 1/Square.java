/**
 * Square.java
 * @version 1.0.0
 * Originally written by Bette Bultena but heavily modified for the purposes of 
 * CSC-115 (Daniel Archambault and Liam O’Reilly)
 */

import java.awt.*;

/**
 * Square is a shape that can be drawn to the screen, either filled with colour
 * or opaque. Its position is determined by the upper left corner of the
 * square's bounding rectangle.
 */

public class Square extends ClosedShape {
	private int side;

	/**
     * Creates a square.
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param side The side of the square.
     * @param colour The line colour or fill colour.
     * @param isFilled True if the square is filled with colour, false if opaque.
     */
		
	public Square(int insertionTime, int px, int py, int vx, int vy, int side, Color colour, boolean isFilled) {
		super(insertionTime, px, py, vx, vy, colour, isFilled);
		this.side = side;
	}

	/**
	 * Method to convert a square to a string.
	 */

	public String toString() {
		String result = "This is a square\n";
		result += super.toString();
		return result;
	}

	/**
	 * @return The side of the square, which is side.
	 */

	public int getSide() {
		return side;
	}

	/**
	 * @return The height of the square which is side.
	 */

	public int getHeight() {
		return side;
	}

	/**
	 * @return The width of the square, which is side.
	 */

	public int getWidth() {
		return side;
	}

	/**
	 * Draws the square on the screen.
	 * 
	 * @param g The graphics object of the drawable component.
	 */

	public void draw(Graphics g) {
		g.setColor(colour);
		if (isFilled) {
			g.fillRect(xPos, yPos, side, side);
		} else {
			g.drawRect(xPos, yPos, side, side);
		}
	}
}