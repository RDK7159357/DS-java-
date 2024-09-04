package week2;
import java.util.Scanner;
public class Bsearch {
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter size of arr: ");
    int n = sc.nextInt();
    int arr[] = new int[n];
    for(int i = 0 ;i<n;i++){
      arr[i] = sc.nextInt();
    }
    System.out.print("Enter key: ");
    int key = sc.nextInt();
    int low = arr[0];
    int high = arr[n-1];
    System.out.print(binarySearchRecursive(arr, low, high, key));
    // System.out.print(Binarysearch(arr,n,key));
    sc.close();
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
//   public static int Binarysearch(int arr[],int n, int key){
//     int low = 0;
//     int high = arr[n-1];
//     int mid = 0;
//     while(low<=high){
//       mid = (low + high)/2;
//       if (arr[mid]>key){
//         high = mid-1;
//       }
//       else if (arr[mid]<key){
//         low  = mid +1;
//       }
//       else{
//         return mid;
//       }
//     }
//     return -1;
// }
}
