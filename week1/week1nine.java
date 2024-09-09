import java.util.Scanner;
public class week1nine {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int n1 = n;
    int rev = sc.nextInt();

    long result = power(n1, rev);
    System.out.println((int)result);
    sc.close();
  }
  static long power(int N, int R) {
    long res = 1;
    long MOD = (long) (1e9 + 7);
    while (R > 0) {
      if ((R & 1) == 1)
        res = (res * N) % MOD;
      N = (int) (((long) N * N) % MOD);
      R >>= 1;
    }
    return res;
  }
}