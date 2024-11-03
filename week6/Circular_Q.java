package week6;

public class Circular_Q {
    private int size;
    private int front, rear;
    private int[] queue;

    // Constructor to initialize the queue
    public Circular_Q(int size) {
        this.size = size;
        this.queue = new int[size];
        this.front = this.rear = -1;
    }

    // Enqueue operation to add an element to the queue
    public void enqueue(int data) {
        if ((rear + 1) % size == front)
         {
            System.out.println("Queue is Full");
            return; // Queue is full
        }
        if (front == -1) { // First insertion
            front = 0;
        }
        rear = (rear + 1) % size; // Wrap around rear
        queue[rear] = data;
        System.out.println(data + " enqueued to queue");
    }

    // Dequeue operation to remove an element from the queue
    public int dequeue() {
        if (front == -1) {
            System.out.println("Queue is Empty");
            return -1; // Queue is empty
        }
        int data = queue[front];
        if (front == rear) { // Queue becomes empty after this dequeue
            front = rear = -1;
        } else {
            front = (front + 1) % size; // Wrap around front
        }
        System.out.println(data + " dequeued from queue");
        return data;
    }

    // Display the elements in the queue
    public void display() {
        if (front == -1) {
            System.out.println("Queue is Empty");
            return;
        }
        System.out.print("Queue elements: ");
        int i = front;
        while (true) {
            System.out.print(queue[i] + " ");
            if (i == rear) break; // Stop when we've reached the rear
            i = (i + 1) % size; // Wrap around index
        }
        System.out.println();
    }

    // Main method to test the circular queue
    public static void main(String[] args) {
        Circular_Q cq = new Circular_Q(5); // Circular queue of size 5

        cq.enqueue(1); // Enqueue 1
        cq.enqueue(2); // Enqueue 2
        cq.enqueue(3); // Enqueue 3
        cq.enqueue(4); // Enqueue 4

        cq.display(); // Display elements: 1 2 3 4

        cq.dequeue(); // Dequeue 1
        cq.dequeue(); // Dequeue 2

        cq.display(); // Display elements: 3 4

        cq.enqueue(5); // Enqueue 5
        cq.enqueue(6); // Enqueue 6
        cq.enqueue(7); // Attempt to enqueue 7 (Queue is full)

        cq.display(); // Display elements: 3 4 5 6
    }
}
