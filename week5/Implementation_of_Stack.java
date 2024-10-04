package week5;
import java.util.Arrays;
public class Implementation_of_Stack {
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.pop();
        stack.peek();
        stack.push(40);
        stack.push(50);
        stack.push(60);
        stack.Printstack();
    }
}
class Stack {
    private int maxSize;
    private int top;
    private int[] stackArray;
    public Stack(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }
    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full");
        } else {
            stackArray[++top] = value;
        }
    }
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        } 
            return stackArray[top];   
    }
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return stackArray[top];
    }
    public boolean isEmpty() {

        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }
    public void Printstack() {
        System.out.println(Arrays.toString(stackArray));

    }
}