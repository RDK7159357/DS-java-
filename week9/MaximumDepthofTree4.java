package week9;

class Node4 {
    int data;
    Node4 left, right;

    // Constructor to initialize the node
    Node4(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class MaximumDepthofTree4 {

    // Method to find the maximum depth of the binary tree
    static int maxDepth(Node4 root) {
        if (root == null) {
            return 0; // base case: the depth of an empty tree is 0
        }

        // Recursively find the depth of each subtree
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        // The depth of the tree is the maximum depth of the two subtrees, plus one for the root
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        Node4 root = new Node4(1);
        root.left = new Node4(2);
        root.right = new Node4(3);
        root.left.left = new Node4(4);
        root.left.right = new Node4(5);
        // root.right.right = new Node4(6);
        // root.left.left.left = new Node4(7);

        // Calculate and print the maximum depth of the tree
        System.out.println("The maximum depth of the tree is: " + maxDepth(root));
    }
}
