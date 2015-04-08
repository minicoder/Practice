package algorithmicExamples;

public class BinaryTreeDepth {
    
    // root of the tree
    private static BinaryNode root;
    int currentDepth, depth;
     
    /**
     * 
     * @param x element to be inserted
     * @param t parent node to which child should be attached
     * @return newly created node
     */
    protected BinaryNode insert(Comparable<Integer> x, BinaryNode t) {
        if (t == null)
            t = new BinaryNode(x);
        else if (x.compareTo((Integer) t.element) < 0)
            t.left = insert(x, t.left);
        else if (x.compareTo( (Integer) t.element) > 0)
            t.right = insert(x, t.right);
        else
            throw new RuntimeException(x.toString()); // Duplicate
        return t;
    }
     
    /**
     * Calculates depth of the binary tree using 
     * instance variables
     *  
     * @param n 
     * @return depth of the binary tree
     */
    public int depth(BinaryNode n) {
        if (n != null) {
            currentDepth++;
 
            if (currentDepth > depth) {
                depth = currentDepth;
            }
 
            depth(n.left);
            depth(n.right);
 
            currentDepth--;
        }
        return depth;
    }
     
    /**
     * Calculates depth of the binary tree without using 
     * any instance variables in bottom-up approach
     *  
     * @param n 
     * @return depth of the binary tree
     */
    public int depth2(BinaryNode node){
        if(node == null)
            return 0;
        int left = depth2(node.left);
        int right = depth2(node.right);
         
        int x = left > right ? left+1 : right+1;
        return x;
    }
     
    /**
     * Calculates depth of the binary tree without using 
     * any instance variables in top-bottom approach
     *  
     * @param n 
     * @return depth of the binary tree
     */
    public int depth3(BinaryNode node, int d){
        int leftDepth = d, rightDepth = d;
         
        if(node.left != null){
            leftDepth = depth3(node.left, d+1);
        }
        if(node.right != null){
            rightDepth = depth3(node.right, d+1);
        }
         
        return leftDepth > rightDepth ? leftDepth : rightDepth;
    }
     
    /**
     * @param args
     */
    public static void main(String[] args) {
        BinaryTreeDepth t = new BinaryTreeDepth();
 
        // construct binary tree
        int[] arr = { 20, 15, 25, 12, 18, 22, 28 };
        for (int i = 0; i < arr.length; i++) {
            root = t.insert(arr[i], root);
        }
 
        int res = t.depth(root);
        System.out.println("Maximum depth of the Binary Tree is using instance variables: " + res);
         
        System.out.println("Maximum depth of the Binary Tree is without " +
                "using instance variables in bottom-up approach: " + t.depth2(root));
         
        System.out.println("Maximum depth of the Binary Tree is without using " +
                "instance variables in top-bottom approach: " + t.depth3(root, 1));
    }
 
}
 
 
 
class BinaryNode {
    // Initialize in node in constructor
    BinaryNode( Comparable<Integer> e ) {
        element = e;
        left = right = null;
    }
     
    // The data in the node
    Comparable<Integer> element;
    // pointer to the left node of the tree 
    BinaryNode left;
    // pointer to the right node of the tree
    BinaryNode right;
 
}