import java.util.Scanner;

/**
 * Used to test if the file reader works when loading the profiles from file.
 * 
 * @author Alistair
 * @version 1.0
 */
public class FileReaderMain {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter profiles file name: ");
		
		String fileName = in.nextLine();
		
		BST binarySearchTreeProfiles = FileReader.readProfiles(fileName);
	}
	
}
