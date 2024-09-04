import java.util.Scanner;
public class week1one {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a=Math.abs(sc.nextInt());
    int b=Math.abs(sc.nextInt());
    Sumlast2(a, b);
    sc.close();

  }
  public static void Sumlast2(int a, int b){
    int sum = a%10 + b%10;
    System.out.println(sum);
  }
}
