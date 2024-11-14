package week9;
import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

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

    // Method for inorder traversal
    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    // Method for preorder traversal
    void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    // Method for postorder traversal
    void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }
}

public class BinaryTreeTraversal2 {
    public static void main(String[] args) {
        BT tree = new BT();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of nodes to insert:");
        int n = scanner.nextInt();

        System.out.println("Enter node values:");
        for (int i = 0; i < n; i++) {
            int data = scanner.nextInt();
            tree.insert(data);
        }

        System.out.println("Inorder traversal:");
        tree.inorder(tree.root);
        System.out.println();

        System.out.println("Preorder traversal:");
        tree.preorder(tree.root);
        System.out.println();

        System.out.println("Postorder traversal:");
        tree.postorder(tree.root);
        System.out.println();

        scanner.close();
    }
}
