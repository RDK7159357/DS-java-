package test;
import java.util.*;
public class Linkedlist {
    public static void main(String[] args) {
        SingleLinkedList obj = new SingleLinkedList();
        // obj.Create();
        // obj.traverse();   
        int arr[]={1,2,3,4,5,6,7};
        obj.create_listoddno(arr);
        obj.traverse();
    }  
}
class Node {
int data;
Node next;
Node(int data){
    this.data=data;
    this.next=null;
}
}

class SingleLinkedList{
    Node head ;
    Scanner sc;
    SingleLinkedList(){
        head =null;
        sc=new Scanner(System.in);
    }
    void Create(){
        for(int i=0;i<5;i++){
            int d=sc.nextInt();
            Node newNode=new Node(d);
            if(head==null){
                head=newNode;
            }
            else{
                Node t;
                t=head;
                while(t.next!=null){
                    t=t.next;
                }
                t.next=newNode;//attach node at end of list
            }
        }
    }
    void traverse(){
        Node t;
        t=head;
        System.out.println("\n Linked list data: ");
        while(t!=null){
            System.out.print(t.data+" -> ");
            t=t.next;
        }
        System.out.println("X");
    }
    void create_list(int arr[]){
        int n=arr.length;
        int cmt=0;
        for(int i=0;i<n;i++){
            cmt++;
            Node newnode = new Node(arr[i]);
            if(head==null){
                head = newnode;
            }
            else{
                Node t;
                t=head;
                while(t.next!=null){
                    t=t.next;
                }
                t.next=newnode;
            }
        }
        System.out.println("No of Nodes: "+cmt);
        return;
    }
    void create_listoddno(int arr[]){
        int n = arr.length;
        int cmt=0;
        for(int i=0;i<n;i++){
            cmt++;
            if(arr[i]%2==1){

                Node newnode= new Node(arr[i]);
                if(head==null){
                    head=newnode;
                }
                else{
                    Node t;
                    t=head;
                    while(t.next!=null){
                        t=t.next;
                    }
                    t.next=newnode;
                }
            }

        }
        System.out.println("No of nodes: "+cmt);
        return;

    }
    void create_listevenno(int arr[]){
        int n = arr.length;
        int cmt=0;
        for(int i=0;i<n;i++){
            cmt++;
            if(arr[i]%2==0){
                Node newnode= new Node(arr[i]);
                if(head==null){
                    head=newnode;
                }
                else{
                    Node t;
                    t=head;
                    while(t.next!=null){
                        t=t.next;
                    }
                    t.next=newnode;
                }
            }
        }
        System.out.println("No of nodes: "+cmt);
        return;

    }
    void insert_at_beg(int d){
        Node newnode=new Node(d);
        newnode.next=head;
        head=newnode;
    }
    void insert_at_end(int d) {
        Node newnode = new Node(d);  // Create a new node with the given data
        
        if (head == null) {  // Case 1: The list is empty
            head = newnode;  // The new node becomes the head of the list
        } else {
            Node t = head;  // Start from the head node
            
            // Traverse to the last node
            while (t.next != null) {
                t = t.next;
            }
            
            // Attach the new node at the end
            t.next = newnode;
        }
    }
    

}
