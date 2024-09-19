package week3;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int arr[]={4,3,2,6,8,1};
        int n=arr.length;
        // Bubblesort(arr, n);
        // Insertionsort(arr, n);
        Selectionsort(arr, n);
        System.out.println(Arrays.toString(arr));
    }
    public static void Bubblesort(int arr[],int n){
        int temp=0;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
    public static void Insertionsort(int arr[],int n){
        for(int i=1;i<n;i++){
            int key=arr[i];
            int j=i-1;
            while(j>=0 && arr[j]>key ){
                arr[j+1]=arr[j];
                j=j-1;
            }
            arr[j+1]=key;
        }
    }
    public static void Selectionsort(int arr[],int n){
        int minindex;
        for(int i=0;i<n-1;i++){
            minindex = i;
            for(int j=i;j<n;j++){
                if(arr[j]<arr[minindex]){
                    minindex= j;
                }
            }
            int temp = arr[i];
            arr[i]=arr[minindex];
            arr[minindex]=temp;
        }
    }
}
