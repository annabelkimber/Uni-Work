import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * ShapeTester.java
 * @author Daniel Archambault and Liam O'Reilly
 * @version 2.0.0
 * This application is inspired based on an assignment of Bette Bultena (UVictoria).  However, we have heavily modified it for this course.
 */

/**
 * ShapeTester creates and draws a bunch of shapes to the screen. Note that this
 * is not an exhaustive test program. Not all constructors are tested. This
 * program can be run as either an Applet or as a stand-alone Application.
 */
public class BouncingShapesWindow extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private static final String FRAME_TITLE = "Shape Booooiiinggg Frame";
	private static final int FRAME_WIDTH = 700;
	private static final int FRAME_HEIGHT = 700;
	private static final int ANIMATION_DELAY = 10;
	
	private int currentTime = 0;
	private Timer animationTimer;
	private JPanel drawingPanel;
	private Queue shapesToAdd;
	private ArrayList<ClosedShape> activeShapes;
	
	public BouncingShapesWindow(String filename)
	{
		activeShapes = new ArrayList<ClosedShape>();
		this.initShapes(filename);
		this.insertShapes ();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(FRAME_TITLE);
		this.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));

		animationTimer = new Timer(ANIMATION_DELAY, this);
		// Create a drawing panel based on JPanel (using an anonymous inner class).
		// We provide a paint method which will draw our shapes.
		drawingPanel = new JPanel() {
			private static final long serialVersionUID = 1L;
			public void paint(Graphics g)
			{
			    super.paintComponent (g);
				for (ClosedShape s : activeShapes)
				{
					s.draw(g);
				}
			}
		};
		
		this.add(drawingPanel);
		this.pack();
		animationTimer.start();
	}
	
	

	/**
	 * Initializes the shapes by reading the file and creating the queue.
	 */
	private void initShapes (String filename) {
		shapesToAdd = ReadShapeFile.readFile(filename);
	}
	
	/**
	 * Add the shapes whose time has come!
	 */
	private void insertShapes() {
		//no more shapes to add, we are done
		if (shapesToAdd.isEmpty ()) {
			return;
		}
		
		//add shapes if needed
		ClosedShape current = (ClosedShape) shapesToAdd.peek ();
		while (!shapesToAdd.isEmpty () && (current.getInsertionTime() <= currentTime*ANIMATION_DELAY)) {
			activeShapes.add(current);
			shapesToAdd.dequeue();
			if (!shapesToAdd.isEmpty ()) {
				current = (ClosedShape) shapesToAdd.peek();
			}
		}
	}
	
	/**
	 * Method to move the shapes present in the scene according to their velocity.
	 */
	public void moveShapes()
	{
		Dimension dims = drawingPanel.getSize();
		for (ClosedShape s : activeShapes)
		{
			s.move();
			
			// Move us back in and bounce if we went outside the drawing area.
			if (s.outOfBoundsX(dims.getWidth()))
			{
				s.putInBoundsX(dims.getWidth());
				s.bounceX();
			}
			
			if (s.outOfBoundsY(dims.getHeight()))
			{
				s.putInBoundsY(dims.getHeight());
				s.bounceY();
			}
			
		}
	}

	/**
	 * Causes animation to occur by using event handlers (Don't worry if you don't understand yet)
	 */
	public void actionPerformed(ActionEvent e)
	{
		currentTime++;
		moveShapes();
		insertShapes ();
		// Ask the drawing panel to repaint itself at the earliest opportunity. This does not actually do the re-painting.
		drawingPanel.repaint();
	}
}