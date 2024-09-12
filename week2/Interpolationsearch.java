import java.util.Scanner;

public class Interpolationsearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int key = sc.nextInt();
        int low = 0;
        int high = n - 1;
        System.out.print(Interpolation(arr, low, high, key));
        sc.close();
        // write your code here
    }

    public static int Interpolation(int arr[], int low, int high, int key) {

        while (low <= high) {
            int mid = (low + (((high - low) * (key - arr[low])) / (arr[high] - arr[low])));
            if (key < arr[low] || key > arr[high]) {
                return -1; // key is out of range
            }
            if (arr[mid] == key) {
                return mid;
            }
            if (arr[mid] > key) {
                high = mid - 1;
            } else if (arr[mid] < key) {
                low = mid + 1;
            }

        }
        return -1;

    }
}