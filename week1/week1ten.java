import java.util.Scanner;

public class week1ten {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // String s1 = sc.nextLine();
        // String[] s = s1.split(" ");
        // int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(Meanofarr(arr, n));
        sc.close();
    }

    public static double Meanofarr(int arr[], int n) {
        if (n == 1) {
            return (double) arr[0];
        }
        double mean1 = Meanofarr(arr, n - 1);
        double sum = (n - 1) * mean1 + arr[n - 1];
        double mean = sum / (double) n;
        return mean;
    }
}