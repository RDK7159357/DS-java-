package week7;

import java.util.Scanner;

class Node2 {
    int data;
    Node2 next;

    Node2(int data) {
        this.data = data;
        this.next = null;
    }
}
public class ConvertLL_Bin {
    Node2 head;
    ConvertLL_Bin(){
        head = null;
    }
    public int getDecimalValue(Node2 head) {
        int decimalValue = 0;
        Node2 Ptr = head;
        
        while (Ptr != null) {
            decimalValue = (decimalValue << 1) | Ptr.data;
            Ptr = Ptr.next;
        }
        
        return decimalValue;
    }
    void Insert_LL_end(int data) {
        Node2 newNode = new Node2(data);
        if (head == null) {
            head = newNode;
        } else {
            Node2 Ptr = head;
            while (Ptr.next != null) {
                Ptr = Ptr.next;
            }
            Ptr.next = newNode;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ConvertLL_Bin sol = new ConvertLL_Bin();
        System.out.print("Enter size: ");
        int n = sc.nextInt();    
        System.out.println("Enter ele: ");
        for(int i=0;i<n;i++){
            sol.Insert_LL_end(sc.nextInt());
        }
        sc.close();
        System.out.println(sol.getDecimalValue(sol.head));
    }
    
}
