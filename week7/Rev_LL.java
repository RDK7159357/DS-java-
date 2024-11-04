package week7;
import java.util.Stack;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}

public class Rev_LL {     
    Stack<Integer> stack=new Stack<>();
    Node head;
    Rev_LL(){
        head=null;
    }
    void Insert_LL_end(int data){
        Node newNode = new Node(data);
        if(head==null){
            head = newNode;
        }
        else{
            Node Ptr = head;
            while(Ptr.next!=null){
                Ptr=Ptr.next;
            }
            Ptr.next=newNode;
        }
    }
    void rev_ll(){
        Node Ptr = head;
        while(Ptr!=null){
            stack.push(Ptr.data);
            Ptr=Ptr.next;
        }    
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+"->");
        }
        System.out.println("null");
    }

    void display_LL(){
        Node Ptr = head;
        while(Ptr!=null){
            System.out.print(Ptr.data+"->");
            Ptr=Ptr.next;
        }
        System.out.print("null");

    }
    public static void main(String[] args) {
        Rev_LL sol = new Rev_LL(); 
        sol.Insert_LL_end(0);
        sol.Insert_LL_end(1);
        sol.Insert_LL_end(6);
        sol.Insert_LL_end(9);
        sol.display_LL();
        System.out.println();
        sol.rev_ll();
    }
    
}
