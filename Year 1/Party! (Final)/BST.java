import java.util.ArrayList;

/**
 * Used as a binary search tree, allows profiles to be inserted as elements
 * of the binary search tree, elements that are inserted are placed in such
 * a way where the binary tree is alphabetically ordered so that an in-order
 * traversal should visit each node in alphabetical order.
 * 
 * @author Alistair
 * @version 1.0
 */
public class BST {
	/*
	 * This exception is thrown when it is not possible for a
	 * method to access the elements of the binary search tree
	 * because the tree is empty
	 */
	private static final IllegalStateException EMPTY_BINARY_TREE_ERROR =
			new IllegalStateException("The binary search tree is empty.");
	
	private BSTNode root;
	
	public BST() {
		
	}
	
	/**
	 * Recursive method which will insert a given profile
	 * into the binary tree in the right place, where all
	 * left child nodes have a profile name that is before
	 * or the same as their parent node's profile name,
	 * and all right child nodes have a profile name that
	 * is after their parent node's profile name.
	 * 
	 * @param profile The profile to be inserted
	 * 
	 * @param currentNode The current node the recursive
	 * method is looking at.
	 */
	private static void insertProfileAlphabetically(Profile profile,
			BSTNode currentNode) {
		
		String givenProfileName = profile.getName();
		String currentNodeProfileName = currentNode.getProfile().getName();
		
		/*
		 * compareTo will return a negative number if the given profile
		 * name comes before the current node profile name, 0 if the
		 * given profile name is equal to the current node profile name,
		 * and a positive number if the given profile name comes after
		 * the current node profile name.
		 * 
		 * Here we want the node to go to the left child node if the
		 * given profile name comes before or is equal to the current
		 * node profile name, otherwise it should go to the right
		 * child node.
		 */
		if(givenProfileName.compareTo(currentNodeProfileName) <= 0) {
			BSTNode leftNode = currentNode.getLeft();
			
			/*
			 * Base case of if the new node is to be heading towards
			 * the left child node and the left child node is null,
			 * it should create a new node at the left child node.
			 */
			if(leftNode == null) {
				currentNode.setLeft(new BSTNode(profile));
				
				System.out.println("Node with profile name \"" + profile.getName() +
						"\" has been placed as a left child of parent node with " +
						"profile name \"" + currentNode.getProfile().getName() +
						"\"");
			} else {
				/*
				 * Inductive step if the new node is to be heading
				 * towards the left child node, and the left child
				 * node is not null, it should call this method
				 * again with the left child node.
				 */
				insertProfileAlphabetically(profile, leftNode);
			}
		} else {
			BSTNode rightNode = currentNode.getRight();
			
			/*
			 * Base case of if the new node is to be heading towards
			 * the right child node, and the right child node is null
			 * it should create a new node at the right child node.
			 */
			if(rightNode == null) {
				currentNode.setRight(new BSTNode(profile));
				
				System.out.println("Node with profile name \"" + profile.getName() +
						"\" has been placed as a right child of parent node with " +
						"profile name \"" + currentNode.getProfile().getName() +
						"\"");
			} else {
				/*
				 * Inductive step if the new node is to be heading
				 * towards the right child node, and the right child
				 * node is not null, it should call this method again
				 * with the right child node.
				 */
				insertProfileAlphabetically(profile, rightNode);
			}
		}
	}
	
	/**
	 * This recursive method will make an in-ordered traversal
	 * possible by calling this method again for the left child
	 * node first (if it exists) and then visiting this node,
	 * and then call this method for the right child node
	 * (if it exists).
	 * 
	 * When a node is visited the profile name of the node is
	 * printed.
	 * 
	 * @param currentNode The current node that needs to do an
	 * in-ordered traversal.
	 */
	private static void printFromNodeAlphabeticalUsingInOrder(BSTNode currentNode) {
		BSTNode leftNode = currentNode.getLeft();
		BSTNode rightNode = currentNode.getRight();
		
		/*
		 * Base case is where the left child node and right child node are null,
		 * otherwise if either or both the left child node and right child
		 * node are not null, its an inductive step.
		 */
		if(leftNode != null) {
			printFromNodeAlphabeticalUsingInOrder(leftNode);
		}
		
		//When the current node is visited, print its profile name
		System.out.println(currentNode.getProfile().getName());
		
		if(rightNode != null) {
			printFromNodeAlphabeticalUsingInOrder(rightNode);
		}
	}
	
	/**
	 * This recursive method will make an in-ordered traversal
	 * possible by calling this method again for the left child
	 * node first (if it exists) and then visiting this node,
	 * and then call this method for the right child node
	 * (if it exists).
	 * 
	 * When a node is visited the node is added onto an array list.
	 * 
	 * @param currentNode The current node that needs to do an
	 * in-ordered traversal.
	 * 
	 * @return An array list consisting of each of the children node's profile
	 * and the given node's profile.
	 */
	private static ArrayList<Profile> getContentsAsArrayListUsingInOrder(
			BSTNode currentNode) {
		
		/*
		 * The array list of profiles is used to collect the profiles of
		 * this node and its children
		 */
		ArrayList<Profile> profiles;
		
		BSTNode leftNode = currentNode.getLeft();
		BSTNode rightNode = currentNode.getRight();
		
		/*
		 * Base case is where the left child node and right child node are null,
		 * otherwise if either or both the left child node and right child
		 * node are not null, its an inductive step.
		 */
		
		/*
		 * If the left child node is null, create a new array list of profiles,
		 * otherwise get the array list of profiles from the recursive call to
		 * the left child node
		 */
		if(leftNode == null) {
			profiles = new ArrayList<Profile>();
		} else {
			profiles = getContentsAsArrayListUsingInOrder(leftNode);
		}
		
		//When the current node is visited, add its profile to the array list
		profiles.add(currentNode.getProfile());
		
		/*
		 * If the right child node is not null, get the array list of
		 * profiles from the recursive call to the right child node, merge
		 * the two array lists together by adding all contents from the
		 * right child node's array list of profiles to the profiles array
		 * list that is to be returned.
		 */
		if(rightNode != null) {
			ArrayList<Profile> rightProfiles =
					getContentsAsArrayListUsingInOrder(rightNode);
			
			for(Profile profile : rightProfiles) {
				profiles.add(profile);
			}
		}
		
		return profiles;
	}
	
	/**
	 * This recursive method will do a binary search to find the profile
	 * with the name specified, if the given name comes before the current
	 * node's profile name, this method is recursively called on the left
	 * node, if the given name comes after the current node's profile name,
	 * this method is recursively called on the right node, otherwise if the
	 * given name is equal to the current node's profile name, the profile
	 * has been found and is returned.
	 * 
	 * @param currentNode The current node that is being searched.
	 * 
	 * @param profileName The name of the profile that the method
	 * is searching for.
	 * 
	 * @return The profile with the given name, an IllegalArgumentException is
	 * thrown if the method fails to find the profile.
	 */
	private static Profile binarySearchProfileNameFromCurrentNode(BSTNode currentNode,
			String profileName) throws IllegalArgumentException {
		
		if(currentNode != null) {
			String currentNodeProfileName = currentNode.getProfile().getName();
			
			int compareToResult = profileName.compareTo(currentNodeProfileName);
			
			/*
			 * Inductive step is where the given profile name either comes
			 * before or after the current node's profile name.
			 * 
			 * A recursive call to the left node is made if the compare
			 * result is a negative number smaller than 0 meaning that
			 * the given profile name comes before the current node's
			 * profile name.
			 * 
			 * A recursive call to the right node is made if the compare
			 * result is a positive number larger than 0 meaning that
			 * the given profile name comes after the current node's
			 * profile name.
			 * 
			 * Base case is where the compare result is 0, meaning that the
			 * given profile name is equal to the current node's profile name,
			 * the current node's profile is returned when this happens.
			 */
			if(compareToResult < 0) {
				return binarySearchProfileNameFromCurrentNode(currentNode.getLeft(),
						profileName);
			} else if(compareToResult > 0) {
				return binarySearchProfileNameFromCurrentNode(currentNode.getRight(),
						profileName);
			} else {
				return currentNode.getProfile();
			}
		}
		
		throw new IllegalArgumentException("There is no profile with name \"" +
		profileName + "\" that exists");
	}
	
	/**
	 * Checks if the root is null to see if the binary search tree is empty.
	 * 
	 * @return true if the binary search tree is empty.
	 */
	public boolean isEmpty() {
		return (root == null);
	}
	
	/**
	 * Insert the given profile into the binary tree,
	 * the profile is added where the binary tree remains
	 * to be alphabetically ordered, where left child nodes
	 * have a profile name that is before or the same as
	 * their parent node's profile name and right child nodes
	 * have a profile name that is after their parent node's
	 * profile name.
	 * 
	 * @param profile The profile to be inserted
	 */
	public void insertProfile(Profile profile) {
		//If the binary search tree is empty, insert profile at root node.
		if(isEmpty()) {
			root = new BSTNode(profile);
			
			System.out.println("Node with profile name \"" + profile.getName() +
					"\" has been placed as the root node");
		} else {
			insertProfileAlphabetically(profile, root);
		}
	}
	
	/**
	 * This method prints all elements of the tree alphabetically
	 * using in-order traversal.
	 */
	public void printAlphabetical() throws IllegalStateException {
		/*
		 * If the binary search tree is empty there would be nothing
		 * to print and so an error is thrown
		 */
		if(isEmpty()) {
			throw EMPTY_BINARY_TREE_ERROR;
		} else {
			printFromNodeAlphabeticalUsingInOrder(root);
		}
	}
	
	/**
	 * This method gets all the elements of the tree
	 * as an array list using in-order traversal, this
	 * means that all profiles will also be ordered in
	 * the array list alphabetically by name.
	 * 
	 * @return An array list consisting of each of the children node's profile
	 * and the root profile.
	 */
	public ArrayList<Profile> getContentsAsArrayList() throws IllegalStateException {
		/*
		 * If the binary search tree is empty there would be nothing
		 * to add to the array list and so an error is thrown
		 */
		if(isEmpty()) {
			throw EMPTY_BINARY_TREE_ERROR;
		} else {
			ArrayList<Profile> profiles = getContentsAsArrayListUsingInOrder(root);
			
			return profiles;
		}
	}
	
	/**
	 * This method will call a recursive method to attempt to search
	 * for the profile with the given profile name.
	 * 
	 * @param profileName The name that is used to search for a profile
	 * with that name.
	 * 
	 * @return The profile that has the name specified.
	 */
	public Profile binarySearchProfileName(String profileName) throws
	IllegalStateException, IllegalArgumentException {
		
		/*
		 * If the binary search tree is empty there would be nothing
		 * to search and so an error is thrown
		 */
		if(isEmpty()) {
			throw EMPTY_BINARY_TREE_ERROR;
		} else {
			Profile profile = binarySearchProfileNameFromCurrentNode(
					root, profileName);
			
			return profile;
		}
	}
}
