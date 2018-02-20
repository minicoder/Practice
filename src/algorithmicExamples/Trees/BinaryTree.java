package algorithmicExamples.Trees;

import java.util.*;

/**
 * Created by swetha on 1/6/18.
 *
 */
public class BinaryTree {

    /*
     Height-balanced binary tree : is defined as a binary tree in which the depth of the two subtrees of every node
     never differ by more than 1.
     Input :
          1
         / \
        2   3

    Return : True or 1

    Input 2 :
         3
        /
       2
      /
     1

       Return : False or 0, because for the root node, left subtree has depth 2 and right subtree has depth 0. Difference = 2 > 1.
     */
    public boolean isBalanced(TreeNode A) {
        return getHeight(A) > -1;
    }

    public int getHeight(TreeNode root) {
        if(root == null) return 0;

        int leftSubtreeHeight = getHeight(root.left);
        int rightSubTreeHeight = getHeight(root.right);

        // diff is more than 1, return 0;
        if(leftSubtreeHeight == -1 || rightSubTreeHeight == -1) return -1;

        if(Math.abs(leftSubtreeHeight - rightSubTreeHeight) > 1) return -1;

        //incrementing by 1 since we are adding node to the height
        if(leftSubtreeHeight > rightSubTreeHeight) return leftSubtreeHeight + 1;

        return rightSubTreeHeight + 1;
    }

    /*
    Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
    Return 0 / 1 ( 0 for false, 1 for true ) for this problem
    Example :
    Input :

   1       1
  / \     / \
 2   3   2   3

    Output :
    1 or True
     */
    public int isSameTree(TreeNode A, TreeNode B) {
        if(A == null || B == null) return 1;
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        //add nodes to queues
        queue1.add(A);
        queue2.add(B);

        while(!queue1.isEmpty() && !queue2.isEmpty()) {
            //Get 1st node from queue and check if values are equal
            TreeNode n1 = queue1.peek(); //does not remove element
            TreeNode n2 = queue2.peek();

            if(n1.val != n2.val) return 0;

            //Remove front nodes
            queue1.remove(); queue2.remove();

            if(n1.left != null && n2.left != null) {
                queue1.add(n1.left);
                queue2.add(n2.left);
            } else if(n1.left != null || n2.left != null){
                return 0;
            }

            if(n1.right != null && n2.right != null) {
                queue1.add(n1.right);
                queue2.add(n2.right);
            } else if(n1.right != null || n2.right != null) {
                return 0;
            }
        }

        return 1;
    }

    /*
    Given a binary tree and a sum,
    determine if the tree has a root-to-leaf path such that
    adding up all the values along the path equals the given sum.

    Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
        return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
     */
//    0 / 1 ( 0 for false, 1 for true )
    public boolean hasPathSum(TreeNode A, int B) {
        if(A == null) return false;
        Queue<TreeNode> nodes = new LinkedList<>();
        LinkedList<Integer> values = new LinkedList<>();
        nodes.add(A);
        values.add(A.val);
        while(!nodes.isEmpty()) {
            TreeNode curr = nodes.poll();
            int sumValue = values.poll();

            if(curr.left == null && curr.right == null && sumValue==B){
                return true;
            }

            if(curr.left != null){
                nodes.add(curr.left);
                values.add(sumValue+curr.left.val);
            }

            if(curr.right != null){
                nodes.add(curr.right);
                values.add(sumValue+curr.right.val);
            }
        }

        return false;
    }

    public int maxPathSum(TreeNode A) {
        Res res = new Res();
        return maxPathUtil(A, res);

    }

    public int maxPathUtil(TreeNode A, Res res) {
        if(A == null) return 0;
        if(A.val == -1) return 0;

        int l = maxPathUtil(A.left, res);
        int r = maxPathUtil(A.right, res);

        int max_single = Math.max(Math.max(l, r) + A.val, A.val);

        int max_top = Math.max(max_single, l + r + A.val);

        res.val = Math.max(res.val, max_top);

        return res.val;

    }

    /*
    Given a binary tree, find its maximum depth.
    The maximum depth of a binary tree is the number of nodes
    along the longest path from the root node down to the farthest leaf node.
        1
        /
       2
       Max depth = 2
     */
    public int maxDepth(TreeNode A) {
        if(A == null) return 0;

        int left = maxDepth(A.left);
        int right = maxDepth(A.right);

        return left > right ? left+1 : right+1;
    }

    /*
    The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
        1
        /
       2
    min depth = 2.
     */
    public int minDepth(TreeNode A) {
        if(A == null) return 0;

        if(A.left == null && A.right == null) return 1;
        if(A.left==null) return minDepth(A.right) + 1;
        if(A.right == null) return minDepth(A.left) + 1;

        return Math.min(minDepth(A.left), minDepth(A.right)) +1;
    }

    public int size(TreeNode root) {
        int size = 0;
        if(root == null) return 0;
        return size(root.left) + 1 + size(root.right);
    }

    public int numberOfLeaves(TreeNode root) {
        if(root == null) return 0;
        int num = 0;
        if(root.left == null && root.right == null) {
            return num + 1;
        } else {
            return numberOfLeaves(root.left) + numberOfLeaves(root.right);
        }
    }

    /**
     *
     * Given a binary tree, write a method to find and return the sum of all the elements using recursion. For an empty tree the sum is 0.
     Example:
     1
     / \
     2   3
     / \ / \
     4  5 6  7
     /
     8
     ==> sum of all nodes = 36
     (1+2+3+4+5+6+7+8)
     */
    public int sum(TreeNode root) {
        if(root == null) return 0;

        int val = root.val;
        return sum(root.left) + sum(root.right) + val;
    }
    /*
    Given preorder and inorder traversal of a tree, construct the binary tree.
    Input :
        Preorder : [1, 2, 3]
        Inorder  : [2, 1, 3]

    Return :
            1
           / \
          2   3

     */
    public TreeNode buildTree(ArrayList<Integer> preOrder, ArrayList<Integer> inOrder) {
        //A: preorder, B: inorder
        TreeNode node = null;
        int inOrderPos;
        int preOrderPos;
        ArrayList<Integer> leftPreorder ;
        ArrayList<Integer> rightPreorder;
        ArrayList<Integer> leftInorder;
        ArrayList<Integer> rightInorder;

        if(!preOrder.isEmpty() && !inOrder.isEmpty()) {
            node = new TreeNode(preOrder.get(0));
            inOrderPos = inOrder.indexOf(preOrder.get(0));
            leftInorder = new ArrayList<>(inOrder.subList(0, inOrderPos));
            rightInorder = new ArrayList<>(inOrder.subList(inOrderPos + 1, inOrder.size()));

            preOrderPos = leftInorder.size();
            leftPreorder = new ArrayList<>(preOrder.subList(1, preOrderPos + 1));
            rightPreorder = new ArrayList<>(preOrder.subList(preOrderPos + 1, preOrder.size()));

            node.left = buildTree(leftPreorder, leftInorder);
            node.right = buildTree(rightPreorder, rightInorder);

        }
        return node;
    }

    public TreeNode invertTree(TreeNode root) {
        if(root != null) {
            invertUtil(root);
        }
        return root;
    }

    public void invertUtil(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        if(root.left != null) {
            invertUtil(root.left);
        }

        if(root.right!= null){
            invertUtil(root.right);
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
//		TreeNode root = new TreeNode(5);
//		root.right = new TreeNode(8);
//        root.left = new TreeNode(3);
//		root.left.left = new TreeNode(11);
//        root.left.left.left = new TreeNode(7);
//        root.left.left.right = new TreeNode(2);
//		root.right.left = new TreeNode(13);
//		root.right.right = new TreeNode(4);
//        root.right.right.right = new TreeNode((1));
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(8);
//        root.left.left.right = new TreeNode(9);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
//        System.out.println("isBalanced: "+binaryTree.isBalanced(root));
//        System.out.println("hasPathSum: "+binaryTree.hasPathSum(root, 22));
//        System.out.println("Max Depth: "+binaryTree.maxDepth(root));
//        System.out.println("Min Depth: "+binaryTree.minDepth(root));

//        Integer[] preOrderArr = {1, 2 ,3};
//        ArrayList<Integer> preOrderList = new ArrayList<Integer>(Arrays.asList(preOrderArr));
//        System.out.println("Constructed Binary Tree: "+binaryTree.buildTree(new ArrayList<Integer>(Arrays.asList(1,2,4,8,9,10,11,5,3,6,7)),
//                new ArrayList<Integer>(Arrays.asList(8,4,10, 9,11,2,5,1,6,3,7))));
        System.out.println(binaryTree.size(root));
        System.out.println(binaryTree.numberOfLeaves(root));
        System.out.println(binaryTree.sum(root));
//        System.out.println("Constructed Binary Tree: "+binaryTree.buildTree(new ArrayList<Integer>(Arrays.asList(1,2,3)),
//                new ArrayList<Integer>(Arrays.asList(2,1,3))));
    }
}

class Res {
    int val;
}
class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) {
              val = x;
              left=null;
              right=null;
             }
}