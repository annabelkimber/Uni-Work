/**
 * Used by the binary search tree to store elements, from this node all child
 * nodes can be accessed from here because each node stores a left child node
 * and right child node. Each node will store a profile.
 * 
 * @author Alistair
 * @version 1.0
 */
public class BSTNode {
	
	private Profile data;
	private BSTNode left;
	private BSTNode right;
	
	public BSTNode(Profile data) {
		this.data = data;
	}
	
	public Profile getProfile() {
		return data;
	}
	
	public void setLeft(BSTNode l) {
		this.left = l;
	}
	
	public void setRight(BSTNode r) {
		this.right = r;
	}
	
	public BSTNode getLeft() {
		return left;
	}
	
	public BSTNode getRight() {
		return right;
	}
	
}
