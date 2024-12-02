package week12;

import java.util.Arrays;

public class NumberOfSpanningTrees {
    static final int MOD = 1000000007;

    private long power(long base, long exp, long mod) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) result = (result * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }

    private long modInverse(long a, long mod) {
        return power(a, mod - 2, mod);
    }

    private long determinant(long[][] matrix, int n) {
        long det = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (matrix[i][i] == 0) return 0;
                long factor = (matrix[j][i] * modInverse(matrix[i][i], MOD)) % MOD;
                for (int k = i; k < n; k++)
                    matrix[j][k] = (matrix[j][k] - factor * matrix[i][k] % MOD + MOD) % MOD;
            }
            det = (det * matrix[i][i]) % MOD;
        }
        return (det + MOD) % MOD;
    }

    public long numOfSpanningTree(int[][] graph, int V) {
        long[][] laplacian = new long[V][V];
        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                laplacian[i][j] = (i == j) ? Arrays.stream(graph[i]).sum() : -graph[i][j];

        long[][] minor = new long[V - 1][V - 1];
        for (int i = 1; i < V; i++)
            System.arraycopy(laplacian[i], 1, minor[i - 1], 0, V - 1);

        return determinant(minor, V - 1);
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 1, 1, 1},
            {1, 0, 1, 1},
            {1, 1, 0, 1},
            {1, 1, 1, 0}
        };
        System.out.println("Number of spanning trees: " +
            new NumberOfSpanningTrees().numOfSpanningTree(graph, 4));
    }
}
