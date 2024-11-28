package week11;

class Node3 {
    int data;
    Node3 left, right;

    public Node3(int item) {
        data = item;
        left = right = null;
    }
}

class BSTorNot {
    Node3 root;

    // Method to check if the tree is a BST
    boolean isBST(Node3 node) {
        return isBSTUtil(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    // Utility method to verify the BST property
    boolean isBSTUtil(Node3 node, int min, int max) {
        // Base case: an empty tree is a BST
        if (node == null) {
            return true;
        }

        // Check if the current node's data violates the min/max constraint
        if (node.data <= min || node.data >= max) {
            return false;
        }

        // Recursively check subtrees with updated min/max constraints
        return isBSTUtil(node.left, min, node.data) && isBSTUtil(node.right, node.data, max);
    }

    // Insert method for constructing the tree (optional, for testing)
    Node3 insert(Node3 node, int data) {
        if (node == null) {
            return new Node3(data);
        }
        if (data < node.data) {
            node.left = insert(node.left, data);
        } else if (data > node.data) {
            node.right = insert(node.right, data);
        }
        return node;
    }

    public static void main(String[] args) {
        BSTorNot tree = new BSTorNot();

        // Construct a binary tree
        tree.root = new Node3(50);
        tree.root.left = new Node3(30);
        tree.root.right = new Node3(70);
        tree.root.left.left = new Node3(20);
        tree.root.left.right = new Node3(40);
        tree.root.right.left = new Node3(60);
        tree.root.right.right = new Node3(80);

        // Check if the tree is a BST
        if (tree.isBST(tree.root)) {
            System.out.println("The tree is a BST");
        } else {
            System.out.println("The tree is NOT a BST");
        }

        // Example of a non-BST
        BSTorNot nonBstTree = new BSTorNot();
        nonBstTree.root = new Node3(10);
        nonBstTree.root.left = new Node3(20); // Invalid: left child > parent
        nonBstTree.root.right = new Node3(5); // Invalid: right child < parent

        if (nonBstTree.isBST(nonBstTree.root)) {
            System.out.println("The tree is a BST");
        } else {
            System.out.println("The tree is NOT a BST");
        }
    }
}
