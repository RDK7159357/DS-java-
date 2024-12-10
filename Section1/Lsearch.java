package Section1;

public class Lsearch {
    
public static int Linearsearch(int arr[],int n, int key){
  for(int i =0;i<n;i++){
  if( arr[i]==key){
  return i;
  }

  }
  return -1;
  }
}
