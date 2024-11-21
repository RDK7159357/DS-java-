package week10;

import java.util.*;

public class BFS1 {
    private Map<Integer, List<Integer>> graph;

    public BFS1() {
        graph = new HashMap<>();
    }

    // Add an edge to the graph
    public void addEdge(int u, int v) {
        if(!graph.containsKey(u)){
            graph.put(u,new ArrayList<>());
        }
        graph.get(u).add(v);
    }

    // Perform BFS traversal starting from node 's'
    public void BFS(int s) {
        // To keep track of visited nodes
        Set<Integer> visited = new HashSet<>();
        // Queue for BFS
        Queue<Integer> queue = new LinkedList<>();
        
        // Start with the source node
        queue.add(s);
        visited.add(s); // Mark as visited when enqueued

        System.out.println("BFS Traversal starting from node " + s + ":");

        while (!queue.isEmpty()) {
            // Dequeue a vertex from the queue
            int current = queue.poll();
            System.out.print(current + " ");

            // Get all adjacent vertices of the dequeued vertex
            List<Integer> neighbors = graph.getOrDefault(current, new ArrayList<>());
            for (int neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor); // Mark as visited when enqueued
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create the graph
        BFS1 bfsGraph = new BFS1();
        Scanner sc = new Scanner(System.in);
        
        // Take input for number of edges
        System.out.print("Enter number of edges: ");
        int n = sc.nextInt();
        System.out.println("Enter source to destination nodes: ");

        // Add edges to the graph
        for (int i = 0; i < n; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            bfsGraph.addEdge(u, v);
        }

        // Take input for root node to start BFS traversal
        System.out.print("Enter the root node to start BFS traversal: ");
        int root = sc.nextInt();
        
        // Start BFS traversal from the root node
        bfsGraph.BFS(root);

        sc.close(); // Close the scanner after use
    }
}
