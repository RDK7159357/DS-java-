package week5;
import java.util.Stack;
public class Stackops {
    public static void main(String[] args) {
        Stack <Integer> stk = new Stack<>();
        stk.push(10);
        stk.push(20);
        stk.push(30);
        stk.push(40);
        stk.push(50);
        System.out.println("after pushing ele: "+ stk);
        System.out.println("top ele is: "+stk.peek());
        int poppedele=stk.pop();
        System.out.println("Popped ele: "+poppedele);
        System.out.println("After popping an ele: "+stk);
        if(stk.isEmpty()){
            System.out.println("The stack is empty");
        }
        else{
            System.out.println("The stack is not empty");
        }
        System.out.println("Size of the stack: "+ stk.size());
        stk.clear();
        System.out.println("Stack after clearing: "+ stk);
    }
}
