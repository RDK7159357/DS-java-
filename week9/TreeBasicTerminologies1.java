package week9;
import java.util.ArrayList;
import java.util.List;
public class TreeBasicTerminologies1 {
    // Method to print children of the given node
    static void printChildren(int root, List<List<Integer>> adj) {
        System.out.print("Children of node " + root + ": ");
        if (adj.get(root).isEmpty()) {
            System.out.println("No children (leaf node).");
        } else {
            for (int child : adj.get(root)) {
                System.out.print(child + " ");
            }
            System.out.println();
        }
    }
    // Method to print all leaf nodes (nodes with no children)
    static void printLeafNodes(int root, List<List<Integer>> adj) {
        System.out.print("Leaf nodes: ");
        for (int i = 0; i < adj.size(); i++) {
            if (adj.get(i).isEmpty()) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
    // Method to print the degree (number of connections) of each node
    static void printDegrees(int root, List<List<Integer>> adj) {
        System.out.println("Degrees of each node:");
        for (int i = 0; i < adj.size(); i++) {
            int degree = adj.get(i).size();  // Outgoing edges (children)
            for (List<Integer> list : adj) { // Check if i is a child (incoming edges)
                if (list.contains(i)) {
                    degree++;
                }
            }
            System.out.println("Node " + i + " has degree " + degree);
        }
    }
    public static void main(String[] args) {
        // Sample tree with 5 nodes (0 to 4)
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList<>());
        }

        // Example tree structure
        adj.get(0).add(1); // Node 0 has child 1
        adj.get(0).add(2); // Node 0 has child 2
        adj.get(1).add(3); // Node 1 has child 3
        adj.get(1).add(4); // Node 1 has child 4

        int root = 0;

        // Test methods
        printChildren(root, adj);
        printLeafNodes(root, adj);
        printDegrees(root, adj);
    }
}
