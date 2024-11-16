package week9;
import java.util.Scanner;

// Node class representing a node in the binary tree
class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

// Binary Tree class with traversal methods
class BT {
    Node root;

    BT() {
        this.root = null;
    }

    // Method to insert a node
    void insert(int data) {
        root = insertRec(root, data);
    }

    // Recursive function to insert a new node with given data
    Node insertRec(Node root, int data) {
        // If the tree is empty, return a new node
        if (root == null) {
            root = new Node(data);
            return root;
        }

        // Otherwise, recur down the tree
        if (data < root.data)
            root.left = insertRec(root.left, data);
        else if (data > root.data)
            root.right = insertRec(root.right, data);

        // Return the unchanged node pointer
        return root;
    }

    // Method for inorder traversal: Left -> Root -> Right
    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    // Method for preorder traversal: Root -> Left -> Right
    void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    // Method for postorder traversal: Left -> Right -> Root
    void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    // Method to invoke all traversals
    void displayTraversals() {
        System.out.println("Inorder traversal:");
        inorder(root);
        System.out.println();

        System.out.println("Preorder traversal:");
        preorder(root);
        System.out.println();

        System.out.println("Postorder traversal:");
        postorder(root);
        System.out.println();
    }
}

public class BinaryTreeTraversal2 {
    public static void main(String[] args) {
        BT tree = new BT();
        Scanner scanner = new Scanner(System.in);

        // Take number of nodes input
        System.out.println("Enter number of nodes to insert:");
        int n;
        while (true) {
            n = scanner.nextInt();
            if (n > 0) break;
            System.out.println("Please enter a positive number.");
        }

        // Take node values input
        System.out.println("Enter node values:");
        for (int i = 0; i < n; i++) {
            int data = scanner.nextInt();
            tree.insert(data);
        }

        // Display all traversals
        tree.displayTraversals();

        scanner.close();
    }
}
