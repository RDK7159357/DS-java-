package week7;

class Node {
    String data;
    Node next;

    Node(String data) {
        this.data = data;
        this.next = null;
    }
}

public class Singlylinkedlist {
    private Node head;

    // Insert a node at the end of the linked list
    public void insertAtEnd(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node ptr = head;
            while (ptr.next != null) {
                ptr = ptr.next;
            }
            ptr.next = newNode;
        }
    }

    // Update the value of a node at a specified index
    public void updateNode(String val, int index) {
        Node ptr = head;
        int count = 0;

        while (ptr != null) {
            if (count == index) {
                ptr.data = val;
                return;
            }
            count++;
            ptr = ptr.next;
        }

        System.out.println("Index out of bounds");
    }

    // Remove the first node of the linked list
    public void removeFirstNode() {
        if (head != null) {
            head = head.next;
        }
    }

    // Remove the last node of the linked list
    public void removeLastNode() {
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

    // Remove a node at a specified index
    public void removeAtIndex(int index) {
        if (head == null) {
            return;
        }

        if (index == 0) {
            removeFirstNode();
            return;
        }

        Node ptr = head;
        int count = 0;

        while (ptr != null && ptr.next != null) {
            if (count == index - 1) {
                ptr.next = ptr.next.next;
                return;
            }
            count++;
            ptr = ptr.next;
        }

        System.out.println("Index out of bounds");
    }

    // Remove a node with a specified value
    public void removeNode(String data) {
        if (head == null) {
            return;
        }

        if (head.data.equals(data)) {
            head = head.next;
            return;
        }

        Node ptr = head;

        while (ptr.next != null) {
            if (ptr.next.data.equals(data)) {
                ptr.next = ptr.next.next;
                return;
            }
            ptr = ptr.next;
        }

        System.out.println("Node not found");
    }

    // Return the size of the linked list
    public int sizeOfLL() {
        int size = 0;
        Node ptr = head;

        while (ptr != null) {
            size++;
            ptr = ptr.next;
        }

        return size;
    }

    // Print all nodes in the linked list
    public void printLL() {
        Node ptr = head;

        while (ptr != null) {
            System.out.print(ptr.data + " -> ");
            ptr = ptr.next;
        }
        System.out.println("null");
    }

    // Main method to test the linked list
    public static void main(String[] args) {
        Singlylinkedlist list = new Singlylinkedlist();

        // Insert elements at the end
        list.insertAtEnd("Node1");
        list.insertAtEnd("Node2");
        list.insertAtEnd("Node3");

        // Print linked list
        System.out.print("Linked List: ");
        list.printLL();

        // Update a node
        list.updateNode("UpdatedNode2", 1);
        System.out.print("After updating index 1: ");
        list.printLL();

        // Remove the first node
        list.removeFirstNode();
        System.out.print("After removing first node: ");
        list.printLL();

        // Remove the last node
        list.removeLastNode();
        System.out.print("After removing last node: ");
        list.printLL();

        // Insert a new element and print size
        list.insertAtEnd("Node4");
        System.out.print("After inserting Node4: ");
        list.printLL();
        System.out.println("Size of Linked List: " + list.sizeOfLL());

        // Remove a node by value
        list.removeNode("Node4");
        System.out.print("After removing Node4: ");
        list.printLL();

        // Remove at index
        list.removeAtIndex(0);
        System.out.print("After removing at index 0: ");
        list.printLL();
    }
}
