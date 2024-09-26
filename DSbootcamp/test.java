package DSbootcamp;
import java.util.Arrays;
import java.util.Scanner;
public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        sc.close();
        System.out.println("Unsorted arr: "+Arrays.toString(arr));
        MergeSort(arr,0,arr.length-1);
        Shellsort(arr);
        Quicksort(arr, 0, arr.length-1);
        System.out.println("Sorted arr: "+Arrays.toString(arr));
    }
    public static void MergeSort(int arr[],int left,int right){
        if(left<right){
           int  mid=(left+right)/2;
            MergeSort(arr, left, mid);
            MergeSort(arr, mid+1, right);
            merge(arr, left, mid, right);
        }
    }
    public static void merge(int arr[],int left,int mid,int right){
        int n1=mid-left+1;
        int n2=right-mid;
        int Larr[]=new int[n1];
        int Rarr[]=new int[n2];
        System.arraycopy(arr, left, Larr, 0, n1);
        System.arraycopy(arr, mid+1, Rarr, 0, n2);
        int i=0,j=0,k=left;
        while(i<n1 && j<n2){
            if(Larr[i]<=Rarr[j]){
                arr[k]=Larr[i];
                i++;
            }
            else{
                arr[k]=Rarr[j];
                j--;
            }
            k++;
        }
        while(i<n1){
            arr[k]=Larr[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k]=Rarr[j];
            j++;
            k++;
        }
    }
    public static void Shellsort(int arr[]){
        for(int gap=(arr.length/2);gap>0;gap/=2){
            for(int i=gap;i<arr.length;i++){
                int temp= arr[i];
                int j;
                for(j=i;j>=gap&&arr[j]<arr[j-gap];j-=gap){
                    arr[j]=arr[j-gap];
                }
                arr[j]=temp;
            }
        }
    }
    public static void Quicksort(int arr[],int low,int high){
        if(low<high){
            int pivotIndex = partition(arr, low, high);
            Quicksort(arr, low, pivotIndex-1);
            Quicksort(arr, pivotIndex+1, high);
        }
    }
    public static int partition(int arr[],int low,int high){
        int pivotIndex = arr[low];
        int i=low+1;
        int j = high;
        while(i<=j){
            while(i<=j && arr[i]<arr[pivotIndex]) i++; 
            while(i<=j && arr[j]>arr[pivotIndex]) j--; 
            if(i<=j) swap(arr,i,j);
        }
        swap(arr,low,j);
        return j;
    }
    public static void swap(int arr[],int i ,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
