package week10;

import java.util.*;

public class DFS2 {

    // Graph represented as an adjacency list (Map of List of Integer)
    private Map<Integer, List<Integer>> graph;

    // Constructor to initialize the graph
    public DFS2() {
        graph = new HashMap<>();
    }

    // Method to add an edge to the graph (directed edge from u to v)
    public void addEdge(int u, int v) {
        // If the source node doesn't exist, create an entry with an empty list
        // graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        if (!graph.containsKey(u)) {
            graph.put(u, new ArrayList<>());
        }
        graph.get(u).add(v);
    }

    // Merged DFS method: performs both DFS and visiting of nodes
    public void DFS(int v) {
        // Set to track visited nodes
        Set<Integer> visited = new HashSet<>();

        // Stack for DFS traversal (can also be done recursively, but stack is explicit)
        Stack<Integer> stack = new Stack<>();
        
        // Push the root node to start traversal
        stack.push(v);

        // Start DFS traversal
        System.out.print("DFS Traversal starting from node " + v + ": ");
        
        // While there are still nodes to visit
        while (!stack.isEmpty()) {
            // Pop a node from the stack
            int current = stack.pop();

            // If the node hasn't been visited
            if (!visited.contains(current)) {
                // Mark as visited and print
                visited.add(current);
                System.out.print(current + " ");

                // Add all unvisited neighbors to the stack
                List<Integer> neighbors = graph.getOrDefault(current, new ArrayList<>());
                for (int neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }
        System.out.println();
    }

    // Main method to interact with the user and create the graph
    public static void main(String[] args) {
        // Create the graph object
        DFS2 g = new DFS2();
        Scanner sc = new Scanner(System.in);

        // Input number of edges
        System.out.print("Enter number of edges: ");
        int n = sc.nextInt();

        // Add edges to the graph
        for (int i = 0; i < n; i++) {
            System.out.print("Enter source node: ");
            int u = sc.nextInt();
            System.out.print("Enter the destination node: ");
            int v = sc.nextInt();
            g.addEdge(u, v);
        }

        // Input the root node for DFS traversal
        System.out.println("Enter the root node to start DFS traversal: ");
        int root = sc.nextInt();

        // Start DFS traversal from the root node
        g.DFS(root);
        
        sc.close(); // Close the scanner after use
    }
}
