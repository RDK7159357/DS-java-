package Section1;

import java.util.*;

public class Fibsearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int key = sc.nextInt();
        int index = fibsearch(arr, key);
        if (index >= 0) {
            System.out.println(index);
        } else {
            System.out.println(-1);
        }
        sc.close();
    }

    public static int fibsearch(int[] arr, int key) {
        int n = arr.length;
        int fib1 = 0;
        int fib2 = 1;
        int fib = fib1 + fib2;

        // Find the smallest Fibonacci number greater than or equal to n
        while (fib < n) {
            fib1 = fib2;
            fib2 = fib;
            fib = fib1 + fib2;
        }

        // Initialize the offset
        int offset = -1;

        // Perform the search
        while (fib > 1) {
            int i = Math.min(offset + fib1, n - 1);

            if (key > arr[i]) {
                // Key is greater, move the window to the right
                // fib = fib2;
                // fib2 = fib1;
                // fib1 = fib - fib2;
                fib = fib1;
                fib1 = fib2;
                fib2 = fib - fib1;
                offset = i;
            } else if (key < arr[i]) {
                // Key is smaller, move the window to the left
                // fib = fib1;
                // fib2 = fib2 - fib1;
                // fib1 = fib - fib2;
                fib = fib2;
                fib1 = fib1 - fib;
                fib2 = fib - fib1;
            } else {
                // Key found
                return i;
            }
        }
        // Final check if the key is at the next position
        if (fib1 == 1 && arr[offset + 1] == key) {
            return offset + 1;
        }
        return -1;
    }
}
