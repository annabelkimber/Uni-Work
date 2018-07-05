/**
 * BST.java
 * 
 * @version 1.0.0
 * @author Annabel Kimber
 */

public class BST {

	/**
	 * This class creates a binary search tree using the nodes 
	 * from the BSTNode.java class.
	 */
	
	private BSTNode root; 

	/**
	 * Creates a BST.
	 */
	
	public BST() { 
	}
	
	/**
	 * If the root of the BST is empty, a new node is created, 
	 * else the method RProfile is executed.
	 */

	public void insertProfile(Profile p) {
		BSTNode newNode = new BSTNode(p);
		if (root == null) {
			root = newNode;
		} else {
			RProfile(root, newNode);
		}
	}

	/**
	 * If the current node is less than or equal to the new node
	 * and the left node is empty, set the current node to the 
	 * left node. Else get the left node profile and run the 
	 * method again, using this as the new node.
	 */

	
	private void RProfile(BSTNode current, BSTNode newNode) {
		if (current.getProfile().getName().compareTo(newNode.getProfile().getName()) <= 0) {
			if (current.getLeft() == null) {
				current.setLeft(newNode);
			} else {
				RProfile(current.getLeft(), newNode);
			}
		}

		/**
		 * If the current node is greater than the new node
		 * and the right node is empty, set the current node to the 
		 * right node. Else get the right node profile and run the 
		 * method again, using this as the new node.
		 */
		
		if (current.getProfile().getName().compareTo(newNode.getProfile().getName()) > 0) {
			if (current.getRight() == null) {
				current.setRight(newNode);
			} else {
				RProfile(current.getRight(), newNode);
			}
		}

	}
	
	/**
	 * @return root The root of the binary search tree
	 */
	
	public BSTNode getRoot() {
		return root;
	}

	/**
	  * @param  sets the root of the binary search tree.
	  */
	
	public void setRoot(BSTNode root) {
		this.root = root;
	}
	
	/**
	 * Method to print the names of the profile in
	 * alphabetical order.
	 */

	/**
	 * Printing the names of the profiles from the root
	 * everytime in alphabetical order.
	 */
	
	public void printAlphabetical() {
		inOrder(root);
	}

	/**
	 * Method to print the names of the profile in
	 * alphabetical order.
	 */
	
	public void inOrder(BSTNode n) {
		if (n.getLeft() != null) {
			inOrder(n.getLeft());
		}

		System.out.println(n.getProfile().getName());

		if (n.getRight() != null) {
			inOrder(n.getRight());
		}

	}

}