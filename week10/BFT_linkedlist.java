package week10;

import java.util.Scanner;
import java.util.Queue;

// Custom Node class for LinkedList
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Custom LinkedList implementation
class L_list {
    private Node head;

    // Add element to the linked list
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Get all elements as an array
    public int[] getElements() {
        int size = size();
        int[] elements = new int[size];
        Node current = head;
        int index = 0;
        while (current != null) {
            elements[index++] = current.data;
            current = current.next;
        }
        return elements;
    }

    // Get the size of the linked list
    public int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // Check if the list is empty
    public boolean isEmpty() {
        return head == null;
    }
}

// Graph implementation using custom LinkedList
public class BFT_linkedlist {
    private int V; // Number of vertices
    private L_list[] adj; // Array of LinkedLists for adjacency list

    public BFT_linkedlist(int v) {
        V = v;
        adj = new L_list[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new L_list(); // Initialize each adjacency list
        }
    }

    // Add an edge to the graph
    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // Perform BFS Traversal
    public void BFT(int s) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new java.util.LinkedList<>(); // Built-in queue for BFS

        visited[s] = true;
        queue.add(s);

        System.out.println("Breadth-First Traversal starting from node " + s + ":");
        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int neighbor : adj[current].getElements()) {
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

        BFT_linkedlist graph = new BFT_linkedlist(vertices);

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
