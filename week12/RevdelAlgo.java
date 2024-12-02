package week12;

import java.util.*;

class Edge {
    int src, dest, weight;
    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

class Graph {
    int V;
    List<Edge> edges = new ArrayList<>();

    Graph(int V) {
        this.V = V;
    }

    void addEdge(int u, int v, int w) {
        edges.add(new Edge(u, v, w));
    }

    void dfs(int v, boolean[] visited) {
        visited[v] = true;
        for (Edge e : edges) {
            if ((e.src == v && !visited[e.dest]) || (e.dest == v && !visited[e.src])) {
                dfs(e.src == v ? e.dest : e.src, visited);
            }
        }
    }

    boolean connected() {
        boolean[] visited = new boolean[V];
        dfs(0, visited);

        // Use a loop to check if all vertices are visited
        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }

    void reverseDeleteMST() {
        Collections.sort(edges, (a, b) -> b.weight - a.weight);  // Sort edges in descending order
        for (Edge edge : new ArrayList<>(edges)) {
            edges.remove(edge);
            if (!connected()) edges.add(edge);
        }

        edges.forEach(e -> System.out.println("Edge: " + e.src + " - " + e.dest + " with weight " + e.weight));
    }
}

public class RevdelAlgo {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1, 2);
        graph.addEdge(1, 2, 3);
        graph.addEdge(2, 3, 4);
        graph.addEdge(3, 4, 5);
        graph.addEdge(0, 3, 6);
        graph.addEdge(1, 4, 7);
        graph.reverseDeleteMST();
    }
}
