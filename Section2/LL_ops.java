package Section2;

import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LL {
    Node head;

    void insert_ll_beg(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    void insert_ll_end(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        }
        Node ptr = head;
        while (ptr.next != null) {
            ptr = ptr.next;
        }
        ptr.next = newNode;
    }

    void insert_index(int index, int data) {
        int count = 0;
        Node ptr = head;
        Node newNode = new Node(data);
        if (index == 0) {
            insert_ll_beg(data);
            return;
        }
        while (ptr != null) {
            if (index == count - 1) {
                newNode.next = ptr.next;
                ptr.next = newNode;
                return;
            }
            ptr = ptr.next;
            count++;
        }
        System.out.println("Index out of bounds");
    }

    void remove_ll_beg() {
        if (head != null) {
            head = head.next;
        }
    }

    void remove_ll_end() {
        if (head == null) {
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node ptr = head;
        while (ptr.next.next != null) {
            ptr = ptr.next;
        }
        ptr.next = null;
    }

    void remove_ll_index(int index) {
        Node ptr = head;
        int count = 0;
        if (head == null) {
            System.out.println("Index out of bounds");
            return;
        }
        if (index == 0) {
            head = head.next;
        }
        while (ptr != null) {
            if (count == index - 1) {
                ptr.next = ptr.next.next;
                return;
            }
            ptr = ptr.next;
            count++;
        }
    }

    void printLL() {
        Node ptr = head;

        while (ptr != null) {
            System.out.print(ptr.data + " -> ");
            ptr = ptr.next;
        }
        System.out.println("null");
    }
}

public class LL_ops {
    public static void main(String[] args) {
        LL obj = new LL();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Insert at beginning");
            System.out.println("2. Insert at end");
            System.out.println("3. Insert at index");
            System.out.println("4. Remove from beginning");
            System.out.println("5. Remove from end");
            System.out.println("6. Remove from index");
            System.out.println("7. Print Linked List");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            switch (choice) {
                case 1: // Insert at beginning
                    System.out.print("Enter the value to insert: ");
                    int begData = sc.nextInt();
                    obj.insert_ll_beg(begData);
                    break;

                case 2: // Insert at end
                    System.out.print("Enter the value to insert: ");
                    int endData = sc.nextInt();
                    obj.insert_ll_end(endData);
                    break;

                case 3: // Insert at index
                    System.out.print("Enter the index to insert at: ");
                    int index = sc.nextInt();
                    System.out.print("Enter the value to insert: ");
                    int indexData = sc.nextInt();
                    obj.insert_index(index, indexData);
                    break;

                case 4: // Remove from beginning
                    obj.remove_ll_beg();
                    break;

                case 5: // Remove from end
                    obj.remove_ll_end();
                    break;

                case 6: // Remove from index
                    System.out.print("Enter the index to remove from: ");
                    int removeIndex = sc.nextInt();
                    obj.remove_ll_index(removeIndex);
                    break;

                case 7: // Print linked list
                    obj.printLL();
                    break;

                case 8: // Exit
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

}

