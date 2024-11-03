package week7;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Linked_list_cycle {
    
    // Method to detect a cycle in the linked list
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false; // No cycle
            }
            slow = slow.next;         // Move slow pointer by 1
            fast = fast.next.next;     // Move fast pointer by 2
        }

        return true; // Cycle detected
    }

    public static void main(String[] args) {
        Linked_list_cycle solution = new Linked_list_cycle();

        // Example 1: head = [3, 2, 0, -4], pos = 1
        ListNode head1 = new ListNode(3);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(0);
        head1.next.next.next = new ListNode(-4);
        head1.next.next.next.next = head1.next; // Creates a cycle

        System.out.println("Cycle in list 1: " + solution.hasCycle(head1)); // Output: true

        // Example 2: head = [1, 2], pos = 0
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = head2; // Creates a cycle

        System.out.println("Cycle in list 2: " + solution.hasCycle(head2)); // Output: true

        // Example 3: head = [1], pos = -1
        ListNode head3 = new ListNode(1);

        System.out.println("Cycle in list 3: " + solution.hasCycle(head3)); // Output: false
    }
}
