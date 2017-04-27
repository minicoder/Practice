package algorithmicExamples;

import java.util.Stack;

public class BinarySearchTree {
	// Root of BST
	TreeNode root;

	// Constructor
	BinarySearchTree() {
		root = null;
	}

	// This method mainly calls insertRec()
	public void insert(int key) {
		root = insertRec(root, key);
	}

	//Pre order: Node data, Left, Right
	public void preOrderRec(TreeNode root) {
		if(root !=  null) {
			//Visit the node-Printing the node data
			System.out.printf("%d ",root.val);
			preOrderRec(root.left);
			preOrderRec(root.right);
		}
	}

	// A utility function to do inorder traversal of BST
	//Left, Node, Right
	void inorderRec(TreeNode root) {
		if (root != null) {
			inorderRec(root.left);
			System.out.println(root.val);
			inorderRec(root.right);
		}
	}

	//Post Order: Left leaf, right leaf, Node data
	public void postOrder(TreeNode root) {
		if(root !=  null) {
			postOrder(root.left);
			postOrder(root.right);
			//Visit the node by Printing the node data
			System.out.printf("%d ", root.val);
		}
	}


	// Node, Left, Right
	public void preorderIter(TreeNode root) {
		if(root == null) return;

		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		while(!stack.empty()) {
			TreeNode n = stack.pop();
			System.out.printf("%d ",n.val);
			if(n.right != null){
				stack.push(n.right);
			}
			if(n.left != null){
				stack.push(n.left);
			}
		}
	}

	/* A recursive function to insert a new key in BST */
	TreeNode insertRec(TreeNode root, int key) {

        /* If the tree is empty, return a new node */
		if (root == null) {
			root = new TreeNode(key);
			return root;
		}

        /* Otherwise, recur down the tree */
		if (key < root.val)
			root.left = insertRec(root.left, key);
		else if (key > root.val)
			root.right = insertRec(root.right, key);

        /* return the (unchanged) node pointer */
		return root;
	}

	//search
	public TreeNode search(TreeNode root, int key) {
		// Base Cases: root is null or key is present at root
		if(root == null || root.val == key) {
			return root;
		}
		// val is greater than root's key
		if(root.val > key) {
			return search(root.left, key);
		}
		// val is less than root's key
		return search(root.right, key);
	}

	// This method mainly calls InorderRec()
	void inorder()  {
		inorderRec(root);
	}

	public static boolean isValidBST(TreeNode root) {
		return validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static boolean validate(TreeNode root, int min, int max) {
		if (root == null) {
			return true;
		}

		// not in range
		if (root.val <= min || root.val >= max) {
			return false;
		}

		// left subtree must be < root.val && right subtree must be > root.val
		return validate(root.left, min, root.val) && validate(root.right, root.val, max);
	}

	// Driver Program to test above functions
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();

        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		// print inorder traversal of the BST
		tree.inorder();
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
 
	public TreeNode(int x) {
		val = x;
		left = right = null;
	}
}
