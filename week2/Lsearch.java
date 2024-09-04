package week2;
import java.util.Scanner;
public class Lsearch {
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
    // System.out.print(Linearsearch(arr,n,key));
    System.out.print(LinearSearchRecursive(arr, n, key, 0));
    sc.close();
  }
  // public static int Linearsearch(int arr[],int n, int key){
  //   for(int i =0;i<n;i++){
  //     if( arr[i]==key){
  //       return i;
  //     }
    
  //   }  
  //   return -1;
  //   }
  public static int LinearSearchRecursive(int arr[], int n, int key, int index) {
    if (index >= n) {
        return -1; // not found
    }
    if (arr[index] == key) {
        return index;
    }
    return LinearSearchRecursive(arr, n, key, index + 1);
}
  }
  
