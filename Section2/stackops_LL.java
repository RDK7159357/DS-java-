package Section2;

import java.util.Scanner;

public class stackops_LL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements to push: ");
        int n = sc.nextInt();
        StackLL stack = new StackLL();
        System.out.println("Enter the elements to push: ");
        for (int i = 0; i < n; i++) {
            stack.push(sc.nextInt());
        }
        stack.display();
        System.out.println("Top element is: " + stack.peek());
        stack.pop();
        stack.display();
        System.out.println("Size of stack: " + stack.size());
        sc.close();
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

class StackLL {
    private Node top;
    private int size;

    StackLL() {
        top = null;
        size = 0;
    }

    public void push(int x) {
        Node newNode = new Node(x);
        newNode.next = top; // Link new node to the current top
        top = newNode; // Update top to the new node
        size++;
        System.out.println("Pushed: " + x);
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        int poppedValue = top.data;
        top = top.next; // Update top to the next node
        size--;
        System.out.println("Popped: " + poppedValue);
        return poppedValue;
    }

    public int peek() {
        if (!isEmpty()) {
            return top.data;
        }
        System.out.println("Stack is empty");
        return -1;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.println("Stack elements are: ");
        Node current = top;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
