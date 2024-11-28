package week11;

class Node2 {
    int key;
    Node2 left, right;

    public Node2(int item) {
        key = item;
        left = right = null;
    }
}

public class min_BST {
    Node2 root;

    public min_BST() {
        root = null;
    }

    // Helper method to recursively insert a key
    Node2 insertRec(Node2 root, int key) {
        if (root == null) {
            root = new Node2(key);
            return root;
        }
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }
        return root;
    }

    // Insert a key into the BST
    void insert(int key) {
        root = insertRec(root, key);
    }

    // Helper method to recursively search for a key
    Node2 searchRec(Node2 root, int key) {
        if (root == null || root.key == key) {
            return root;
        }
        if (key < root.key) {
            return searchRec(root.left, key);
        }
        return searchRec(root.right, key);
    }

    // Search for a key in the BST
    Node2 search(int key) {
        return searchRec(root, key);
    }

    // Helper method for in-order traversal
    void inorderRec(Node2 root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    // Perform in-order traversal
    void inorder() {
        inorderRec(root);
    }

    // Method to find the minimum value in the BST
    int findMin(Node2 root) {
        if (root == null) {
            System.out.println("Tree is empty");
            return -1; // Or throw an exception if preferred
        }
        while (root.left != null) {
            root = root.left;
        }
        return root.key;
    }

    public static void main(String[] args) {
        min_BST tree = new min_BST();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // Print in-order traversal of the BST
        System.out.println("In-order traversal of the BST:");
        tree.inorder();

        // Find the minimum value in the BST
        int min = tree.findMin(tree.root);
        if (min != -1) {
            System.out.println("\nThe minimum value in the BST is: " + min);
        }
    }
}
