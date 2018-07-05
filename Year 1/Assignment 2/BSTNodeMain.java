/**
 * BSTNodeMain.java
 * 
 * @version 1.0.0
 * @author Annabel Kimber
 */

import java.util.ArrayList;

/**
 * The class that runs the BSTNode class, and tests the 
 * methods created in the class, creating instances of 
 * the nodes which will be used in the BST.java class.
 */

public class BSTNodeMain {

	public static void main(String[] args) {

		ArrayList<String> InterestList1 = new ArrayList<String>();

		InterestList1.add("Football");
		InterestList1.add("Rugby");
		InterestList1.add("Reading");

		Profile profile1 = new Profile("Danielle", 30, 9, 1996, "Chester", "England", "English", InterestList1);

		ArrayList<String> InterestList2 = new ArrayList<String>();

		
		InterestList2.add("Anime");
		InterestList2.add("Games");

		Profile profile2 = new Profile("Annabel", 05, 03, 1995, "Blaenavon", "Wales", "Welsh", InterestList2);

		ArrayList<String> InterestList3 = new ArrayList<String>();

		
		InterestList3.add("Anime");
		InterestList3.add("Games");

		Profile profile3 = new Profile("Jeyhan", 07, 07, 199, "Windsor", "England", "English", InterestList3);

		BSTNode BSTNode1 = new BSTNode(profile1);
		

		System.out.println(BSTNode1.getProfile());
		System.out.println(BSTNode1.getLeft());
		System.out.println(BSTNode1.getRight());

	}

}
