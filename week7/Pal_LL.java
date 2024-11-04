package week7;

import java.util.Scanner;
import java.util.Stack;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Pal_LL {
    Stack<Integer> stack = new Stack<>();
    Node head;

    Pal_LL() {
        head = null;
    }

    void Insert_LL_end(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node Ptr = head;
            while (Ptr.next != null) {
                Ptr = Ptr.next;
            }
            Ptr.next = newNode;
        }
    }

    public boolean isPalindrome(Node head) {
        Node Ptr = head;
        while(Ptr!=null){
            stack.push(Ptr.data);
            Ptr=Ptr.next;
        }
        Ptr = head;
        while(!stack.isEmpty()){
            if(stack.pop()!=Ptr.data){
                return false;
            }
            Ptr=Ptr.next;
        }
        return true;

    }

    public static void main(String[] args) {
        Pal_LL sol = new Pal_LL();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size: ");
        int n = sc.nextInt();    
        for(int i=0;i<n;i++){
            sol.Insert_LL_end(sc.nextInt());
        }
        sc.close();
        System.out.println(sol.isPalindrome(sol.head));
    }
}
