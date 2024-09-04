import java.util.Scanner;
public class week1ten {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s1=sc.nextLine();
    String[] s = s1.split(" ");
    int n = s.length;
    int [] arr = new int[n];
    for(int i =0;i<n;i++){
      arr[i] = Integer.parseInt(s[i]);
    }
    System.out.println(Meanofarr(arr,n));
    sc.close();
}
public static double Meanofarr(int arr[],int n){
  if(n==1){
    return arr[0];
  }
  double mean1 = Meanofarr(arr, n-1);
  double sum = (n-1) * mean1;
  double mean = (sum + arr[n-1])/(double)n;
  return mean;
}
  }
// public static void Meanofarr(String s[]){
//       int[] arr=new int[s.length];
//     for (int i = 0; i < s.length; i++) {
//       arr[i] = Integer.parseInt(s[i]);
//   }
//   int sum = 0;
//   for (int i = 0; i < arr.length; i++) {
//       sum += arr[i];
//   }
//   double mean = (double) sum / arr.length;
//   System.out.println("Mean: " + mean);
// }