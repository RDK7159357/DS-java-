package week7;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class ConvertLL_Bin {
    Node head;
    ConvertLL_Bin(){
        head = null;
    }
    public int getDecimalValue(Node head) {
        int decimalValue = 0;
        Node Ptr = head;
        
        while (Ptr != null) {
            decimalValue = (decimalValue << 1) | Ptr.data;
            Ptr = Ptr.next;
        }
        
        return decimalValue;
    }
    void Insert_LL_end(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node Ptr = head;
            while (Ptr.next != null) {
                Ptr = Ptr.next;
            }
            Ptr.next = newNode;
        }
    }
    public static void main(String[] args) {
        ConvertLL_Bin sol = new ConvertLL_Bin();
        sol.Insert_LL_end(0);
        sol.Insert_LL_end(1);
        sol.Insert_LL_end(0);
        System.out.println(sol.getDecimalValue(sol.head));
    }
    
}
