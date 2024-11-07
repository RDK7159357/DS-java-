package week8;
import java.util.Scanner;


class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class Doubly_LL {
    Node head;
    int ctr;

    Doubly_LL() {
        this.head = null;
        this.ctr = 0;
    }

    // Insert a node at the beginning
    void insertBeg(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        ctr++;
    }

    // Insert a node at the end
    void insertEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
        ctr++;
    }

    // Delete a node from the beginning
    void deleteBeg() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        head = head.next;
        if (head != null) {
            head.prev = null;
        }
        ctr--;
    }

    // Delete a node from the end
    void deleteEnd() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.next == null) {  // Only one node in the list
            head = null;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.prev.next = null;
        }
        ctr--;
    }

    // Insert a node at a specific position
    void insertPos(int pos, int data) {
        if (pos < 1 || pos > ctr + 1) {
            System.out.println("Invalid position.");
            return;
        }

        Node newNode = new Node(data);
        if (pos == 1) {
            insertBeg(data);
        } else {
            Node temp = head;
            for (int i = 1; i < pos - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            newNode.prev = temp;
            if (temp.next != null) {
                temp.next.prev = newNode;
            }
            temp.next = newNode;
            ctr++;
        }
    }

    // Delete a node from a specific position
    void deletePos(int pos) {
        if (pos < 1 || pos > ctr) {
            System.out.println("Invalid position.");
            return;
        }

        if (pos == 1) {
            deleteBeg();
        } else {
            Node temp = head;
            for (int i = 1; i < pos; i++) {
                temp = temp.next;
            }
            if (temp.next != null) {
                temp.next.prev = temp.prev;
            }
            if (temp.prev != null) {
                temp.prev.next = temp.next;
            }
            ctr--;
        }
    }

    // Traverse the list forward
    void traverseF() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Traverse the list in reverse
    void traverseR() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Doubly_LL list = new Doubly_LL();

        boolean exit = false;
        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Insert at beginning");
            System.out.println("2. Insert at end");
            System.out.println("3. Insert at position");
            System.out.println("4. Delete from beginning");
            System.out.println("5. Delete from end");
            System.out.println("6. Delete from position");
            System.out.println("7. Traverse forward");
            System.out.println("8. Traverse reverse");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data: ");
                    int dataBeg = scanner.nextInt();
                    list.insertBeg(dataBeg);
                    break;
                case 2:
                    System.out.print("Enter data: ");
                    int dataEnd = scanner.nextInt();
                    list.insertEnd(dataEnd);
                    break;
                case 3:
                    System.out.print("Enter position: ");
                    int pos = scanner.nextInt();
                    System.out.print("Enter data: ");
                    int dataPos = scanner.nextInt();
                    list.insertPos(pos, dataPos);
                    break;
                case 4:
                    list.deleteBeg();
                    break;
                case 5:
                    list.deleteEnd();
                    break;
                case 6:
                    System.out.print("Enter position: ");
                    int posDel = scanner.nextInt();
                    list.deletePos(posDel);
                    break;
                case 7:
                    list.traverseF();
                    break;
                case 8:
                    list.traverseR();
                    break;
                case 9:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }
}
