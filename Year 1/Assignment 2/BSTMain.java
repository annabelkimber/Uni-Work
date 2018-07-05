/**
 * BSTMain.java
 * 
 * @version 1.0.0
 * @author Annabel Kimber
 */

import java.util.ArrayList;

/**
 * This class that runs the BST class, and tests the 
 * methods created in the class creating an instances
 * of the binary search tree.
 */

public class BSTMain {

	public static void main(String[] args) {

		ArrayList<String> InterestList1 = new ArrayList<String>();
		ArrayList<String> InterestList2 = new ArrayList<String>();
		ArrayList<String> InterestList3 = new ArrayList<String>();

		InterestList1.add("Football");
		InterestList1.add("Rugby");
		InterestList1.add("Reading");

		Profile profile1 = new Profile("Danielle", 30, 9, 1996, "Chester", "England", "English", InterestList1);

		InterestList2.add("Anime");
		InterestList2.add("Games");

		Profile profile2 = new Profile("Annabel", 05, 03, 1995, "Blaenavon", "Wales", "Welsh", InterestList2);

		InterestList3.add("Anime");
		InterestList3.add("Games");

		Profile profile3 = new Profile("Jeyhan", 07, 07, 199, "Windsor", "England", "English", InterestList3);

		BST BST1 = new BST();
		BST1.insertProfile(profile1);
		BST1.insertProfile(profile2);
		BST1.insertProfile(profile3);
		
		
		System.out.println(BST1.getRoot().getProfile().toString());
		System.out.println(BST1.getRoot().getLeft().getProfile().toString());
		System.out.println(BST1.getRoot().getRight().getProfile().toString());

	}

}


