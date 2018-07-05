
/**
 * The class that starts the program.  The class simply creates a window and displays it given
 * a filename submitted from the command line.
 * @author archam
 *
 */

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner (System.in);
		
		System.out.println ("Please enter a shape file to open:");
		String filename = input.next ();
		
		BouncingShapesWindow window = new BouncingShapesWindow (filename);
		window.setVisible(true);
		input.close ();
		
	}
}