package week10;
import java.util.*;

public class BFTgraph4 {
    private int V; // Number of vertices
    private LinkedList<Integer>[] adj; // Adjacency list representation

    @SuppressWarnings("unchecked")
    public BFTgraph4(int v) {
        V = v;
        adj = (LinkedList<Integer>[]) new LinkedList[v]; // Safe cast
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>(); // Initialize each adjacency list
        }
    }

    // Add an edge to the graph
    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // Perform BFS Traversal
    public void BFT(int s) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        visited[s] = true;
        queue.add(s);

        System.out.println("Breadth-First Traversal starting from node " + s + ":");
        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int neighbor : adj[current]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int vertices = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int edges = sc.nextInt();

        BFTgraph4 graph = new BFTgraph4(vertices);

        System.out.println("Enter edges (source destination):");
        for (int i = 0; i < edges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.addEdge(u, v);
        }

        System.out.print("Enter the starting node for BFS: ");
        int startNode = sc.nextInt();

        graph.BFT(startNode);

        sc.close();
    }
}
