import java.util.Scanner;
public class week1third {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String a =sc.next();
    String b = sc.next();
    System.out.println(Combine(a, b));
    sc.close();
  }
  public static String Combine(String a,String b){
    String res="";
    if(a.length()>b.length()){
      res=b+a+b;
    }
    else{
    res=a+b+a;
    }
    return res;
  }
}
