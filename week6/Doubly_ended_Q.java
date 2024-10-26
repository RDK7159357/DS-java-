package week6;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Arrays;
public class Doubly_ended_Q {
    public static void main(String[] args) {
        // Initialize an empty deque
        Deque<Integer> deque = new ArrayDeque<>();
        // 1. append(): Add elements to the right end
        deque.addLast(10);
        deque.addLast(20);
        System.out.println("After append (addLast): " + deque);
        // 2. appendleft(): Add elements to the left end
        deque.addFirst(5);
        System.out.println("After appendleft (addFirst): " + deque);
        // 3. pop(): Remove element from the right end
        int popped = deque.removeLast();
        System.out.println("Popped from right: " + popped);
        System.out.println("After pop: " + deque);
        // 4. popleft(): Remove element from the left end
        int poppedLeft = deque.removeFirst();
        System.out.println("Popped from left: " + poppedLeft);
        System.out.println("After popleft: " + deque);
        // Add elements to demonstrate further operations
        deque.addAll(Arrays.asList(30, 40, 50, 60, 70));
        System.out.println("Deque after adding elements: " + deque);
        // 5. index(ele): Get the index of an element (convert to a list)
        List<Integer> list = new ArrayList<>(deque);
        int index = list.indexOf(50); // Now it works
        System.out.println("Index of 50: " + index);
        // 6. insert(i, a): Insert value at a specific index (use the list)
        list.add(3, 35); // Insert 35 at index 3
        System.out.println("After inserting 35 at index 3: " + list);
        // Copy the modified list back to the deque
        deque = new ArrayDeque<>(list);
        // 7. remove(): Remove the first occurrence of a value
        deque.remove(40);
        System.out.println("After removing 40: " + deque);
        // 8. count(): Count the occurrences of a value
        deque.add(30); // Add duplicate element for count demonstration
        long count = deque.stream().filter(e -> e == 30).count();
        System.out.println("Count of 30: " + count);
        // 9. len(deque): Get the size of the deque
        System.out.println("Current size of deque: " + deque.size());
        // 10. Deque[0]: Access the front element
        System.out.println("Front element (Deque[0]): " + deque.peekFirst());
        // 11. Deque[-1]: Access the back element
        System.out.println("Back element (Deque[-1]): " + deque.peekLast());
        // 12. extend(iterable): Add multiple elements to the right end
        deque.addAll(Arrays.asList(80, 90));
        System.out.println("After extend (addAll to right): " + deque);
        // 13. extendleft(iterable): Add multiple elements to the left end (in reverse order)
        Arrays.asList(1, 2, 3).forEach(deque::addFirst);
        System.out.println("After extendleft: " + deque);
        // 14. reverse(): Reverse the order of elements
        Deque<Integer> reversedDeque = new ArrayDeque<>();
        deque.descendingIterator().forEachRemaining(reversedDeque::add);
        System.out.println("Reversed deque: " + reversedDeque);
        // 15. rotate(): Rotate the deque
        rotate(deque, 2); // Rotate right by 2
        System.out.println("After rotating right by 2: " + deque);
        rotate(deque, -3); // Rotate left by 3
        System.out.println("After rotating left by 3: " + deque);
    }
    // Helper function to rotate the deque
    public static void rotate(Deque<Integer> deque, int steps) {
        if (steps > 0) {
            for (int i = 0; i < steps; i++) {
                deque.addFirst(deque.removeLast()); // Rotate right
            }
        } else {
            for (int i = 0; i < Math.abs(steps); i++) {
                deque.addLast(deque.removeFirst()); // Rotate left
            }
        }
    }
}
