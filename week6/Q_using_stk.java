package week6;

import java.util.Stack;

public class Q_using_stk {

    private Stack<Integer> stack1; // Main stack for pushing elements
    private Stack<Integer> stack2; // Auxiliary stack for popping/peeking elements

    // Constructor to initialize the stacks
    public Q_using_stk() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Push an element to the back of the queue
    public void push(int x) {
        stack1.push(x);
    }

    // Pop the element from the front of the queue
    public int pop() {
        if (stack2.isEmpty()) {
            // Move all elements from stack1 to stack2 if stack2 is empty
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        // Pop from stack2, which represents the front of the queue
        return stack2.pop();
    }

    // Get the front element without removing it
    public int peek() {
        if (stack2.isEmpty()) {
            // Move all elements from stack1 to stack2 if stack2 is empty
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        // Peek the top of stack2, which represents the front of the queue
        return stack2.peek();
    }

    // Check if the queue is empty
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    // Main method to test the queue operations
    public static void main(String[] args) {
        Q_using_stk queue = new Q_using_stk();

        queue.push(1); // Push 1
        queue.push(2); // Push 2

        System.out.println(queue.peek()); // Output: 1 (front element)
        System.out.println(queue.pop());  // Output: 1 (remove front element)
        System.out.println(queue.empty()); // Output: false (queue is not empty)
    }
}
