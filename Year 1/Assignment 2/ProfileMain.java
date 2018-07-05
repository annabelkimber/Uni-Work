/**
 * @version 1.0.0
 * @author Annabel Kimber
 */

import java.util.*;

/**
 * This class that runs the profile class, and tests the 
 * methods created in the class creating instances of 
 * the profiles.
 */

public class ProfileMain {

	public static void main(String[] args) {

		ArrayList<String> InterestList1 = new ArrayList<String>();
		ArrayList<String> InterestList2 = new ArrayList<String>();
		ArrayList<String> InterestList3 = new ArrayList<String>();

		InterestList1.add("Football");
		InterestList1.add("Rugby");
		InterestList1.add("Reading");

		Profile profile1 = new Profile("Annabel", 30, 9, 1996, "Chester", "England", "English", InterestList1);

		InterestList2.add("Anime");
		InterestList2.add("Games");

		Profile profile2 = new Profile("Annabel", 5, 03, 1995, "Blaenavon", "Wales", "Welsh", InterestList2);

		InterestList3.add("Anime");
		InterestList3.add("Games");

		Profile profile3 = new Profile("Jeyhan", 7, 7, 199, "Windsor", "England", "English", InterestList3);

		System.out.println(profile1.toString());
		System.out.println(profile2.toString());
		System.out.println(profile3.toString());
		
	}

}
