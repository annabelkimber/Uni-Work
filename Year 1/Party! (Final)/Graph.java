import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Graph class where each profile is accessed through the nodes array list,
 * each of the edges are accessed through each profile, the edges for each
 * profile is the list of friends of that profile.
 * 
 * @author Alistair
 * @version 1.0
 */
public class Graph {
	
	private ArrayList<Profile> nodes = new ArrayList<Profile>();
	
	/**
	 * Constructs a new graph using a given file and a reference
	 * to an existing binary search tree of profiles.
	 * 
	 * The file is used for reading and creating relations between
	 * profiles, the binary search tree is used to create a list of
	 * nodes for searching for profiles so that relations can be made.
	 * 
	 * @param edgeList The file that contains data of where edges
	 * exist.
	 * 
	 * @param binarySearchTreeProfiles The already populated binary
	 * search tree that consists of all the existing profiles.
	 */
	public Graph(File edgeList, BST binarySearchTreeProfiles) {
		
		try {
			nodes = binarySearchTreeProfiles.getContentsAsArrayList();
		} catch (IllegalStateException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		
		FileReader.readEdges(edgeList, nodes);
	}
	
	/**
	 * Method will return a binary search tree of all guests that
	 * could potentially be invited into a party, where the host
	 * would invite friends and each of the friend's friends.
	 * 
	 * @param host The profile of the host of the party.
	 * 
	 * @return The binary search tree of guests that could potentially
	 * be invited into a party.
	 */
	public static BST maxGuestList(Profile host) {
		/*
		 * depth of friends is 2 because we want to get the friends and
		 * each of the friend's friends.
		 */
		BST binarySearchTreeGuests = addFriendsToBST(host, 2);
		
		return binarySearchTreeGuests;
	}
	
	/**
	 * Method that will get a hash set of friends and will insert
	 * each of the friend's profiles into a newly created binary
	 * search tree, note that the current profile is also included
	 * as a friend.
	 * 
	 * @param currentProfile The profile that is used to get the friends
	 * of this profile.
	 * 
	 * @param depthOfFriends The amount of recursions that can be made to get
	 * all friends of the current profile, friends using 1 edge (depth of 1),
	 * friends using 2 edges (depth of 2), ..., friends using n edges (depth
	 * of n).
	 * 
	 * @return The binary search tree of friends.
	 */
	public static BST addFriendsToBST(Profile currentProfile, int depthOfFriends) {
		HashSet<Profile> friendsHashSet = addFriendsToHashSet(currentProfile,
				depthOfFriends);
		
		BST friendsBinarySearchTree = new BST();
		
		/*
		 * Insert each of the friend's profile from the hash set into the
		 * binary search tree.
		 */
		for(Profile friend : friendsHashSet) {
			friendsBinarySearchTree.insertProfile(friend);
		}
		
		return friendsBinarySearchTree;
	}
	
	/**
	 * Recursive method where the current profile is added onto a newly
	 * created friends array list, if the depth of friends is bigger
	 * than 0, then there is another edge that can be used to get the
	 * friends of the current profile, this is done by calling this
	 * method on all friends of the current profile, the depth of friends
	 * is subtracted by 1 when passed for a parameter input because an
	 * edge has been used.
	 * 
	 * @param currentProfile The profile that is using the recursive
	 * method to get the profile's friends.
	 * 
	 * @param depthOfFriends The amount of recursions that can be made to get
	 * all friends of the current profile, friends using 1 edge (depth of 1),
	 * friends using 2 edges (depth of 2), ..., friends using n edges (depth
	 * of n).
	 * 
	 * @return An array list of friends.
	 */
	public static HashSet<Profile> addFriendsToHashSet(Profile currentProfile,
			int depthOfFriends) {
		
		/*
		 * Used to get the friends of the current profile including the
		 * current profile itself as a friend.
		 */
		HashSet<Profile> friendsArrayList = new HashSet<Profile>();
		
		friendsArrayList.add(currentProfile);
		
		/*
		 * The base case is where the depth of friends is 0.
		 * 
		 * The inductive step is where the depth of friends is larger than 0.
		 */
		if(depthOfFriends > 0) {
			int amountOfFriends = currentProfile.getAmountOfFriends();
			
			/*
			 * For every friend of the current profile, get the friend's hash
			 * set of friends (get each of the friend's friends), and add the
			 * contents to the hash set of the current profile.
			 */
			for(int i = 0; i < amountOfFriends; i++) {
				//The friend's hash set of friends
				HashSet<Profile> friendsFriends =
						addFriendsToHashSet(currentProfile.getFriend(i),
								depthOfFriends-1);
				
				for(Profile friend : friendsFriends) {
					friendsArrayList.add(friend);
				}
			}
		}
		
		return friendsArrayList;
	}
}
