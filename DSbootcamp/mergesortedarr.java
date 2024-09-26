package DSbootcamp;

import java.util.Arrays;

public class mergesortedarr {
    public static void main(String[] args) {
        int a[]={1,5,7};
        int b[]={2,6};
        System.out.println(Arrays.toString(mergedata(a,b)));
    }
    public static int [] mergedata(int arr1[],int arr2[]){
        int i=0,j=0,k=0;
        int new_arr[]=new int [arr1.length+arr2.length];
        while(i<arr1.length && j<arr2.length){
            if(arr1[i]<arr2[j]){
                new_arr[k]=arr1[i];
                i++;
            }
            else{
                new_arr[k]=arr2[j];
                j++;
        }
        k++;
        }
        while(i<arr1.length){
            new_arr[k]=arr1[i];
            i++;
            k++;
        } 
        while(j<arr2.length){
            new_arr[k]=arr2[j];
            j++;
            k++;
        }
        return new_arr;
    }
}
