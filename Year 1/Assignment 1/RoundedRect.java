/**
 * RoundedRect.java
 * @version 1.0.0
 * @author Annabel Kimber
 */

import java.awt.*;

/**
 * Rounded Rectangle is a shape that can be drawn to the screen, either
 * filled with colour or opaque.
 * Its position is determined by the upper left corner of
 * the rectangle's bounding rounded rectangle.
 */

public class RoundedRect extends ClosedShape {
	private int width;
	private int height;
	private int arcWidth;
	private int arcHeight;
	
	/**
     * Creates a rectangle.
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param width The width of the rounded rectangle.
     * @param height The height of the rounded rectangle.
     * @param colour The line colour or fill colour.
     * @param isFilled True if the rounded rectangle is filled with colour, false if opaque.
     * @param arcWidth The arcWidth of the rounded rectangle.
     * @param arcHeight The arcHeight of the rounded rectangle
     */
	
	public RoundedRect (int insertionTime, int px, int py, int vx, int vy, int width, int height, Color colour, boolean isFilled, int arcWidth, int arcHeight) {
    	super(insertionTime, px, py, vx, vy, colour, isFilled);
    	this.arcWidth = arcWidth;
    	this.arcHeight = arcHeight;
    	this.width = width;
    	this.height = height;
	}
     
     /**
      * Method to convert a rounded rectangle to a string.
      */
     
	public String toString(){
		String result = "This is a rounded rectangle\n";
		result += super.toString();
		return result;
	}
	
	/**
     * @return The height of the rectangle.
     */
	
	public int getHeight(){
		return height;
	}
	
	/**
     * @return The width of the rectangle.
     */
	
	public int getWidth(){
		return width;
	}
	
	/**
     * @param Resets the arc width of the rounded rectangle
     */
	
	public void setArcWidth(int arcWidth) {
		this.arcWidth = arcWidth;
	}
	
	/**
     * @return The arc width of the rounded rectangle.
     */
	
	public int getArcWidth() {
		return arcWidth;
	}
	
	/**
     * @param Resets the arc height of the rounded rectangle
     */
	
	public void setArcHeight(int arcHeight) {
		this.arcHeight = arcHeight;
	}
	
	
	/**
     @return The arc height of the rounded rectangle.
     */
	
	public int getArcHeight() {
		return arcHeight;
	}
	
	
	/**
     * Draws the rounded rectangle on the screen.
     * @param g The graphics object of the drawable component.
     */

	public void draw(Graphics g) {
		g.setColor(colour);
		if (isFilled) {
			g.fillRoundRect(xPos, yPos, width, height, arcWidth, arcWidth);
		} 
		else {
			g.drawRoundRect(xPos, yPos, width, height, arcWidth, arcWidth);
		}
	}
}