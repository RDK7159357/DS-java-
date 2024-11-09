package week8;
class Node3 {
    int data;
    Node3 next, prev;
    Node3(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
public class DeleteOccurrenceInDoublyLinkedList {
    static Node3 deleteAllOccurOfX(Node3 head, int x) {
        while (head != null && head.data == x) {
            head = head.next;
            if (head != null) head.prev = null;
        }
        
        Node3 curr = head;
        while (curr != null && curr.next != null) {
            if (curr.next.data == x) {
                curr.next = curr.next.next;
                if (curr.next != null) curr.next.prev = curr;
            } else curr = curr.next;
        }
        return head;
    }
    
    static void printList(Node3 head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Node3 head = new Node3(2);
        head.next = new Node3(2);
        head.next.prev = head;
        head.next.next = new Node3(10);
        head.next.next.prev = head.next;
        head.next.next.next = new Node3(2);
        head.next.next.next.prev = head.next.next;
        
        System.out.print("Original: ");
        printList(head);
        
        head = deleteAllOccurOfX(head, 2);
        System.out.print("After deletion: ");
        printList(head);
    }
}