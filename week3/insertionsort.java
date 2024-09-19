package week3;
import java.util.Scanner;
public class insertionsort{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
          arr[i] = sc.nextInt();
        }
        sc.close();
        Insertionsort(arr, n);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
              System.out.print(", ");
            }
          }
    }
    public static void Insertionsort(int arr[],int n){
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            // Move elements of arr[0..i-1], that are greater than key,
            // to one position ahead of their current position
            while (j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}