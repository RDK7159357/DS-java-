package week7;
import java.util.Scanner;
import java.util.Stack;

class Node5{
    int data;
    Node5 next;
    Node5(int data){
        this.data=data;
        this.next=null;
    }
}

public class Rev_LL {     
    Stack<Integer> stack=new Stack<>();
    Node5 head;
    Rev_LL(){
        head=null;
    }
    void Insert_LL_end(int data){
        Node5 newNode = new Node5(data);
        if(head==null){
            head = newNode;
        }
        else{
            Node5 Ptr = head;
            while(Ptr.next!=null){
                Ptr=Ptr.next;
            }
            Ptr.next=newNode;
        }
    }
    void rev_ll(){
        Node5 Ptr = head;
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
        Node5 Ptr = head;
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
        sc.close();
        sol.display_LL();
        System.out.println();
        sol.rev_ll();
    }
    
}
