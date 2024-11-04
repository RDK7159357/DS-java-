package week7;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class Middle_LL {
    Node head;

    Middle_LL() {
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
    void Print_Middle(Node head){
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        System.out.println(slow.data);
    }
    public static void main(String[] args) {
        Middle_LL sol = new Middle_LL();
        sol.Insert_LL_end(0);
        sol.Insert_LL_end(2);
        sol.Insert_LL_end(3);
        sol.Insert_LL_end(5);
        sol.Print_Middle(sol.head);
    }
    
}
