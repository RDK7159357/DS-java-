package test;
import java.util.*;
public class Linkedlist_assign {
    public static void main(String[] args) {
        SingleLinkedList even = new SingleLinkedList();
        SingleLinkedList odd = new SingleLinkedList();
        int arr[]={1,2,3,4,5,6,7,8,9};
        for(int num: arr){
            if(num%2==0){
                even.insert_at_end(num);
            }
            else{
                odd.insert_at_end(num);
            }
        }
        // Traverse and print both linked lists
        System.out.println("Odd number linked list:");
        odd.traverse();
        System.out.println("\nEven number linked list:");
        even.traverse();
    }
}
class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}
class SingleLinkedList{
    Node head;
    Scanner sc;
    SingleLinkedList(){
        head=null;
        sc=new Scanner(System.in);
    }
    void create(){
        for(int i=0;i<5;i++){
            int d=sc.nextInt();
            Node newnode = new Node(d);
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
    void traverse(){
        Node t;
        t=head;
        System.out.println("\nLinked list data: ");
        while(t!=null){
            System.out.print(t.data+"->");
            t=t.next;
        }
        System.out.print("X");
    }
    void Createofarr(int arr[]){  
        int n = arr.length;
        for(int i=0;i<n;i++){
            Node newnode = new Node(arr[i]);
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
    void insert_at_end(int d){
        Node newnode = new Node(d);
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