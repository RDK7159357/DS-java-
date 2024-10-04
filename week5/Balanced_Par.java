package week5;
import java.util.Stack;

public class Balanced_Par {
    
    public static boolean isBalanced(String expression) {
        Stack<Character> stk = new Stack<>();
        char exp[] = expression.toCharArray();
        
        for (int i = 0; i < expression.length(); i++) {
            if (exp[i] == '(' || exp[i] == '[' || exp[i] == '{') {
                stk.push(exp[i]);
            } else if (exp[i] == ')' || exp[i] == ']' || exp[i] == '}') {
                if (stk.isEmpty()) {
                    return false;
                }
                char top = stk.peek();
                if ((top == '(' && exp[i] == ')') || 
                    (top == '[' && exp[i] == ']') || 
                    (top == '{' && exp[i] == '}')) {
                    stk.pop();
                } else {
                   
                    return false;
                }
            }
        }
        
        return stk.isEmpty();
    }
    
public static void main(String[] args)
{
String expression1 = "{(a+b)*(c-d)}";
String expression2 = "{(a+b)*[c-d)}";

System.out.println(isBalanced(expression1));
System.out.println(isBalanced(expression2));
}
}

