package week7;

import java.util.Scanner;

class Node3 {
    int data;
    Node3 next;

    Node3(int data) {
        this.data = data;
        this.next = null;
    }
}
public class Middle_LL {
    Node3 head;

    Middle_LL() {
        head = null;
    }

    void Insert_LL_end(int data) {
        Node3 newNode = new Node3(data);
        if (head == null) {
            head = newNode;
        } else {
            Node3 Ptr = head;
            while (Ptr.next != null) {
                Ptr = Ptr.next;
            }
            Ptr.next = newNode;
        }
    }
    void Print_Middle(Node3 head){
        Node3 slow = head;
        Node3 fast = head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        System.out.println(slow.data);
    }
    public static void main(String[] args) {
           Middle_LL sol = new Middle_LL();
           Scanner sc = new Scanner(System.in);
        System.out.print("Enter size: ");
        int n = sc.nextInt();    
      
        for(int i=0;i<n;i++){
            sol.Insert_LL_end(sc.nextInt());
        }
   
        sc.close();
        sol.Print_Middle(sol.head);
    }
    
}
