package week3;

import java.util.Arrays;

public class Selectionsort_string {
    public static void main(String args[]){
        String arr[] = {"e","d","c","b","a"};
        Selectionsort_s(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void Selectionsort_s(String arr[]){
        int n =arr.length;
        for(int i=0;i<n-1;i++){
            int minIndex = i;
            for(int j=i;j<n;j++){
                if(arr[j].compareTo(arr[minIndex])<0){
                    minIndex=j;
                }
            }
            String temp = arr[i];
            arr[i]=arr[minIndex];
            arr[minIndex]=temp;
        }
    }
    
}
