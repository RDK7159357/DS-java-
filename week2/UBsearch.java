package week2;
import java.util.Scanner;
public class UBsearch {
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter size of arr: ");
    int n = sc.nextInt();
    int arr[] = new int[n];
    for(int i = 0 ;i<n;i++){
      array[i] = sc.nextInt();
    }
    System.out.print("Enter key: ");
    int key = sc.nextInt();
    // System.out.print(Linearsearch(arr,n,key));
    // System.out.print(UBinSearchRecursive(arr, n, key, 0));
    int[] lookupTable = createLookupTable(array.length);

    int result = recursiveUniformBinarySearch(array, key, lookupTable, array.length / 2);

    if (result != -1) {
        System.out.println("Position of " + key + " in array = " + (result + 1));
    } else {
        System.out.println(key + " not found in array");
    }
    sc.close();
  }
  public static int[] createLookupTable(int size) {
    int[] lookupTable = new int[size];
    for (int i = 0; i < size; i++) {
        lookupTable[i] = (i + size) / 2;
    }
    return lookupTable;
}
public static int recursiveUniformBinarySearch(int[] arr, int key, int[] lookupTable, int index) {
  // Base case: If the index is out of bounds, the key is not found.
  if (index >= arr.length || index < 0) {
      return -1;
  }

  // If the key is found at the current index, return the index.
  if (arr[index] == key) {
      return index;
  }

  // If the key is less than the current element, move to the left half.
  if (arr[index] > key) {
      return recursiveUniformBinarySearch(arr, key, lookupTable, lookupTable[index]);
  }

  // If the key is greater than the current element, move to the right half.
  return recursiveUniformBinarySearch(arr, key, lookupTable, index + (index - lookupTable[index]));
}
}