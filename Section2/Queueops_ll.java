package Section2;


import java.util.Scanner;

public class Queueops_ll {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedQueue queue = new LinkedQueue();
        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display Queue");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = sc.nextInt();
            switch (choice) {
                case 1: // Enqueue
                    System.out.print("Enter the value to enqueue: ");
                    int value = sc.nextInt();
                    queue.enqueue(value);
                    break;

                case 2: // Dequeue
                    queue.dequeue();
                    break;

                case 3: // Display Queue
                    queue.display();
                    break;

                case 4: // Exit
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedQueue {
    private Node front; // Points to the front of the queue
    private Node rear;  // Points to the rear of the queue
    private int size;   // Tracks the number of elements in the queue

    LinkedQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(int item) {
        Node newNode = new Node(item);
        if (rear == null) { // If the queue is empty
            front = rear = newNode;
        } else {
            rear.next = newNode; // Add the new node to the end of the queue
            rear = newNode;      // Update the rear pointer
        }
        size++;
        System.out.println("Enqueued: " + item);
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return;
        }
        int item = front.data; // Get the data at the front
        front = front.next;    // Move the front pointer to the next node
        if (front == null) {   // If the queue becomes empty
            rear = null;
        }
        size--;
        System.out.println("Dequeued element: " + item);
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("Queue elements: ");
        Node current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public int getSize() {
        return size;
    }
}

