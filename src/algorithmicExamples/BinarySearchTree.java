package algorithmicExamples;

import java.util.ArrayList;
import java.util.Stack;

public class BinarySearchTree {
	// Root of BST
	TreeNode root;

	// Constructor
	BinarySearchTree() {
		root = null;
	}

	/**
	 * Given a binary tree, give the length of the longest path between two leaf nodes
	 Don't travel on the same path twice
	 example 1.

	 10
	 /\
	 5   7
	 /\   \
	 3 4   8
	 \
	 6
	 longest path 6->4->5->10->7->8
	 Answer 5
	 * @return
	 */
	public static int diameter(TreeNode root) {
		if(root != null) {
			System.out.println("Root: "+root.val);
			int leftH = getHeight(root.left);
			System.out.println("Left Height: "+leftH);
			int rightH = getHeight(root.right);
			System.out.println("Right Height: "+rightH);

			int leftDiameter = diameter(root.left);
			System.out.println("Left Diameter for Left node: "+root.val+": "+leftDiameter);
			int rightDiameter = diameter(root.right);
			System.out.println("Right Diameter for Right node: "+root.val+": "+rightDiameter);

			System.out.println("\n");

			return getMax(leftH + rightH + 1, leftDiameter, rightDiameter);
		}
		return 0;
	}

	public static int getHeight(TreeNode root) {
		if(root != null) {
			return 1 + Math.max(getHeight(root.left), getHeight(root.right));
		}
		return 0;
	}

	public static int getMax(int a, int b, int c) {
		return Math.max(a, Math.max(b, c));
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
	public ArrayList<Integer> preorderIterative(TreeNode A) {
		if(A == null) return new ArrayList<>();
		ArrayList<Integer> result = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		stack.push(A);

		while(!stack.empty()){
			TreeNode n = stack.pop();
			result.add(n.val);

			if(n.right != null){
				stack.push(n.right);
			}
			if(n.left != null){
				stack.push(n.left);
			}

		}
		return result;
	}

	//Left, Node, Right
	public ArrayList<Integer> inorderIterative(TreeNode A) {
		ArrayList<Integer> result = new ArrayList<>();
		if(A == null) return new ArrayList<>();
		TreeNode p = A;

		Stack<TreeNode> stack = new Stack<>();

		while(!stack.empty() || p != null) {
			// if it is not null, push to stack
			//and go down the tree to left
			if(p != null) {
				stack.push(p);
				p = p.left;
			} else {
				// if no left child
				// pop stack, process the node
				// then let p point to the right
				TreeNode n = stack.pop();
				result.add(n.val);
				p = n.right;
			}
		}
		return result;
	}

	//  Left, Right, Node
	public ArrayList<Integer> postorderIterative(TreeNode A) {
		if(A == null) return new ArrayList<>();
		ArrayList<Integer> result = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		stack.push(A);

		while(!stack.empty()){
			TreeNode n = stack.peek(); //doesnot remove element
			if(n.left == null && n.right == null) {
				TreeNode pop = stack.pop();
				result.add(pop.val);
			} else {
				if (n.right != null) {
					stack.push(n.right);
					n.right = null;
				}
				if (n.left != null) {
					stack.push(n.left);
					n.left = null;
				}
			}
		}
		return result;
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
//		tree.insert(50);
//		tree.insert(30);
//		tree.insert(20);
//		tree.insert(40);
//		tree.insert(70);
//		tree.insert(60);
//		tree.insert(80);

		tree.insert(15);
		tree.insert(10);
		tree.insert(20);
		tree.insert(25);

		// print inorder traversal of the BST
		//tree.inorder();
		System.out.println("Inorder traversal iterative: "+tree.inorderIterative(tree.root));
		System.out.println("Preorder traversal iterative: "+tree.preorderIterative(tree.root));
		System.out.println("Postorder traversal iterative: "+tree.postorderIterative(tree.root));

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		root.left.right.left = new TreeNode(6);
		root.left.right.left.right = new TreeNode(7);
		root.left.left.left = new TreeNode(8);

		System.out.println("Diameter of Tree: " + diameter(root));
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
