package net.asifhossain.algorithms.combination;

/**
 * @author asif.hossain
 * @since 3/5/17.
 */
public class Combination {
    public static long binomialCoefficient(int n, int m) {
        long[][] bc = new long[n + 1][n + 1];

        for (int i = 0; i <= n; i++) bc[i][0] = 1;
        for (int i = 0; i <= n; i++) bc[i][i] = 1;

        for (int i = 1; i <= n; i++)
            for (int j = 1; j < i; j++)
                bc[i][j] = (bc[i - 1][j - 1] + bc[i - 1][j]);

        return bc[n][m];
    }

    public static void main(String[] args) {
        System.out.println(binomialCoefficient(48, 24));
        System.out.println(binomialCoefficient(48, 0));
    }
}
