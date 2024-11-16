package week9;

class Node3 {
    int data;
    Node3 left, right;

    public Node3(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

public class BinaryTreeInsertion3 {

    // Method to insert a node into the binary search tree
    static Node3 insert(Node3 root, int key) {
        // If the tree is empty, return a new node
        if (root == null) {
            root = new Node3(key);
            return root;
        }

        // Otherwise, recur down the tree
        if (key < root.data) {
            root.left = insert(root.left, key);
        } else if (key > root.data) {
            root.right = insert(root.right, key);
        }

        // Return the (unchanged) node pointer
        return root;
    }

    // Method to perform inorder traversal
    static void inorder(Node3 root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        Node3 root = null;
        
        // Insert nodes into the binary search tree
        root = insert(root, 50);
        root = insert(root, 30);
        root = insert(root, 20);
        root = insert(root, 40);
        root = insert(root, 70);
        // root = insert(root, 60);
        // root = insert(root, 80);

        // Print inorder traversal of the binary search tree
        System.out.println("Inorder traversal of the binary search tree:");
        inorder(root);
    }
}
