/**
 * FileReaderMain.java
 * @version 1.0.0
 * @author Annabel Kimber
 */
import java.util.*;

/**
 * This class that runs the FileReader class, and tests the 
 * methods created in the class.
 */


public class FileReaderMain {


	public static void main(String[] args){
		
		Scanner input = new Scanner (System.in);
		System.out.println ("Please enter a file to open:");
		String filename = input.next ();
		
		BST newBST = FileReader.readProfiles(filename);
		
		System.out.println(newBST.getRoot().getProfile().toString());
		System.out.println(newBST.getRoot().getLeft().getProfile().toString());
		System.out.println(newBST.getRoot().getRight().getProfile().toString());
		System.out.println(newBST.getRoot().getLeft().getLeft().getProfile().toString());

		
	}
}
