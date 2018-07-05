/**
 * FileReader.java
 * 
 * @version 1.0.0
 * @author Annabel Kimber
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *This class reads in a file, and then uses that file to create
 *profiles that will then be stord in the binary search tree.
 */

public class FileReader {

	/**
	 * Creates a Profile
	 * 
	 * @param in Reads in the values of profile from the text file and assigns them to the Profile.
	 * @return Returns the newly created profile shape with the parameters from the text file.
	 */

	public static Profile ProfileExample(Scanner in) {

		in.useDelimiter(",");
		String name = in.next();
		int day = in.nextInt();	
		int month = in.nextInt();
		int year = in.nextInt();
		String town = in.next();
		String country = in.next();
		String nationality = in.next();
		ArrayList<String> interests = new ArrayList<String>();
		String interestAdd = in.nextLine();
		Scanner scanner2 = new Scanner (interestAdd);
		scanner2.useDelimiter(";");
		while(scanner2.hasNext()){
			interests.add(scanner2.next());
		}
		scanner2.close();
		Profile Profile1 = new Profile(name, day, month, year, town, country, nationality, interests);

		return Profile1;	
	}

	/**
	 * Method to read in the file and return a binary tree of the profiles in the file. The
	 * program should handle the file not find an exception here and shut down the
	 * program gracefully.
	 * 
	 * @param filename The name of the file
	 * @return The binary search tree of the profiles from the file
	 */

	public static BST readProfiles(String filename) {

		File inputFile = new File(filename);
		Scanner in = null;
		try { // Throwing an exception if no file is found.
			in = new Scanner(inputFile);
		} catch (FileNotFoundException e) {
			System.out.println("Cannot open" + " " + filename);
			System.exit(0);
		}
		return FileReader.readDataFile(in);
	}

	/**
	 * Reads the data file used by the program and returns the constructed binary search tree
	 * @param in the scanner of the file
	 * @return the binary search tree represented by the data file
	 */

	public static BST readDataFile(Scanner in) {
		BST newBST = new BST();

		/*A while loop to assign the values read in from the file to 
		the correct profile in the binary search tree.*/

		while (in.hasNextLine()) {
			newBST.insertProfile(FileReader.ProfileExample(in));
		}
		in.close();
		return newBST;
	}
}
