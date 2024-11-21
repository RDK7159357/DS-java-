package week10;

import java.util.*;

public class DFTgraph5 {
    private int V; // Number of vertices
    private LinkedList<Integer>[] adj; // Adjacency list representation

    @SuppressWarnings("unchecked")
    public DFTgraph5(int v) {
        V = v;
        adj = (LinkedList<Integer>[]) new LinkedList[v]; // Safe type casting
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>(); // Initialize adjacency lists
        }
    }

    // Method to add an edge to the graph
    public void addEdge(int v, int w) {
        adj[v].add(w); // Add w to v's adjacency list
    }

    // Perform Depth-First Traversal starting from a given vertex
    public void DFT(int start) {
        boolean[] visited = new boolean[V]; // Track visited vertices
        System.out.println("DFS Traversal starting from node " + start + ":");
        DFTRecursive(start, visited); // Call the recursive helper function
        System.out.println();
    }

    // Recursive helper method for DFS
    private void DFTRecursive(int v, boolean[] visited) {
        // Mark the current vertex as visited and print it
        visited[v] = true;
        System.out.print(v + " ");

        // Recur for all adjacent vertices
        for (int neighbor : adj[v]) {
            if (!visited[neighbor]) {
                DFTRecursive(neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take input for the number of vertices and edges
        System.out.print("Enter the number of vertices: ");
        int vertices = sc.nextInt();

        System.out.print("Enter the number of edges: ");
        int edges = sc.nextInt();

        // Create a graph with the given number of vertices
        DFTgraph5 graph = new DFTgraph5(vertices);

        // Take input for each edge and add it to the graph
        System.out.println("Enter edges (source destination):");
        for (int i = 0; i < edges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.addEdge(u, v);
        }

        // Input the starting node for DFT
        System.out.print("Enter the starting node for DFS: ");
        int startNode = sc.nextInt();

        // Perform Depth-First Traversal
        graph.DFT(startNode);

        sc.close(); // Close the scanner
    }
}
