import java.util.Scanner;
public class week1six {
  public static void main(String args[]){
    Scanner sc =new Scanner(System.in);
    String s1=sc.nextLine();
    Alternate(s1);
    sc.close();
  }
  public static void Alternate(String s1){
    String srr[]=s1.split(",");
    char arr1 []= srr[0].toCharArray();
    char arr2[]=srr[1].toCharArray();
    int i=0;
    String res="";
    int n =Math.min(arr1.length,arr2.length);
    while(i<n){
      res+=arr1[i];
      res+=arr2[i];
      i++;
    }
    for(int j=n;j<Math.max(arr1.length,arr2.length);j++){
      if(arr1.length>arr2.length){
        res+=arr1[j];
      }
      else{
        res+=arr2[j];
      }
    }
    System.out.println(res);
  }
}
