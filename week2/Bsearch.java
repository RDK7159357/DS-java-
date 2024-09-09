import java.util.Scanner;// Please make sure that the class name is 'Main'
class Bsearch{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
	        String s = sc.nextLine();
        int key = sc.nextInt();
        String[] srr = s.split(",");
        int n = srr.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(srr[i].trim());
        }
           int low = 0;
    int high = n-1;
    System.out.print(binarySearchRecursive(arr, low, high, key));
        sc.close();
		//write your code here
	}  public static int binarySearchRecursive(int arr[], int low, int high, int key) {
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