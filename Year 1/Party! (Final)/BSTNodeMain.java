import java.util.ArrayList;

/**
 * Used to test if the BSTNode is referencing correctly.
 * 
 * @author Alistair
 * @version 1.0
 */
public class BSTNodeMain {
	
	public static void main(String[] args) {
		BSTNode rootNodeProfiles = createProfiles();
		
		/*
		 * Prints the nodes out simulating an in-order traversal
		 */
		System.out.println("At left child of left child of root node: ");
		System.out.println(rootNodeProfiles.getLeft().getLeft().getProfile().
				getDescription());
		System.out.println();
		
		System.out.println("At left child of root node: ");
		System.out.println(rootNodeProfiles.getLeft().getProfile().
				getDescription());
		System.out.println();
		
		System.out.println("At left child of right child of left child of "
				+ "root node: ");
		System.out.println(rootNodeProfiles.getLeft().getRight().getLeft().
				getProfile().getDescription());
		System.out.println();
		
		System.out.println("At left child of right child of left child of "
				+ "right child of left child of root node: ");
		System.out.println(rootNodeProfiles.getLeft().getRight().getLeft().
				getRight().getLeft().getProfile().getDescription());
		System.out.println();
		
		System.out.println("At right child of left child of right child of "
				+ "left child of root node: ");
		System.out.println(rootNodeProfiles.getLeft().getRight().getLeft().
				getRight().getProfile().getDescription());
		System.out.println();
		
		System.out.println("At right child of left child of root node: ");
		System.out.println(rootNodeProfiles.getLeft().getRight().getProfile().
				getDescription());
		System.out.println();
		
		System.out.println("At root node: ");
		System.out.println(rootNodeProfiles.getProfile().getDescription());
		System.out.println();
		
		System.out.println("At left child of left child of right child of "
				+ "root node: ");
		System.out.println(rootNodeProfiles.getRight().getLeft().getLeft().
				getProfile().getDescription());
		System.out.println();
		
		System.out.println("At left child of right child of root node: ");
		System.out.println(rootNodeProfiles.getRight().getLeft().getProfile().
				getDescription());
		System.out.println();
		
		System.out.println("At right child of root node: ");
		System.out.println(rootNodeProfiles.getRight().getProfile().
				getDescription());
		System.out.println();
		
		System.out.println("At left child of left child of right child of "
				+ "right child of root node: ");
		System.out.println(rootNodeProfiles.getRight().getRight().getLeft().
				getLeft().getProfile().getDescription());
		System.out.println();
		
		System.out.println("At left child of right child of right child of "
				+ "root node: ");
		System.out.println(rootNodeProfiles.getRight().getRight().getLeft().
				getProfile().getDescription());
		System.out.println();
		
		System.out.println("At right child of right child of root node: ");
		System.out.println(rootNodeProfiles.getRight().getRight().getProfile().
				getDescription());
		System.out.println();
	}
	
	/**
	 * @return a root node that contains a profile
	 * and has references to its children. All
	 * the nodes with their profiles that I have
	 * defined can be accessed from the root.
	 */
	public static BSTNode createProfiles() {
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
		
		/*
		 * Places the profiles in a way a binary search tree would
		 * do it if it was to be ordered alphabetically, where all
		 * left child nodes come before or is equal to the parent
		 * node and all right child nodes come after the parent node
		 */
		BSTNode rootNode = new BSTNode(profileJack);
		BSTNode rightNode = new BSTNode(profileLuke);
		BSTNode leftNode = new BSTNode(profileAlice);
		BSTNode rightRightNode = new BSTNode(profileSophie);
		BSTNode rightLeftNode = new BSTNode(profileKyle);
		BSTNode rightRightLeftNode = new BSTNode(profileOwen);
		BSTNode leftRightNode = new BSTNode(profileFlan);
		BSTNode rightLeftLeftNode = new BSTNode(profileJess);
		BSTNode leftLeftNode = new BSTNode(profileAlex);
		BSTNode rightRightLeftLeftNode = new BSTNode(profileMorgan);
		BSTNode leftRightLeftNode = new BSTNode(profileAllen);
		BSTNode leftRightLeftRightNode = new BSTNode(profileEmily);
		BSTNode leftRightLeftRightLeftNode = new BSTNode(profileCallum);
		
		rootNode.setLeft(leftNode);
		rootNode.getLeft().setLeft(leftLeftNode);
		rootNode.getLeft().setRight(leftRightNode);
		rootNode.getLeft().getRight().setLeft(leftRightLeftNode);
		rootNode.getLeft().getRight().getLeft().setRight(leftRightLeftRightNode);
		rootNode.getLeft().getRight().getLeft().getRight().
		setLeft(leftRightLeftRightLeftNode);
		rootNode.setRight(rightNode);
		rootNode.getRight().setLeft(rightLeftNode);
		rootNode.getRight().getLeft().setLeft(rightLeftLeftNode);
		rootNode.getRight().setRight(rightRightNode);
		rootNode.getRight().getRight().setLeft(rightRightLeftNode);
		rootNode.getRight().getRight().getLeft().setLeft(rightRightLeftLeftNode);
		
		return rootNode;
	}
	
}
