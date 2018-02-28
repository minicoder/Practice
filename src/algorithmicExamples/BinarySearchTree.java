package algorithmicExamples;

import java.util.*;

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

			System.out.println("Root: "+root.data);
			int leftH = getHeight(root.left);
			System.out.println("Left Height: "+leftH);
			int rightH = getHeight(root.right);
			System.out.println("Right Height: "+rightH);

			int leftDiameter = diameter(root.left);
			System.out.println("Left Diameter for Left node: "+root.data +": "+leftDiameter);
			int rightDiameter = diameter(root.right);
			System.out.println("Right Diameter for Right node: "+root.data +": "+rightDiameter);

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
			System.out.printf("%d ", root.data);
			preOrderRec(root.left);
			preOrderRec(root.right);
		}
	}

	// A utility function to do inorder traversal of BST
	//Left, Node, Right
	void inorderRec(TreeNode root) {
		if (root != null) {
			inorderRec(root.left);
			System.out.println(root.data);
			inorderRec(root.right);
		}
	}

	//Post Order: Left leaf, right leaf, Node data
	public void postOrder(TreeNode root) {
		if(root !=  null) {
			postOrder(root.left);
			postOrder(root.right);
			//Visit the node by Printing the node data
			System.out.printf("%d ", root.data);
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
			result.add(n.data);

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
	//Time: O(n), Space: O(log n)
	//Stack: LIFO
	public ArrayList<Integer> inorderIterative(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<>();
		if(root == null) return new ArrayList<>();

		Stack<TreeNode> stack = new Stack<>();

		while(true) {
			while(root != null) {
				stack.push(root);//Add root
				root = root.left; //Add left nodes
			}
			if(stack.empty()) break;
			root = stack.pop(); //pop back left and root.
			result.add(root.data);
			root = root.right;//add all right nodes
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
				result.add(pop.data);
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

	public void levelOrderTraversal(TreeNode root) {
		if(root == null) return;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode current = queue.poll();
			System.out.println("Value: " + current.data);
			if(current.left != null)
				queue.add(current.left);
			if(current.right != null)
				queue.add(current.right);
		}
	}

	/**
	 * Space : O(n)
	 * Time : O(n)
	 */
	public ArrayList<Integer> levelorder(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<>();
		if(root == null) return result;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode curr = queue.poll();
			result.add(curr.data);
			if(curr.left != null)
				queue.add(curr.left);
			if(curr.right != null)
				queue.add(curr.right);
		}
		return result;
	}

	/* A recursive function to insert a new key in BST */
	//Space: O(log n), Time: O(log n)
	TreeNode insertRec(TreeNode root, int key) {

        /* If the tree is empty, return a new node */
		if (root == null) {
			root = new TreeNode(key);
			return root;
		}

        /* Otherwise, recur down the tree */
		if (key < root.data)
			root.left = insertRec(root.left, key);
		else if (key > root.data)
			root.right = insertRec(root.right, key);

        /* return the (unchanged) node pointer */
		return root;
	}

	//search
	public TreeNode search(TreeNode root, int key) {
		// Base Cases: root is null or key is present at root
		if(root == null || root.data == key) {
			return root;
		}
		// data is greater than root's key
		if(root.data > key) {
			return search(root.left, key);
		}
		// data is less than root's key
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
		if (root.data <= min || root.data >= max) {
			return false;
		}

		// left subtree must be < root.data && right subtree must be > root.data
		return validate(root.left, min, root.data) && validate(root.right, root.data, max);
	}

	public static boolean validateBSTItrEfficient(TreeNode root) {

		class TreeBoundaryNode{
			TreeNode treeNode;
			int leftBoundary;
			int rightBoundary;
			TreeBoundaryNode(TreeNode treeNode, int leftBoundary, int rightBoundary) {
				this.treeNode = treeNode;
				this.leftBoundary = leftBoundary;
				this.rightBoundary = rightBoundary;
			}
		}

		if(root == null || (root.left == null && root.right == null)) return true;

		Queue<TreeBoundaryNode> q = new LinkedList<>();
		q.add(new TreeBoundaryNode(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
		while(!q.isEmpty()){
			TreeBoundaryNode tbNode = q.poll();
			TreeNode t = tbNode.treeNode;
			if((t.data <= tbNode.leftBoundary) || (t.data >= tbNode.rightBoundary)) return false;
			if(t.left != null){
				q.add(new TreeBoundaryNode(t.left, tbNode.leftBoundary, t.data));
			}
			if(t.right != null){
				q.add(new TreeBoundaryNode(t.right, t.data, tbNode.rightBoundary));
			}
		}

		return true;
	}

	//Space: O(n), Time: O(n)
	public static boolean validateBSTItr(TreeNode root) {
		if(root == null) return true;
		Queue<TreeNode> leftSubTreeQueue = new LinkedList<>();
		Queue<TreeNode> rightSubTreeQueue = new LinkedList<>();
		Queue<TreeNode> leftQueue = new LinkedList<>();
		Queue<TreeNode> rightQueue = new LinkedList<>();
		if(root.left != null)
			leftSubTreeQueue.add(root.left);

		if(root.right != null)
			rightSubTreeQueue.add(root.right);

		while(!leftSubTreeQueue.isEmpty()) {
			TreeNode current = leftSubTreeQueue.poll();
			if(current.data > root.data) return false;
			if(current.left != null)
				leftQueue.add(current.left);
			while(!leftQueue.isEmpty()) {
				TreeNode subLeftChild = leftQueue.poll();
				if(subLeftChild.data > current.data || subLeftChild.data > root.data) return false;
				if(subLeftChild.left != null)
					leftQueue.add(subLeftChild.left);
			}

			if(current.right != null)
				rightQueue.add(current.right);
			while(!rightQueue.isEmpty()) {
				TreeNode subRightChild = rightQueue.poll();
				if(subRightChild.data <= current.data || subRightChild.data > root.data) return false;
				if(subRightChild.right != null)
					rightQueue.add(subRightChild.right);
			}

		}

		leftQueue = new LinkedList<>(); rightQueue = new LinkedList<>();

		while(!rightSubTreeQueue.isEmpty()) {
			TreeNode current = rightSubTreeQueue.poll();
			if(current.data < root.data) return false;
			if(current.left != null)
				leftQueue.add(current.left);
			while(!leftQueue.isEmpty()) {
				TreeNode subLeftChild = leftQueue.poll();
				if(subLeftChild.data > current.data || subLeftChild.data > root.data) return false;
				if(subLeftChild.left != null)
					leftQueue.add(subLeftChild.left);
			}

			if(current.right != null)
				rightQueue.add(current.right);
			while(!rightQueue.isEmpty()) {
				TreeNode subRightChild = rightQueue.poll();
				if(subRightChild.data <= current.data || subRightChild.data > root.data) return false;
				if(subRightChild.right != null)
					leftQueue.add(subRightChild.right);
			}

		}
		return true;
	}

	//Space: O(log n) Time: O(log n)
	public TreeNode findMax(TreeNode root) {
		if(root == null) return null;
		if(root.right == null) return root;
		return findMax(root.right);
	}

	public TreeNode findMin(TreeNode root) {
		if(root == null) return null;
		if(root.left == null) return root;
		return findMin(root.left);
	}

	/**
	 * Given a
	 binary search tree
	 and an integer k, implement a method to find and return the kth smallest node.
	 Example:
	  4
	 / \
	 2  8
	 /  \
	 5  10

	 K = 2, Output = 4

	 Time: O(n)
	 Space : O(logn)
	 */
	public TreeNode findKthSmallest(TreeNode root, int k) {
		if(root == null) return null;

		int lSize = 0;
		if(root.left != null)
			lSize = findSize(root.left);

		if(lSize+1 == k) return root;
		else if(k <= lSize)
			return findKthSmallest(root.left, k);

		return findKthSmallest(root.right, k - lSize - 1);
	}

	/**
	 * Given a
	 Binary Search Tree
	 and an integer k, implement a method to find and return its kth largest node

	 Example:

	 		 4
	 		/ \
	       2   8
	 		  / \
	 		 5  10

	 K = 2, Output = 8

	 In the above scenario, if k = 1, then the output is 10 i.e. k = 1, represents the largest element of the tree, k = 2, represents the second largest element and so on.
	 Time: O(n)
	 Space: O(log n)
	 */
	public TreeNode findKthLargest(TreeNode root, int k) {
		if(root == null) return null;

		int rSize = 0;
		if(root.right != null)
			rSize = findSize(root.right);

		if(rSize+1 == k) return root;
		else if(k <= rSize)
			return findKthLargest(root.right, k);

		return findKthLargest(root.left, k - rSize - 1);
	}

	//Time: O(n), Space: O(log n)
	public int findSize(TreeNode root) {
		if(root == null) return 0;
		return findSize(root.left) + 1 + findSize(root.right);
	}

	//Use Inorder to print in ascending order
	public void printRangeIter(TreeNode root, int a, int b) {
		ArrayList<Integer> rangeList = new ArrayList<>();

		Stack<TreeNode> stack = new Stack<>();
		TreeNode current = root;
		while(true) {
			while(current != null) {
				if (current.data >= a && current.data <= b) {
					stack.push(current);
					current = current.left;
				} else break;
			}
			if(stack.isEmpty()) break;
			current = stack.pop();
			rangeList.add(current.data);
			current = current.right;
		}

		rangeList.forEach(i -> System.out.print(i+" "));
	}

	//Space: O(1), Time: O(n)
	private ArrayList<Integer> rangeList = new ArrayList<>();
	public void printRange(TreeNode root, int a, int b) {
		if(root == null) return;

		if(root.data >= a){
			printRange(root.left, a, b);
		}
		if(a <= root.data && root.data <= b)
			rangeList.add(root.data);

		if(root.data <= b) {
			printRange(root.right, a, b);
		}
	}

	/**
	 * Space: O(log n)
	 * Time: O(log n)
	 */
	public TreeNode delete(TreeNode root, int data) {
		if(root == null) return null;
		if(root.data > data) {
			root.left = delete(root.left, data);
		} else if(root.data < data){
			root.right = delete(root.right, data);
		} else {
			//case 1: No child, delete node and link to parent
			if(root.left == null && root.right == null) {
				root = null;
				//case 2: one child
			} else if(root.left == null) {
				root = root.right;
			} else if(root.right == null) {
				root = root.left;
			} else {
				//case 3: 2 children
				TreeNode temp = findMin(root.right);
				root.data = temp.data;
				root.right = delete(root.right, temp.data);
				return root;
			}
		}
		return root;
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

//		tree.insert(15);
//		tree.insert(10);
//		tree.insert(20);
//		tree.insert(25);


		tree.insert(3);
		tree.insert(4);
		tree.insert(5);
		tree.insert(7);
		tree.insert(8);
		tree.insert(10);


		// print inorder traversal of the BST
		//tree.inorder();
//		System.out.println("Inorder traversal iterative: "+tree.inorderIterative(tree.root));
//		System.out.println("Preorder traversal iterative: "+tree.preorderIterative(tree.root));
//		System.out.println("Postorder traversal iterative: "+tree.postorderIterative(tree.root));
//		tree.levelOrderTraversal(tree.root);
//		tree.levelorder(tree.root);

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		root.left.right.left = new TreeNode(6);
		root.left.right.left.right = new TreeNode(7);
		root.left.left.left = new TreeNode(8);
		root.left.left.left.left = new TreeNode();

		TreeNode root2 = new TreeNode(4);
		root2.left = new TreeNode(2);
		root2.right = new TreeNode(8);
		root2.right.right = new TreeNode(10);
		root2.right.left = new TreeNode(5);
		System.out.println("Delete: "+tree.delete(root2, 10));

//		System.out.println("Validate: "+validateBSTItr(root2));

		tree.printRange(tree.root, 3 , 10);
//		TreeNode smallestNode = tree.findKthSmallest(root, 2);
//		TreeNode largestNode = tree.findKthLargest(root, 2);
//		System.out.println("Kth Smallest node: "+smallestNode.data);
//		System.out.println("Kth Largest node: "+largestNode.data);

//		System.out.println("Diameter of Tree: " + diameter(root));
	}

}

class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;

	public TreeNode(int x) {
		data = x;
		left = right = null;
	}

	public TreeNode() {
		left = right = null;
	}
}
