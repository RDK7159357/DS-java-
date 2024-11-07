package week8;
import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Circular_LL {
    private Node head;

    // Insert a node at the end of the linked list
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;  // Single-node circular link
        } else {
            Node ptr = head;
            while (ptr.next != head) {  // Find the last node
                ptr = ptr.next;
            }
            ptr.next = newNode;
            newNode.next = head;  // Complete the circle
        }
    }

    // Insert a node at the beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Node ptr = head;
            while (ptr.next != head) {  // Find the last node
                ptr = ptr.next;
            }
            ptr.next = newNode;
            newNode.next = head;
            head = newNode;  // Update head to new node
        }
    }

    // Insert a node in between the nodes after a specific item
    public void insertAfter(int data, int item) {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        Node ptr = head;
        do {
            if (ptr.data == item) {  // Found the item
                Node newNode = new Node(data);
                newNode.next = ptr.next;
                ptr.next = newNode;
                return;
            }
            ptr = ptr.next;
        } while (ptr != head);

        System.out.println("Item " + item + " not found in the list.");
    }

    // Delete a node at the beginning
    public void deleteAtBeginning() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        if (head.next == head) {  // Only one node in the list
            head = null;
        } else {
            Node ptr = head;
            while (ptr.next != head) {
                ptr = ptr.next;
            }
            ptr.next = head.next;  // Update last node's next
            head = head.next;  // Move head to next node
        }
    }

    // Delete a node at the end
    public void deleteAtEnd() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        if (head.next == head) {  // Only one node in the list
            head = null;
        } else {
            Node ptr = head;
            Node prev = null;
            while (ptr.next != head) {
                prev = ptr;
                ptr = ptr.next;
            }
            prev.next = head;  // Update second-last node's next to head
        }
    }

    // Delete a node with a given key
    public void deleteNode(int key) {
        if (head == null) {  // List is empty
            System.out.println("The list is empty.");
            return;
        }
        if (head.data == key) {  // Key is in the head node
            deleteAtBeginning();
            return;
        }

        Node curr = head;
        Node prev = null;
        do {
            prev = curr;
            curr = curr.next;
            if (curr.data == key) {  // Found the node with the key
                prev.next = curr.next;  // Bypass the current node
                return;
            }
        } while (curr != head);

        System.out.println("Node with key " + key + " not found.");
    }

    // Traverse and print the circular linked list
    public void printLL() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        Node ptr = head;
        do {
            System.out.print(ptr.data + " -> ");
            ptr = ptr.next;
        } while (ptr != head);
        System.out.println("Back to head");
    }

    public static void main(String[] args) {
        Circular_LL sol = new Circular_LL();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Insert at beginning");
            System.out.println("2. Insert at end");
            System.out.println("3. Insert after a specific node");
            System.out.println("4. Delete at beginning");
            System.out.println("5. Delete at end");
            System.out.println("6. Delete a specific node");
            System.out.println("7. Display the list");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data to insert at beginning: ");
                    int dataBeg = scanner.nextInt();
                    sol.insertAtBeginning(dataBeg);
                    break;
                case 2:
                    System.out.print("Enter data to insert at end: ");
                    int dataEnd = scanner.nextInt();
                    sol.insertAtEnd(dataEnd);
                    break;
                case 3:
                    System.out.print("Enter the data to insert: ");
                    int dataAfter = scanner.nextInt();
                    System.out.print("Enter the item after which to insert: ");
                    int item = scanner.nextInt();
                    sol.insertAfter(dataAfter, item);
                    break;
                case 4:
                    sol.deleteAtBeginning();
                    break;
                case 5:
                    sol.deleteAtEnd();
                    break;
                case 6:
                    System.out.print("Enter the key to delete: ");
                    int key = scanner.nextInt();
                    sol.deleteNode(key);
                    break;
                case 7:
                    sol.printLL();
                    break;
                case 8:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }
}
