package week5;
import java.util.Scanner;

public class Static_arr_stack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size: ");
        int n = sc.nextInt();
        Stack stack = new Stack(n);
        System.out.println("Enter the elements to push: ");
        for(int i=0;i<n;i++){
            stack.push(sc.nextInt());
        }

        // stack.push(10);
        // stack.push(20);
        // stack.push(30);
        stack.display();
        System.out.println("Top ele is: " + stack.peek());
        stack.pop();
        stack.display();
        System.out.println("size of stack: " + stack.size());
        sc.close();
    }
}

class Stack {
    private int arr[];
    private int top;
    private int capacity;

    Stack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    public void push(int x) {
        if (isFull()) {
            System.out.println("Stack Overflow");
            return;
        }
        arr[++top] = x;
        System.out.println("Pushed: " + x);
    }

    public int pop() {
        if (isEmpty()) {

            System.out.println("Stack Underflow");
            return -1;
        }
        System.out.println("Popped " + arr[top]);
        return arr[top--];
    }

    public int peek() {
        if (!isEmpty()) {
            return arr[top];
        }
        System.out.println("Stack is empty");
        return -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.println("Stack ele are: ");
        for (int i = 0; i <= top; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
