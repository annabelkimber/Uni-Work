/**
 * This class reads a shape file.  For the format of this shape file, see the assignment description.
 * Also, please see the shape files ExampleShapes.txt, ExampleShapesStill.txt, and TwoRedCircles.txt
 *
 * @author Annabel Kimber
 *
 */

import java.awt.Color;
import java.io.*;
import java.util.Scanner;

public class ReadShapeFile {

	/**
	 * Creates an Circle.
	 * @param in Reads in the values of circle from the text file
	 * and assigns  them to the shape.
	 * @return Returns the newly created circle shape with the parameters
	 * from the text file.
	 */

	public static Circle circleExample(Scanner in){

		int insertionTime = in.nextInt();
		int x = in.nextInt();
		int y = in.nextInt();
		int diameter = in.nextInt();
		int r = in.nextInt();
		int g = in.nextInt();
		int b = in.nextInt();
		Color colour = new Color (r,g,b);
		boolean isFilled = in.nextBoolean ();
		int vx = in.nextInt();
		int vy = in.nextInt(); 

		Circle shapeCircle = new Circle (insertionTime, x,  y, vx, vy, diameter, colour, isFilled);

		return shapeCircle;
	}

	/**
	 * Creates an oval.
	 * @param in Reads in the values of oval from the text file
	 * and assigns  them to the shape.
	 * @return Returns the newly created oval shape with the parameters
	 * from the text file.
	 */

	public static Oval ovalExample(Scanner in){

		int insertionTime = in.nextInt();
		int x = in.nextInt();
		int y = in.nextInt();
		int width = in.nextInt(); 
		int height = in.nextInt();
		int r = in.nextInt();
		int g = in.nextInt();
		int b = in.nextInt();
		Color colour = new Color (r,g,b);
		boolean isFilled = in.nextBoolean ();
		int vx = in.nextInt();
		int vy = in.nextInt();

		Oval shapeOval = new Oval (insertionTime, x, y, vx, vy, width, height, colour, isFilled);

		return shapeOval;
	}

	/**
	 * Creates an square.
	 * @param in Reads in the values of square from the text file
	 * and assigns  them to the shape.
	 * @return Returns the newly created square shape with the parameters
	 * from the text file.
	 */

	public static Square squareExample(Scanner in){

		int insertionTime = in.nextInt();
		int px = in.nextInt();
		int py = in.nextInt();
		int side = in.nextInt(); 
		int r = in.nextInt();
		int g = in.nextInt();
		int b = in.nextInt();
		Color colour = new Color (r,g,b);
		boolean isFilled = in.nextBoolean ();
		int vx = in.nextInt();
		int vy = in.nextInt();

		Square shapeSquare = new Square (insertionTime, px, py, vx, vy, side, colour, isFilled);

		return shapeSquare;
	}

	/**
	 * Creates an rectangle.
	 * @param in Reads in the values of rectangle from the text file
	 * and assigns  them to the shape.
	 * @return Returns the newly created rectangle shape with the parameters
	 * from the text file.
	 */

	public static Rect rectExample(Scanner in){

		int insertionTime = in.nextInt();
		int px = in.nextInt();
		int py = in.nextInt();
		int width = in.nextInt(); 
		int height = in.nextInt();
		int r = in.nextInt();
		int g = in.nextInt();
		int b = in.nextInt();
		Color colour = new Color (r,g,b);
		boolean isFilled = in.nextBoolean ();
		int vx = in.nextInt();
		int vy = in.nextInt();

		Rect shapeRect = new Rect (insertionTime, px, py, vx, vy, width, height, colour, isFilled);

		return shapeRect;
	}

	/**
	 * Creates an rounded rectangle.
	 * @param in Reads in the values of rounded rectangle from the text file
	 * and assigns  them to the shape.
	 * @return Returns the newly created rounded rectangle shape with the parameters
	 * from the text file.
	 */

	public static RoundedRect roundedRectExample (Scanner in) {
		int insertionTime = in.nextInt();
		int px = in.nextInt();
		int py = in.nextInt();
		int width = in.nextInt();
		int height = in.nextInt();
		int r = in.nextInt();
		int g = in.nextInt();
		int b = in.nextInt();
		Color colour = new Color (r,g, b);
		boolean isFilled = in.nextBoolean();
		int vx = in.nextInt();
		int vy = in.nextInt();
		int arcWidth = in.nextInt();
		int arcHeight = in.nextInt();

		RoundedRect shapeRoundedRect = new RoundedRect(insertionTime, px, py, vx, vy, width, height, colour, isFilled, arcWidth, arcHeight);

		return shapeRoundedRect;
	}
	//TODO:  You will likely need to write four methods here.  One method to construct each shape
	//given the Scanner passed as a parameter.  I would suggest four static methods in this case.

	/**
	 * Reads the data file used by the program and returns the constructed queue
	 * @param in the scanner of the file
	 * @return the queue represented by the data file
	 */
	private static Queue readDataFile (Scanner in) {
		Queue shapeQueue = new Queue ();

		/*A while loop to assign the values read in from the file to 
		the correct shape in the queue.*/

		while (in.hasNextLine()){
			String shape = in.next();
			if (shape.equals("circle")){
				shapeQueue.enqueue(ReadShapeFile.circleExample(in));
			}
			else if (shape.equals("oval")){
				shapeQueue.enqueue(ReadShapeFile.ovalExample(in));
			}
			else if (shape.equals ("rect")){
				shapeQueue.enqueue(ReadShapeFile.rectExample(in));
			}
			else if (shape.equals("square")){
				shapeQueue.enqueue(ReadShapeFile.squareExample(in));
			}
			else if (shape.equals("roundedrect")){
				shapeQueue.enqueue(ReadShapeFile.roundedRectExample(in));
			}
		}
		in.close();
		return shapeQueue;
	}
	//TODO:  Your loop goes here.



	/**
	 * Method to read the file and return a queue of shapes from this file.  The program should handle
	 * the file not found exception here and shut down the program gracefully.
	 * @param filename the name of the file
	 * @return the queue of shapes from the file
	 */
	public static Queue readFile (String filename) {
		//HINT:  You might want to open a file here.
		File inputFile = new File (filename);
		Scanner in = null;
		try { //Throwing an exception if no file is found.
			in = new Scanner (inputFile);
		}
		catch (FileNotFoundException e) {
			System.out.println("Cannot open" + filename);
		}	


		//TODO: Change this to construct a proper scanner.

		//TODO:  Read the input file specified by "filename" and return a queue containing
		//All of the shapes specified in this file

		//WARNING:  Do not put all of the code to read the file in this method.  Please,
		//break it up into smaller methods.  If you put all the code to read the file here
		//you'll lose style marks and it will be much, much harder to program.  

		return ReadShapeFile.readDataFile(in);
	}
}