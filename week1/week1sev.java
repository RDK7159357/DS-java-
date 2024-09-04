import java.util.Scanner;
public class week1sev {
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    System.out.print("num: ");
    int n = sc.nextInt();
    for(int i=0;i<=n;i++){
      System.out.print(Padovan(i)+" ");
    }
    sc.close();
  }
  public static int Padovan(int n){
    int res=0;
    if(n<=2){
    res=1;
  }
  else{
    res=Padovan(n-2)+Padovan(n-3);
  }
  return res;
  }
}
