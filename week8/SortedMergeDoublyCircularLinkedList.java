package week8;

class Node2 {
    int data;
    Node2 next, prev;
    Node2(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class SortedMergeDoublyCircularLinkedList {
    static Node2 mergeUtil(Node2 first, Node2 second) {
        // If first list is empty
        if (first == null)
            return second;
 
        // If second list is empty
        if (second == null)
            return first;
 
        // Pick the smaller value
        Node2 head = null;
        if (first.data <= second.data) {
            head = first;
            first = first.next;
        } else {
            head = second;
            second = second.next;
        }
        
        Node2 curr = head;
        curr.prev = null;
        
        // Merge remaining nodes
        while (first != null && second != null) {
            if (first.data <= second.data) {
                curr.next = first;
                first.prev = curr;
                curr = first;
                first = first.next;
            } else {
                curr.next = second;
                second.prev = curr;
                curr = second;
                second = second.next;
            }
        }
        
        if (first != null) {
            curr.next = first;
            first.prev = curr;
            // Find the last node
            while (curr.next != null) {
                curr = curr.next;
            }
        }
        
        if (second != null) {
            curr.next = second;
            second.prev = curr;
            // Find the last node
            while (curr.next != null) {
                curr = curr.next;
            }
        }
        
        // Make it circular
        curr.next = head;
        head.prev = curr;
        
        return head;
    }

    static void printList(Node2 head) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node2 temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    public static void main(String[] args) {
        // First, convert the circular lists to linear lists for merging
        Node2 head1 = new Node2(1);
        Node2 second1 = new Node2(3);
        Node2 third1 = new Node2(5);
        
        head1.next = second1;
        second1.prev = head1;
        second1.next = third1;
        third1.prev = second1;
        
        Node2 head2 = new Node2(2);
        Node2 second2 = new Node2(4);
        Node2 third2 = new Node2(6);
        
        head2.next = second2;
        second2.prev = head2;
        second2.next = third2;
        third2.prev = second2;

        System.out.print("First List: ");
        Node2 curr = head1;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();

        System.out.print("Second List: ");
        curr = head2;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();

        // Merge lists
        Node2 mergedHead = mergeUtil(head1, head2);

        System.out.print("Merged List: ");
        printList(mergedHead);
    }
}