package week6;
    import java.util.LinkedList;
import java.util.Queue;
public class Stack_usingQ {
    // Use two queues for the stack simulation
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    // Constructor to initialize the queues
    public Stack_usingQ() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    // Push an element onto the stack
    public void push(int x) {
        queue2.add(x); // Add to the empty queue2
        
        // Move all elements from queue1 to queue2 to maintain stack order
        while (!queue1.isEmpty()) {
            queue2.add(queue1.remove());
        }  
        // Swap the references of queue1 and queue2
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }
    // Remove the element on top of the stack and return it
    public int pop() {
        return queue1.remove(); // Pop from queue1 which now holds stack order
    }
    // Get the top element
    public int top() {
        return queue1.peek(); // Peek at the top element
    }
    // Check if the stack is empty
    public boolean empty() {
        return queue1.isEmpty();
    }
    // Main method to test the implementation
    public static void main(String[] args) {
        Stack_usingQ stack = new Stack_usingQ();
        stack.push(1); // Push 1
        stack.push(2); // Push 2
        System.out.println(stack.top()); // Output: 2 (top element)
        System.out.println(stack.pop()); // Output: 2 (pop top element)
        System.out.println(stack.empty()); // Output: false (stack is not empty)
    }
}


