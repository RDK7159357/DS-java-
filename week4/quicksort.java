package week4;
import java.util.Arrays;
import java.util.Scanner;
public class quicksort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        sc.close();
        System.out.println("Unsorted arr: "+Arrays.toString(arr));
        Quicksort(arr,0,arr.length-1);
        System.out.println("Sorted arr: "+Arrays.toString(arr));
    }
    public static void Quicksort(int arr[],int low, int high){
        if(low<high){
            int pivotindex=partition(arr,low,high);
            Quicksort(arr,low,pivotindex-1);
            Quicksort(arr, pivotindex+1, high);
        }
    }
    public static void swap(int arr[],int i,int j){
        int temp =arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static int partition(int arr[],int low , int high){
        int pivot = arr[low];
        int up =low;
        int down = high;
        while(up<down){
            while(arr[up]<=pivot && up<high){
                up++;
            }
            while(arr[down]>pivot){
                down--;
            }
            if(up<down){
                swap(arr,up,down);
            }
        }
        swap(arr,low,down);
        return down;
    }
}
