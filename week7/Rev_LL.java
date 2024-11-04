package week7;
import java.util.Scanner;
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
        Scanner sc = new Scanner(System.in);
        Rev_LL sol = new Rev_LL(); 
        System.out.print("Enter size: ");
        int n = sc.nextInt();
        System.out.println("Enter ele: ");
        for(int i =0;i<n;i++){
            sol.Insert_LL_end(sc.nextInt());
        }
        sol.display_LL();
        System.out.println();
        sol.rev_ll();
    }
    
}
