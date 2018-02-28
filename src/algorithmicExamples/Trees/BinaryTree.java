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
    Time: O(n)
    Space: O(n)
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

    /**
     * Recursive
     * Time: O(n)
     * Space: O(logN)
     *
     */
    public boolean isIdentical(TreeNode root1, TreeNode root2) {
        //if both or one of the tree is empty
        if(root1 == null && root2 == null)
            return true;
        if(root1 == null || root2 == null)
            return false;
        //both are not empty
        return (
                root1.val == root2.val &&
                        isIdentical(root1.left, root2.left) &&
                        isIdentical(root1.right, root2.right)
        );
    }

    /**
     *
     Write a method to check if the two given binary trees are the mirror images of each other.
     * Return true if they are, false otherwise.
     * What's a binary tree's mirror image? Hold it by the root and rotate all other
     * nodes by 180 degrees!
     Example:
                 1              1
                / \            / \
               2   3    ==    3   2
              / \ / \        / \ / \
             4  5 6  7      7  6 5  4
     *
     * Time: O(n)
     * Space: O(log n)
     */
    public boolean isMirror(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        return (root1.val == root2.val && isMirror(root1.left, root2.right) &&
                isMirror(root1.right, root2.left));
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

    /**
     * Given a binary tree consisting of nodes with positive integer values, write a method -
     * maxSumPath that returns the maximum sum of data values obtained by traversing nodes along a path between any 2 nodes of the tree.
     * The path must originate and terminate at 2 different nodes of the tree, and the maximum sum is obtained by
     * summing all the data values of the nodes traversed along this path.

     Example:

                     1
                    / \
                   2   3     => 18
                  / \ / \
                 4  5 6  7

     Path: 5 -> 2 -> 1 -> 3 -> 7
     Max Sum = 5+2+1+3+7 = 18


     */
    public static int maxSumPath(TreeNode root) {
        int[] maxRecursiveHolder = new int[1];
        maxSumPathMain(root, maxRecursiveHolder);
        return maxRecursiveHolder[0];
    }

    private static int maxSumPathMain(TreeNode root, int[] maxRecursiveHolder) {
        if(root == null) return 0;
        int leftSum = maxSumPathMain(root.left, maxRecursiveHolder);
        int rightSum = maxSumPathMain(root.right, maxRecursiveHolder);

        //Get max path sum upto this node, incl this node's value
        int nodeSumVal = Math.max(root.val + leftSum, root.val + rightSum);
        maxRecursiveHolder[0] = Math.max(maxRecursiveHolder[0], leftSum + root.val + rightSum);

        return nodeSumVal;
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

    /**
     * Write a non-recursive method minTreeDepth that takes in the root node of a Binary Tree
     * and returns the minimum depth of the tree.
     * The minimum depth is defined as the least number of node traversals needed to reach a
     * leaf from the root node. Your method should run in linear O(n) time and use at max O(n) space.
     * @param root
     * @return
     */
    public int minDepthIter(TreeNode root) {
        if(root == null) return 0;
        int depth = 1;
        Queue<TreeNode> currLevel = new LinkedList<>();
        Queue<TreeNode> nextLevel = new LinkedList<>();
        currLevel.add(root);
        while(!currLevel.isEmpty()) {
            TreeNode t = currLevel.poll();
            if(t.left == null && t.right == null) return depth;
            else {
                if(t.left != null) nextLevel.add(t.left);
                if(t.right != null) nextLevel.add(t.right);
                if(currLevel.isEmpty()) {
                    depth++;
                    currLevel = nextLevel;
                    nextLevel = new LinkedList<>();
                }
            }
        }
        return depth;
    }

    public int size(TreeNode root) {
        int size = 0;
        if(root == null) return 0;
        return size(root.left) + 1 + size(root.right);
    }

    //Time: O(n)
    //Space: O(log n)
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

    /**
     *Sum Iterative
     * Time : O(n)
     * Space : O(n)
     */
    public int sumItr(TreeNode root) {
        if(root == null) return 0;

        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode curr;
        while (!queue.isEmpty()) {
             curr = queue.poll();
            sum +=curr.val;

            if(curr.left != null) {
                queue.add(curr.left);
            }
            if(curr.right != null) {
                queue.add(curr.right);
            }
        }
        return sum;
    }
    //Iterative
    public TreeNode findNode(TreeNode root, int val) {
        if(root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode n = stack.pop();
            if(n.val == val) return n;

            if(n.right != null)
                stack.push(n.right);
            if(n.left != null)
                stack.push(n.left);
        }
        return root;
    }

    /**
     * Write a function to iteratively determine the total number of "full nodes" in a binary tree. A full node contains left and right child nodes. If there are no full nodes, return 0.
     Example:
            1
           / \
          2   3
         / \ / \
        4  5 6  7
       / \
      8   9

     Full nodes count ==> 4
     Space: O(n)
     */
    public int numberOfFullNodes(TreeNode root) {
        if(root == null) return 0;
        if(root.left != null && root.right != null)
            return numberOfFullNodes(root.left) + numberOfFullNodes(root.right) + 1;
        return 0;
    }

    public int numberOfHalfNodes(TreeNode root) {
        if(root == null) return 0;
        int count = 0;
        if(root.left != null && root.right != null) {
            count = numberOfHalfNodes(root.left) + numberOfHalfNodes(root.right);
        }
        if(root.left != null && root.right == null)
            count = numberOfHalfNodes(root.left) + 1;
        else if(root.left == null && root.right != null) {
            count = numberOfHalfNodes(root.right) + 1;
        }
        return count;
    }

    //Space : O(n)
    public int numberOfHalfNodesIter(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int count = 0;
        TreeNode current = null;
        while(!q.isEmpty()) {
            current = q.poll();
            if(current.left == null && current.right != null ||
                    current.left != null && current.right == null) {
                count++;
            }
            if(current.left != null) q.add(current.left);
            if(current.right != null) q.add(current.right);
        }
        return count;
    }

    //XOR
    public int numberOfHalfNodesXOR(TreeNode root) {
        if(root == null)return 0;
        int count = 0;
        if(root.left == null ^ root.right == null) {
            count++;
        }
        return numberOfHalfNodesXOR(root.left) + numberOfHalfNodesXOR(root.right) + count;
    }

    /**
     * Given a binary tree, write a method to find and return its deepest node.
     * Return null for an empty tree.
     Example:
                1
               / \
              2   3     ==> deepest = 9
             / \ / \
            4  5 6  7
           / \
          8   9

     Time: O(n), Space: O(n)
     */
    public TreeNode findDeepest(TreeNode root) {
        if(root == null) return null;
        List<TreeNode> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            list.add(curr);
            if(curr.left != null)
                queue.add(curr.left);
            if(curr.right != null)
                queue.add(curr.right);
        }

        return list.get(list.size() - 1);
    }

    public String serializeTree(TreeNode root){
        StringBuilder sb = new StringBuilder();
        serializeTreeHelper(root, sb);
        if(sb.length() > 0) sb.deleteCharAt(0);
        return sb.toString();
    }

    private StringBuilder serializeTreeHelper(TreeNode t, StringBuilder sb){
        if(t == null) sb.append(",null");
        else {
            sb.append("," + t.val);
            serializeTreeHelper(t.left, sb);
            serializeTreeHelper(t.right, sb);
        }
        return sb;
    }

    public TreeNode restoreTree(String str){
        String[] nodesSplit = str.split(",");
        LinkedList<String> nodesList = new LinkedList<>(Arrays.asList(nodesSplit));
        return restoreTreeHelper(nodesList);
    }

    public TreeNode restoreTreeHelper(LinkedList<String> nodes){
        String nodeDataStr = nodes.remove();
        if(nodeDataStr.equals("null")) return null;
        TreeNode t = new TreeNode(Integer.valueOf(nodeDataStr));
        t.left = restoreTreeHelper(nodes);
        t.right = restoreTreeHelper(nodes);
        return t;
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

    // Time : O(n), Space : O(log n)
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

    //Time: O(n), Space: O(n)
    public int findMaxItr(TreeNode root) {
        int max = Integer.MIN_VALUE;
        if(root == null) return max;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if(curr.val > max) max = curr.val;
            if(curr.left != null) queue.add(curr.left);
            if(curr.right != null) queue.add(curr.right);
        }

        return max;
    }

    /**
     * Given a binary tree's root node, an empty ArrayList and an integer nodeData,
     * write a method that finds a target node - N with data = nodeData and populates the ArrayList with the data of the ancestor nodes of N - added from the bottom - up.
     Example:

                1
               / \
              2   3
             / \ / \
            4  5 6  7

     Node: 5 ==> [2, 1]
     Time: O(n), Space: O(1)
     */

    public ArrayList<Integer> ancestorsList = new ArrayList<>();
    public boolean printAncestors(TreeNode root, int nodeData) {
        if(root == null) return false;

        if(root.val == nodeData) return true;

        if(printAncestors(root.left, nodeData) || printAncestors(root.right, nodeData)) {
            ancestorsList.add(root.val);
            return true;
        }
        return false;
    }

    /**
     * Given a binary tree and two tree nodes, write a method to find
     LCA
     (Lowest Common Ancestor) of the two nodes.
     Example:
            1
           / \
          2   3
         / \ / \
        4  5 6  7
     ==>
     LCA
     of 6 and 4 is 1,

     LCA
     of 4 and 5 is 2.

     Time: O(n)
     Space: O(logn)
     */
    public TreeNode findLCA(TreeNode root, TreeNode a, TreeNode b) {
        if(root == null) return null;
        TreeNode leftTemp, rightTemp;
        if(root == a || root == b) {
            return root;
        }

        leftTemp = findLCA(root.left, a, b);
        rightTemp = findLCA(root.right, a, b);

        if(leftTemp != null && rightTemp == null) return leftTemp;
        if(rightTemp != null && leftTemp == null) return rightTemp;
        if(leftTemp == null) return null;

        return root;
    }

    /**
     * Given a binary tree, write a method to print the tree level by level.

     Example:
                1
               / \
              2   3
             / \ / \
            4  5 6  7

     ==>  [1][2, 3][4, 5, 6, 7]

     Time: O(n), Space: O(n)
     */

    public ArrayList<ArrayList<Integer>> printLevelByLevel(TreeNode root) {
        if(root == null) return new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> innerList = new ArrayList<>();
        Queue<TreeNode> currentLevelQueue = new LinkedList<>();
        Queue<TreeNode> nextLevelQueue = new LinkedList<>();
        currentLevelQueue.add(root);
        while(!currentLevelQueue.isEmpty()) {
            TreeNode curr = currentLevelQueue.poll();
            innerList.add(curr.val);

            if(curr.left != null) {
                nextLevelQueue.add(curr.left);
            }
            if(curr.right != null) {
                nextLevelQueue.add(curr.right);
            }
            if(currentLevelQueue.isEmpty()) {
                result.add(innerList);
                innerList = new ArrayList<>();
                currentLevelQueue.addAll(nextLevelQueue);
                nextLevelQueue = new LinkedList<>();
            }
        }

        return result;
    }

    public ArrayList<ArrayList<Integer>> printLevelByLevelEff(TreeNode root) {
        ArrayList<ArrayList<Integer>> solution = new ArrayList<>();
        if (root == null) {
            return solution;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<>();
            int size = q.size();

            while (size-- > 0) {
                root = q.poll();
                level.add(root.val);

                if (root.left != null) {
                    q.add(root.left);
                }
                if (root.right != null) {
                    q.add(root.right);
                }
            }
            solution.add(level);
        }
        return solution;
    }

    /**
     * Given the root of a Binary Tree  and an integer that represents the data value of a TreeNode present in the tree, write a method - pathLengthFromRoot that returns the distance between the root and that node. You can assume that the given key exists in the tree. The distance is defined as the minimum number of nodes that must be traversed to reach the target node.

     Example:
                 1
                / \
               2   3
                \   \
                4   5

     pathLengthFromRoot(root,5) => 3
     pathLengthFromRoot(root,1) => 1
     pathLengthFromRoot(root,3) => 2

     Space: O(n), Time: O(n)
     */
    public int pathLengthFromRoot(TreeNode root, int n1) {
        if(root == null) return 0;

        int length = 0;
        if(root.val == n1 || (length = pathLengthFromRoot(root.left, n1)) > 0 ||
                (length = pathLengthFromRoot(root.right, n1)) > 0) {
            return length + 1;
        }
        return length;
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
        TreeNode four = new TreeNode(4);
        root.left.left = four;
        root.left.right = new TreeNode(5);
//        root.left.left.left = new TreeNode(8);
//        root.left.left.right = new TreeNode(9);
        TreeNode six = new TreeNode(6);
        root.right.left = six;
        root.right.right = new TreeNode(7);
        System.out.println("Distance of a node 1 from root: "+binaryTree.pathLengthFromRoot(root, 1));
        System.out.println("Distance of a node 2 from root: "+binaryTree.pathLengthFromRoot(root, 2));
        System.out.println("Distance of a node 5 from root: "+binaryTree.pathLengthFromRoot(root, 5));
        System.out.println("Distance of a node 8 from root: "+binaryTree.pathLengthFromRoot(root, 8));


        System.out.println("Find ancestors: "+binaryTree.printAncestors(root, 5));
        System.out.println("LCA: "+binaryTree.findLCA(root, six, four).val);
        System.out.println("Print level by level: "+binaryTree.printLevelByLevel(root));
        System.out.println("Print level by level: "+binaryTree.printLevelByLevelEff(root));
        System.out.println("Number of full nodes: "+binaryTree.numberOfFullNodes(root));
        System.out.println("deepest node: "+binaryTree.findDeepest(root).val);
//        System.out.println("Serialize: "+binaryTree.serializeTree(root));
//        System.out.println("Restore: "+ binaryTree.restoreTree(binaryTree.serializeTree(root)));
        System.out.println("Number of Half Nodes: "+ binaryTree.numberOfHalfNodes(root));
        System.out.println("Number of Half Nodes Iter: "+ binaryTree.numberOfHalfNodesIter(root));
        System.out.println("Number of Half Nodes XOR: "+ binaryTree.numberOfHalfNodesXOR(root));
        System.out.println("Find Max: "+binaryTree.findMaxItr(root));

//        System.out.println("isBalanced: "+binaryTree.isBalanced(root));
//        System.out.println("hasPathSum: "+binaryTree.hasPathSum(root, 22));
//        System.out.println("Max Depth: "+binaryTree.maxDepth(root));
//        System.out.println("Min Depth: "+binaryTree.minDepth(root));

//        Integer[] preOrderArr = {1, 2 ,3};
//        ArrayList<Integer> preOrderList = new ArrayList<Integer>(Arrays.asList(preOrderArr));
//        System.out.println("Constructed Binary Tree: "+binaryTree.buildTree(new ArrayList<Integer>(Arrays.asList(1,2,4,8,9,10,11,5,3,6,7)),
//                new ArrayList<Integer>(Arrays.asList(8,4,10, 9,11,2,5,1,6,3,7))));
        System.out.println("Size: "+binaryTree.size(root));
        System.out.println("Number of leaves: "+binaryTree.numberOfLeaves(root));
        System.out.println("Sum: "+binaryTree.sum(root));
        System.out.println("Iter Sum: "+binaryTree.sumItr(root));
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