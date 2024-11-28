package week11;

// Node1 class to represent each node of the Search_in_BST
class Node1 {
    int key;
    Node1 left, right;

    public Node1(int item) {
        key = item;
        left = right = null;
    }
}

class Search_in_BST {
    Node1 root;

    // Constructor for Search_in_BST
    public Search_in_BST() {
        root = null;
    }

    // Method to insert a new key into the Search_in_BST
    void insert(int key) {
        root = insertRec(root, key);
    }

    // Recursive helper function for insertion
    Node1 insertRec(Node1 root, int key) {
        // If the tree is empty, create a new node
        if (root == null) {
            root = new Node1(key);
            return root;
        }

        // Otherwise, recursively traverse the tree
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }

        return root;
    }

    // Method to search for a key in the Search_in_BST
    Node1 search(int key) {
        return searchRec(root, key);
    }

    // Recursive helper function for searching
    Node1 searchRec(Node1 root, int key) {
        // Base case: root is null or key is present at root
        if (root == null || root.key == key) {
            return root;
        }

        // Key is smaller than root's key
        if (key < root.key) {
            return searchRec(root.left, key);
        }

        // Key is larger than root's key
        return searchRec(root.right, key);
    }

    // Method to perform in-order traversal (for testing)
    void inorder() {
        inorderRec(root);
    }

    // Recursive helper function for in-order traversal
    void inorderRec(Node1 root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    // Main method
    public static void main(String[] args) {
        Search_in_BST tree = new Search_in_BST();

        // Insert keys into the Search_in_BST
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // Print in-order traversal of the Search_in_BST
        System.out.println("In-order traversal of the Search_in_BST:");
        tree.inorder();

        // Search for a key in the Search_in_BST
        int keyToSearch = 40;
        Node1 result = tree.search(keyToSearch);
        if (result != null) {
            System.out.println("\nKey " + keyToSearch + " found in the Search_in_BST.");
        } else {
            System.out.println("\nKey " + keyToSearch + " not found in the Search_in_BST.");
        }
    }
}

