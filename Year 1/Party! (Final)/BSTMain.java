import java.util.ArrayList;

/**
 * Used to test if a binary search tree will insert elements in the
 * correct places.
 * 
 * @author Alistair
 * @version 1.0
 */
public class BSTMain {
	
	public static void main(String[] args) {
		BST binarySearchTreeProfiles = createProfiles();
	}
	
	/**
	 * @return a binary search tree of profiles that I have defined
	 */
	public static BST createProfiles() {
		ArrayList<String> interests = new ArrayList<String>();
		
		interests.add("Football");
		interests.add("Maths");
		interests.add("Mechanics");
		
		Profile profileJack = new Profile("Jack Lewis",
				new Date(20,6,2000),
				"Groves Hill",
				"Wales",
				"Welsh",
				interests);
		
		interests = new ArrayList<String>();
		
		interests.add("Reading");
		interests.add("Art");
		interests.add("Jogging");
		
		Profile profileLuke = new Profile("Luke Jones",
				new Date(7,2,2010),
				"Dove Lane",
				"England",
				"Spanish",
				interests);
		
		interests = new ArrayList<String>();
		
		interests.add("Origami");
		interests.add("Computer Graphics");
		
		Profile profileAlice = new Profile("Alice Mart",
				new Date(30,12,1998),
				"Red Forest",
				"England",
				"English",
				interests);
		
		interests = new ArrayList<String>();
		
		interests.add("Art");
		interests.add("Physics");
		interests.add("Basketball");
		interests.add("Football");
		
		Profile profileSophie = new Profile("Sophie Laurence",
				new Date(17,9,1995),
				"Rose Lake",
				"France",
				"French",
				interests);
		
		interests = new ArrayList<String>();
		
		interests.add("Jogging");
		interests.add("Swimming");
		interests.add("Geology");
		
		Profile profileKyle = new Profile("Kyle Davis",
				new Date(15,4,1975),
				"Tulip Central",
				"England",
				"Irish",
				interests);
		
		interests = new ArrayList<String>();
		
		interests.add("Tennis");
		interests.add("Sky Diving");
		interests.add("Computer Science");
		
		Profile profileOwen = new Profile("Owen Reese",
				new Date(13,7,1980),
				"Apple Road",
				"Wales",
				"Scottish",
				interests);
		
		interests = new ArrayList<String>();
		
		Profile profileFlan = new Profile("Flan Red",
				new Date(11,8,2002),
				"Base Lane",
				"England",
				"French",
				interests);
		
		interests = new ArrayList<String>();
		
		interests.add("Reading");
		interests.add("Chemistry");
		interests.add("Physics");
		interests.add("Biology");
		
		Profile profileJess = new Profile("Jess Howard",
				new Date(23,5,1999),
				"Grand Hill",
				"Wales",
				"Swedish",
				interests);
		
		interests = new ArrayList<String>();
		
		interests.add("Racing");
		interests.add("Gaming");
		
		Profile profileAlex = new Profile("Alex Crad",
				new Date(27,1,2003),
				"Ludchurch",
				"Wales",
				"Welsh",
				interests);
		
		interests = new ArrayList<String>();
		
		interests.add("Ice Skating");
		interests.add("Cycling");
		interests.add("Drama");
		
		Profile profileMorgan = new Profile("Morgan Hughes",
				new Date(1,3,1995),
				"Cardigan",
				"Wales",
				"Welsh",
				interests);
		
		interests = new ArrayList<String>();
		
		interests.add("Mechanics");
		interests.add("Physics");
		interests.add("Chemistry");
		
		Profile profileAllen = new Profile("Allen Jones",
				new Date(21,9,1988),
				"Blackwood",
				"Ireland",
				"German",
				interests);
		
		interests = new ArrayList<String>();
		
		interests.add("Gaming");
		interests.add("Basketball");
		interests.add("Geography");
		
		Profile profileEmily = new Profile("Emily Richards",
				new Date(28,5,1993),
				"Coatbridge",
				"Scotland",
				"English",
				interests);
		
		interests = new ArrayList<String>();
		
		interests.add("Jogging");
		interests.add("Gardening");
		
		Profile profileCallum = new Profile("Callum Laurence",
				new Date(13,8,1991),
				"Doncaster",
				"England",
				"Australian",
				interests);
		
		profileJack.addFriend(profileLuke);
		profileLuke.addFriend(profileJack);
		
		profileJack.addFriend(profileAlex);
		profileAlex.addFriend(profileJack);
		
		profileAlex.addFriend(profileAllen);
		profileAllen.addFriend(profileAlex);
		
		profileJack.addFriend(profileAlice);
		profileAlice.addFriend(profileJack);
		
		profileAlice.addFriend(profileSophie);
		profileSophie.addFriend(profileAlice);
		
		profileSophie.addFriend(profileKyle);
		profileKyle.addFriend(profileSophie);
		
		profileLuke.addFriend(profileJess);
		profileJess.addFriend(profileLuke);
		
		profileLuke.addFriend(profileMorgan);
		profileMorgan.addFriend(profileLuke);
		
		profileMorgan.addFriend(profileEmily);
		profileEmily.addFriend(profileMorgan);
		
		profileLuke.addFriend(profileAlex);
		profileAlex.addFriend(profileLuke);
		
		profileOwen.addFriend(profileFlan);
		profileFlan.addFriend(profileOwen);
		
		BST binarySearchTreeProfiles = new BST();
		
		binarySearchTreeProfiles.insertProfile(profileJack);
		binarySearchTreeProfiles.insertProfile(profileLuke);
		binarySearchTreeProfiles.insertProfile(profileAlice);
		binarySearchTreeProfiles.insertProfile(profileSophie);
		binarySearchTreeProfiles.insertProfile(profileKyle);
		binarySearchTreeProfiles.insertProfile(profileOwen);
		binarySearchTreeProfiles.insertProfile(profileFlan);
		binarySearchTreeProfiles.insertProfile(profileJess);
		binarySearchTreeProfiles.insertProfile(profileAlex);
		binarySearchTreeProfiles.insertProfile(profileMorgan);
		binarySearchTreeProfiles.insertProfile(profileAllen);
		binarySearchTreeProfiles.insertProfile(profileEmily);
		binarySearchTreeProfiles.insertProfile(profileCallum);
		
		return binarySearchTreeProfiles;
	}
	
}
