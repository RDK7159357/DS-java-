import java.util.Arrays;

public class Reading_arrwithoutSc {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Insufficient values");
            return;
        }

        try {
            int n = Integer.parseInt(args[0]);
            if (args.length < n + 1) {
                System.out.println("Insufficient values");
                return;
            }

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(args[i + 1]);
            }
            System.out.println(Arrays.toString(arr));
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format");
        }
    }
}
