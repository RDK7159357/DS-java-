import java.util.Scanner;

public class UBsearch {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    int key = sc.nextInt();
    // int result = uniformBinarySearch(arr, key);
    System.out.println(uniformBinarySearch(arr, key));
  }

  static int MAX_SIZE = 1000;
  static int[] lookup_table = new int[MAX_SIZE];

  public static void create_table(int n) {
    int pow = 1;
    int co = 0;
    do {
      pow <<= 1;
      lookup_table[co] = (n + (pow >> 1)) / pow;
    } while (lookup_table[co++] != 0);
  }

  public static int uniformBinarySearch(int[] arr, int key) {
    create_table(arr.length);
    int index = lookup_table[0] - 1;
    int co = 0;
    while (lookup_table[co] != 0) {
      if (key == arr[index]) {
        return index;
      } else if (key < arr[index]) {
        index -= lookup_table[++co];
      } else {
        index += lookup_table[++co];
      }
    }
    return index;
  }

}