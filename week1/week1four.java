import java.util.Scanner;
public class week1four {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] arr=new int[5]; 
    for(int i=0;i<5;i++){
      System.out.print("num"+(i+1)+": ");
      arr[i]=sc.nextInt();
    } 
    String ty = sc.next();
    noofevenorodd(arr, ty);   
     sc.close();
  }
  public static void noofevenorodd(int arr[],String ty){
    int count=0;      
    for(int i=0;i<5;i++){
        if(arr[i]%2==0){
          count++;
        }   
      }
    if(ty.equals("even")){
      System.out.print(count);
    }  
    else if(ty.equals("odd")){
      System.out.print(5-count);
    }

  } 
}
