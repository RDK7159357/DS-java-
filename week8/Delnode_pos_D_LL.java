package week8;

class Noded {
    int data;
    Noded next, prev;
    Noded(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class Delnode_pos_D_LL {
    // Function to delete a given node from the doubly linked list
    static Noded deleteNode(Noded head, Noded del) {
        // If list or del is null, return
        if (head == null || del == null)
            return head;
        
        // If node to be deleted is head node
        if (head == del)
            head = del.next;
            
        // Change next only if node to be deleted is NOT the last node
        if (del.next != null)
            del.next.prev = del.prev;
            
        // Change prev only if node to be deleted is NOT the first node
        if (del.prev != null)
            del.prev.next = del.next;
            
        return head;
    }
    
    // Function to delete the node at given position
    static Noded deleteNodeAtGivenPos(Noded head, int n) {
        // If list is empty or invalid position, return
        if (head == null || n <= 0)
            return head;
            
        // Store head node
        Noded current = head;
        
        // Traverse to the nth node
        for (int i = 1; current != null && i < n; i++)
            current = current.next;
            
        // If position is more than number of nodes
        if (current == null)
            return head;
            
        // Delete the node pointed to by current
        return deleteNode(head, current);
    }
    
    // Function to print the doubly linked list
    static void printList(Noded head) {
        Noded current = head;
        System.out.print("Doubly Linked List: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}