import java.util.Scanner;
import java.util.Arrays;// Please make sure that the class name is 'Main'

public class Bsearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int key = sc.nextInt();
        Arrays.sort(arr);
        int low = 0;
        int high = n - 1;
        System.out.print(binarySearchRecursive(arr, low, high, key));
        sc.close();
        // write your code here
    }

    public static int binarySearchRecursive(int arr[], int low, int high, int key) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (arr[mid] == key) {
            return mid;
        } else if (arr[mid] > key) {
            return binarySearchRecursive(arr, low, mid - 1, key);
        } else {
            return binarySearchRecursive(arr, mid + 1, high, key);
        }
    }
}