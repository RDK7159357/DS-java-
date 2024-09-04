import java.util.Scanner;
public class week1two {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int num1=sc.nextInt();
    int num2=sc.nextInt();
    System.out.println(checkMultiple(num1, num2));
    sc.close();
  }
  public static int checkMultiple(int num1,int num2){
    int res=0;
    if(Math.abs(num1%num2)==0 && num1!=0 && num2!=0){
       res=2;
    }
    else if(num1==0 || num2==0 ){
      res=0;
    }  
    else{
      res = 1;
    }
    return res;
  }
}
