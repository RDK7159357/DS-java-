package week10;

import java.util.*;

public class BFS1 {
    private Map<Integer, List<Integer>> graph;

    public BFS1() {
        graph = new HashMap<>();
    }

    // Add an edge to the graph
    // u is the source node and v is the destination node. So the edge is between u and v
    public void addEdge(int u, int v) {
        if (!graph.containsKey(u)) {
            graph.put(u, new ArrayList<>());
        }
        graph.get(u).add(v);
    }

    // Perform BFS traversal
    // root node is "s"
    public void BFS(int s) {
        // To keep track of visited nodes
        Set<Integer> visited = new HashSet<>();
        // Queue for BFS
        Queue<Integer> queue = new LinkedList<>();
        
        // Start with the source node
        visited.add(s);
        queue.add(s);

        System.out.println("BFS Traversal starting from node " + s + ":");
        
        while (!queue.isEmpty()) {
            // Dequeue a vertex from the queue
            int current = queue.poll();
            System.out.print(current + " ");
            
            // Get all adjacent vertices of the dequeued vertex
            List<Integer> neighbors = graph.getOrDefault(current, new ArrayList<>());
            for (int neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
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
        int i = 0;

        // Add edges to the graph
        while (i < n) {
            System.out.print("Enter source node: ");
            int u = sc.nextInt();
            System.out.print("Enter the destination node: ");
            int v = sc.nextInt();
            bfsGraph.addEdge(u, v);
            i++;
        }

        // Take input for root node to start BFS traversal
        System.out.println("Enter the root node to start BFS traversal: ");
        int root = sc.nextInt();
        
        // Start BFS traversal from the root node
        bfsGraph.BFS(root);

        sc.close(); // Close the scanner after use
    }
}

        
        
        // Add edges to the graph
        // bfsGraph.addEdge(1, 2);
        // bfsGraph.addEdge(1, 3);
        // bfsGraph.addEdge(2, 4);
        // bfsGraph.addEdge(3, 5);
        // bfsGraph.addEdge(4, 6);
        // bfsGraph.addEdge(5, 6);
        // bfsGraph.addEdge(6, 7);

        // // Perform BFS traversal from node 1
        // bfsGraph.BFT(1);
    

