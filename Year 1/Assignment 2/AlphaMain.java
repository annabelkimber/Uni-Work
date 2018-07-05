/**
 * AlphaMain.java
 * 
 * @version 1.0.0
 * @author Annabel Kimber
 */

import java.util.Scanner;

/**This class that runs the printAlphabetical method. It prints
* the nodes from the binary tree in alphabetical order.
*/

public class AlphaMain {

	

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("Please enter a file to open:");
		String filename = input.next();

		BST newBST = FileReader.readProfiles(filename);		
		newBST.printAlphabetical();
		
	}
}
