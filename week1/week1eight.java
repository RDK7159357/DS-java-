
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline left-over
        String s = sc.nextLine();
        String[] srr = s.split(",");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(srr[i].trim());
        }
        Leaders(n, arr);
        sc.close();
    }

    public static void Leaders(int n, int arr[]) {
        int[] leaders = new int[n];
        int maxFromRight = 0;
        int leaderIndex = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] >= maxFromRight) {
                leaders[leaderIndex++] = arr[i];
                maxFromRight = arr[i];
            }
        }
        for (int i = leaderIndex - 1; i >= 0; i--) {
            System.out.print(leaders[i] + " ");
        }
    }
}
