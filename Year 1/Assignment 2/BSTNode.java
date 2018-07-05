/**
 * BSTNode.java
 * 
 * @version 1.0.0
 * @author Annabel Kimber
 */

/**
 * This class creates nodes that will be used in the BST.java 
 * class when creating the binary search tree.
 *
 */

public class BSTNode {
	
	
	private Profile data;
	private BSTNode left;
	private BSTNode right;

	/**
	 * Creates a binary search tree node
	 * @param data
	 */
	
	public BSTNode(Profile data) {
		this.data = data;
	}

	/**
	 * @return data 
	 */
	
	public Profile getProfile() {
		return data;
	}
	
	/**
	  * @param l Sets the left child to l.
	  */

	public void setLeft(BSTNode l) {
		this.left = l;
	}

	/**
	  * @param R Sets the right child to r.
	  */
	
	public void setRight(BSTNode r) {
		this.right = r;
	}
	
	/**
	 * @return The left node.
	 */

	public BSTNode getLeft() {
		return left;
	}

	/**
	 * @return The right node
	 */
	
	public BSTNode getRight() {
		return right;
	}

}
