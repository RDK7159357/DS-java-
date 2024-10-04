package week6;

public class Queue_ops {
    public static void main(String[] args) {
        LinearQueue queue = new LinearQueue(5);
        queue.enqueue(2);
        queue.enqueue(6);
        queue.enqueue(8);
        queue.enqueue(1);
        queue.dequeue();
        queue.display();
    } 
}
class LinearQueue
{
    public  int front=-1;
    public  int rear=-1;
    public  int MAX;
    public  int[] Qarr; 
    public LinearQueue(int size){
        MAX=size;
        Qarr = new int[size];
        front=0;
        rear=0;
    }
public  boolean isEmpty() {
    return front == rear;
}
public  boolean isFull() {
    return rear == MAX;
}
public  void enqueue(int item)
{
    if(isFull()){
        System.out.print("Queue Overflow");
    }else{
        Qarr[rear++]=item;
    }
}
public void dequeue() {
    if (isEmpty()) {
        System.out.println("Queue Underflow");
    } else {
        int item = Qarr[front];
        System.out.println("Dequeued element: " + item);
        if (front >= rear) {
            front = -1;
            rear = -1;
        } else {
            front++;
        }
    }
}
public  void display(){
    if(isEmpty()){
        System.out.println("Queue is empty");
    }
    else{
        for(int i=front;i<=rear;i++){
            System.out.print(Qarr[i]+" ");
        }
    }

}
}

