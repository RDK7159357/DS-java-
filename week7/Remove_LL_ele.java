package week7;

import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Remove_LL_ele {
    ListNode head;

    // Constructor to initialize an empty linked list
    Remove_LL_ele() {
        head = null;
    }

    // Method to insert a node at the end of the linked list
    void insertAtEnd(int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = newNode;
        } else {
            ListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
    
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
    
    // Helper method to print the linked list
    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Remove_LL_ele sol = new Remove_LL_ele();

        // Taking input for the linked list
        System.out.print("Enter the number of elements in the list: ");
        int n = sc.nextInt();
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            sol.insertAtEnd(sc.nextInt());
        }

        // Taking input for the value to remove
        System.out.print("Enter the value to remove: ");
        int val = sc.nextInt();
        sc.close();

        // Removing specified elements and displaying the modified list
        ListNode newHead = sol.removeElements(sol.head, val);
        System.out.print("List after removing " + val + ": ");
        printList(newHead);
    }
}