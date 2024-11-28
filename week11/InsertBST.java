package week11;

// A utility class that represents an individual node in a BST
class Node5 {
    int val;
    Node5 left, right;

    public Node5(int item) {
        val = item;
        left = right = null;
    }
}

class InsertBST {
    Node5 root;

    public InsertBST() {
        root = null;
    }

    // Method to insert a value into the BST
    void insert(int val) {
        root = insertRec(root, val);
    }

    private Node5 insertRec(Node5 root, int val) {
        // Base case: If the tree is empty, return a new node
        if (root == null) {
            root = new Node5(val);
            return root;
        }

        // Recur down the tree to insert the value
        if (val < root.val) {
            root.left = insertRec(root.left, val);
        } else if (val > root.val) {
            root.right = insertRec(root.right, val);
        }

        // Return the unchanged root
        return root;
    }

    // Method to perform in-order traversal
    void inorder() {
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(Node5 root) {
        if (root != null) {
            inorderRec(root.left); // Visit left subtree
            System.out.print(root.val + " "); // Print root value
            inorderRec(root.right); // Visit right subtree
        }
    }

    // Driver code
    public static void main(String[] args) {
        InsertBST tree = new InsertBST();

        /* Construct the following BST
                  50
               /     \
             30       70
            /  \     /  \
          20   40   60   80 
        */

        // Insert values into the BST
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
    }
}
