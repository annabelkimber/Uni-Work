/**
 * Used to test if a given binary tree will print out each profile's
 * name in alphabetical order.
 * 
 * @author Alistair
 * @version 1.0
 */
public class AlphaMain {
	
	public static void main(String[] args) {
		BST binarySearchTreeProfiles = BSTMain.createProfiles();
		
		try {
			binarySearchTreeProfiles.printAlphabetical();
		} catch(IllegalStateException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}
	
}
