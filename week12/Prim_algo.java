package week12;

import java.util.Arrays;

public class Prim_algo {
    private int[][] adjacencyMatrix; 
    private int numVertices;

    public Prim_algo(int vertices) {
        numVertices = vertices;
        adjacencyMatrix = new int[vertices][vertices];
    }

    private int minKey(int[] key, boolean[] mstSet) {
        int minIndex = -1, min = Integer.MAX_VALUE;
        for (int i = 0; i < numVertices; i++)
            if (!mstSet[i] && key[i] < min) { min = key[i]; minIndex = i; }
        return minIndex;
    }

    public void primMST() {
        int[] key = new int[numVertices], parent = new int[numVertices];
        boolean[] mstSet = new boolean[numVertices];
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0; parent[0] = -1;

        for (int i = 0; i < numVertices - 1; i++) {
            int u = minKey(key, mstSet);
            mstSet[u] = true;
            for (int v = 0; v < numVertices; v++)
                if (adjacencyMatrix[u][v] != 0 && !mstSet[v] && adjacencyMatrix[u][v] < key[v]) {
                    key[v] = adjacencyMatrix[u][v];
                    parent[v] = u;
                }
        }

        System.out.println("Edge \tWeight");
        for (int i = 1; i < numVertices; i++)
            System.out.println(parent[i] + " - " + i + "\t" + adjacencyMatrix[i][parent[i]]);
    }

    public static void main(String[] args) {
        Prim_algo graph = new Prim_algo(5);
        graph.adjacencyMatrix = new int[][] {
            {0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0}
        };
        graph.primMST();
    }
}
