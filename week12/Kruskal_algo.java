package week12;

import java.util.*;

public class Kruskal_algo {

    class Edge implements Comparable<Edge> {
        int src, dest, weight;
        public int compareTo(Edge e) { return this.weight - e.weight; }
    }

    private final int V;
    private final List<Edge> edges = new ArrayList<>();

    public Kruskal_algo(int vertices) { this.V = vertices; }

    public void addEdge(int u, int v, int w) {
        Edge edge = new Edge();
        edge.src = u; edge.dest = v; edge.weight = w;
        edges.add(edge);
    }

    private int find(int[] parent, int i) {
        return (parent[i] == i) ? i : (parent[i] = find(parent, parent[i]));
    }

    private void union(int[] parent, int[] rank, int x, int y) {
        int rootX = find(parent, x), rootY = find(parent, y);
        if (rank[rootX] < rank[rootY]) parent[rootX] = rootY;
        else if (rank[rootX] > rank[rootY]) parent[rootY] = rootX;
        else { parent[rootY] = rootX; rank[rootX]++; }
    }

    public void KruskalMST() {
        edges.sort(Edge::compareTo);
        int[] parent = new int[V], rank = new int[V];
        for (int i = 0; i < V; i++) parent[i] = i;
        List<Edge> mst = new ArrayList<>();

        for (Edge edge : edges) {
            if (mst.size() == V - 1) break;
            int x = find(parent, edge.src), y = find(parent, edge.dest);
            if (x != y) {
                mst.add(edge);
                union(parent, rank, x, y);
            }
        }

        mst.forEach(e -> System.out.println(e.src + " -- " + e.dest + " == " + e.weight));
    }

    public static void main(String[] args) {
        Kruskal_algo graph = new Kruskal_algo(4);
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 6);
        graph.addEdge(0, 3, 5);
        graph.addEdge(1, 3, 15);
        graph.addEdge(2, 3, 4);
        graph.KruskalMST();
    }
}
