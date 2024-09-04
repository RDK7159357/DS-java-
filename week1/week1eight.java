import java.util.Scanner;
public class week1eight {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n =sc.nextInt();
    int[] arr=new int[n];
    for(int i=0;i<n;i++){
      arr[i]=sc.nextInt();
    }
    sc.close();
    }
    public static void Leaders(int n, int arr[]){
          int[] leaders = new int[n];
      int maxFromRight = 0;
      int leaderindex=0;
      for (int i = n-1 ; i >= 0; i--) {
          if (arr[i] >= maxFromRight) {
            leaders[leaderindex++]=arr[i];
              maxFromRight = arr[i];
          }
      }
      for(int i=leaderindex-1;i>=0;i--){
        System.out.print(leaders[i]+" ");
      }
    }
  }

