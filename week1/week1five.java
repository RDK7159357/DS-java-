import java.util.Scanner;
public class week1five {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n =sc.nextInt();
    secondlast(n);
    sc.close();
  }
  public static void secondlast(int n){
    if(n>=0 && n<=9){
      System.out.println(-1);
    }
    else{
    n=n/10;
    System.out.println(n%10);
    }

  }
}
