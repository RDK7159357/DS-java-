package week3;
import java.util.Scanner;
public class selectionsort{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
    
        for (int i = 0; i < n; i++) {
          arr[i] = sc.nextInt();
        }
        sc.close();
        Selectionsort(arr, n);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
              System.out.print(", ");
            }
          }
        }
          public static void Selectionsort(int arr[],int n){
              int temp=0;
              int minindex;
              for(int i =0;i<n-1;i++){
                minindex =i;
                for(int j=i;j<n;j++){
                  if(arr[j]<arr[minindex]){
                    minindex =j;
                  }
                }
                temp=arr[i];
                arr[i]=arr[minindex];
                arr[minindex]=temp;


              }
          }
}