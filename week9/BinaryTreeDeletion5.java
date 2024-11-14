package week9;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

public class BinaryTreeDeletion5 {

    // Method to delete the deepest node in the binary tree
    static void deleteDeepest(Node root, Node dNode) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        // Perform level order traversal until we find the deepest node
        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            if (temp == dNode) {
                temp = null;
                return;
            }
            if (temp.right != null) {
                if (temp.right == dNode) {
                    temp.right = null;
                    return;
                } else {
                    queue.add(temp.right);
                }
            }

            if (temp.left != null) {
                if (temp.left == dNode) {
                    temp.left = null;
                    return;
                } else {
                    queue.add(temp.left);
                }
            }
        }
    }

    // Method to delete a node in the binary tree
    static Node deletion(Node root, int key) {
        if (root == null) {
            return null;
        }

        // If the tree has only one node and that node is the target
        if (root.left == null && root.right == null) {
            if (root.data == key) {
                return null;
            } else {
                return root;
            }
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        Node keyNode = null;
        Node temp = null;

        // Perform level order traversal to find the node to delete and the deepest node
        while (!queue.isEmpty()) {
            temp = queue.poll();

            if (temp.data == key) {
                keyNode = temp;
            }

            if (temp.left != null) {
                queue.add(temp.left);
            }

            if (temp.right != null) {
                queue.add(temp.right);
            }
        }

        // If the node to be deleted is found, replace its data with the deepest node’s data
        if (keyNode != null) {
            int x = temp.data;
            deleteDeepest(root, temp);
            keyNode.data = x;
        }

        return root;
    }

    // Inorder traversal for displaying the binary tree
    static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(11);
        root.left.left = new Node(7);
        root.left.right = new Node(12);
        root.right = new Node(9);
        root.right.left = new Node(15);
        root.right.right = new Node(8);

        System.out.println("Inorder traversal before deletion:");
        inorder(root);
        System.out.println();

        int key = 11;
        root = deletion(root, key);

        System.out.println("Inorder traversal after deletion:");
        inorder(root);
    }
}
