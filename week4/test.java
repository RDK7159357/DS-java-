package week4;
import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int arr[]={5,8,3,9,10};
        MergeSort(arr, 0, arr.length);
        Quicksort(arr, 0, arr.length-1);
        shellsort(arr);
        radixsort(arr);
        
    }
    public static void MergeSort(int arr[],int left,int right){
        if(left<right){
            int mid=(left+right)/2;
            MergeSort(arr, left, mid);
            MergeSort(arr, mid+1, right);
            merge(arr, left, mid, right);

        }
    }
    public static void merge(int arr[],int left,int mid,int right){
        int n1=mid-left+1;
        int n2=right-mid;
        int[]larr=new int[n1];
        int[]rarr=new int[n2];
        System.arraycopy(arr, left, larr, 0, n1);
        System.arraycopy(arr, mid+1, rarr, 0, n2);
        int i=0,j=0;
        int k=left;
        while(i<n1&&j<n2){
            if(larr[i]<=rarr[j]){
                arr[k]=larr[i];
                i++;
            }
            else{
                arr[k]=rarr[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            arr[k]=larr[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k]=rarr[j];
            j++;
            k++;
        }

    }
    public static void Quicksort(int arr[],int low,int high){
        if(low<high){
            int partitionindex=partition(arr, low,high);
            Quicksort(arr, low, partitionindex-1);
            Quicksort(arr, partitionindex+1,high);
        }
    }
    public static int partition(int arr[],int low,int high){
        int pivot=arr[low];
        int i=low+1;
        int j=high;
        while(i<=j){
            while(i<=j && arr[i]<=pivot) i++;
            while(i<=j&&arr[j]>pivot) j--;
            if(i<=j) swap(arr, i, j);

        }
        swap(arr, low, j);
        return j;

    }
    public static void swap(int arr[],int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static  void shellsort(int arr[]){
        for(int gap=arr.length/2;gap>0;gap/=2){
            for(int i=gap;i<arr.length;i++){
                int temp=arr[i];
                int j;
                for(j=i;j>=gap&&temp<arr[j-gap];j-=gap){
                    arr[j]=arr[j-gap];
                }
                arr[j]=temp;
            }
        }
    }
    public static  void radixsort(int arr[]){
        int max=getmax(arr);
        for(int exp=1;max/exp>0;exp*=10){
            countingsort(arr,exp);
        }
    }
        public static void countingsort(int arr[],int exp){
            int countarr[]=new int[10];
            int outputarr[]=new int[arr.length];
            Arrays.fill(countarr,0);
            for(int i=0;i<arr.length;i++){
                countarr[(arr[i]/exp)%10]=arr[i];
            }
            for(int i=1;i<arr.length;i++){
                countarr[i]+=countarr[i-1];
            }
            for(int j=arr.length-1;j>=0;j--){
                outputarr[countarr[(arr[j]/exp)%10]-1]=arr[j];
                countarr[(arr[j]/exp)%10]--;
            }
            for(int i=0;i<arr.length;i++){
                arr[i]=outputarr[i];
            }

        }
        public static  int getmax(int arr[]){
            int max=arr[0];
            for(int i=1;i<arr.length;i++){
                if(arr[i]>max){
                    max=arr[i];
                }
            }
            return max;
        

    }
}
