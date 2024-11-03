package week7;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Remove_LL_ele {
    
    // Method to remove all nodes with a specified value
    public ListNode removeElements(ListNode head, int val) {
        // Dummy node to handle cases where the head itself needs to be removed
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        while (current.next != null) {
            if (current.next.val == val) {
                // Skip the node with the matching value
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return dummy.next; // Return the new head (skipping any nodes removed at the head)
    }

    public static void main(String[] args) {
        Remove_LL_ele solution = new Remove_LL_ele();

        // Example 1: head = [1, 2, 6, 3, 4, 5, 6], val = 6
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(6);
        head1.next.next.next = new ListNode(3);
        head1.next.next.next.next = new ListNode(4);
        head1.next.next.next.next.next = new ListNode(5);
        head1.next.next.next.next.next.next = new ListNode(6);

        ListNode newHead1 = solution.removeElements(head1, 6);
        System.out.print("List after removing 6: ");
        printList(newHead1); // Expected Output: [1, 2, 3, 4, 5]

        // Example 2: head = [], val = 1
        ListNode head2 = null;
        ListNode newHead2 = solution.removeElements(head2, 1);
        System.out.print("List after removing 1 from empty list: ");
        printList(newHead2); // Expected Output: []

        // Example 3: head = [7, 7, 7, 7], val = 7
        ListNode head3 = new ListNode(7);
        head3.next = new ListNode(7);
        head3.next.next = new ListNode(7);
        head3.next.next.next = new ListNode(7);

        ListNode newHead3 = solution.removeElements(head3, 7);
        System.out.print("List after removing 7: ");
        printList(newHead3); // Expected Output: []

    }
    
    // Helper method to print the linked list
    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
