import java.io.File;
import java.util.Scanner;

/**
 * Used to test the graph and its methods.
 * 
 * Gets the user to input the profiles file name and to input the
 * edges file name, once this is done the binary search tree can
 * be constructed with all the profiles loaded as its elements,
 * the graph can also be constructed from the edges file and the
 * new binary search tree, this allows to add friends as defined
 * in the edge file to each of the profile's friends list.
 * 
 * The user can then enter a name for the host profile, the binary
 * search tree searches for this host profile from the given name,
 * the method maxGuestList is called with the host's profile to get
 * the binary search tree of all the possible guests.
 * 
 * The binary search tree is then printed alphabetically.
 * 
 * @author Alistair
 * @version 1.0
 */
public class GraphMain {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter profiles file name: ");
		
		String fileName = in.nextLine();
		
		/*
		 * Make a binary search tree with the profiles loaded from the
		 * file with the given file name
		 */
		BST binarySearchTreeProfiles = FileReader.readProfiles(fileName);
		
		System.out.print("Enter edge list file name: ");
		
		fileName = in.nextLine();
		File friendsFile = new File(fileName);
		
		/*
		 * Make a new graph using the given friends file and binary search tree.
		 * 
		 * This adds friends that are defined in the friends file to be added to
		 * each of the profile's friends list.
		 */
		Graph graphProfiles = new Graph(friendsFile, binarySearchTreeProfiles);
		
		System.out.print("Enter name of host: ");
		String hostName = in.nextLine();
		
		Profile host = null;
		
		try {
			/*
			 * Find the host's profile from the host's name by doing a
			 * binary search
			 */
			host = binarySearchTreeProfiles.binarySearchProfileName(hostName);
		} catch(IllegalStateException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		
		System.out.println("Host of party is: " + host.getName());
		
		//Get the maximum number of guests as a binary search tree
		BST binarySearchTreeGuests = Graph.maxGuestList(host);
		
		System.out.println("Max guest list includes: ");
		binarySearchTreeGuests.printAlphabetical();
	}
	
}
