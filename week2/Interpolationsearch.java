import java.util.Scanner;
class Interpolationsearch{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
	      int n =sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }        
        int key = sc.nextInt();
        int low = 0;
    int high = n-1;
    System.out.print(Interpolation(arr, low, high, key));
        sc.close();
		//write your code here
	}  public static int Interpolation(int arr[], int low, int high, int key) {
    int res =-1;
    if (low > high) {
        return -1;
    }
    int mid = (low + (((high-low)*(key-arr[low]))/(arr[high]-arr[low])));
    if (arr[mid] == key) {
        res= mid;
    } else if (arr[mid] > key) {
        high=mid-1; 
    } else {
        low=mid+1;
    }
    return res;
}
}