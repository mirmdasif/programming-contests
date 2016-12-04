package net.asifhossain.algorithms;

/**
 * @author asif.hossain
 * @since 2/10/16
 */
public class Knapsack {

    public static int zeroOneKnapsack(int capacity, int[] values, int[] weights) {
        if (capacity == 0 || values.length == 0) {
            return 0;
        }
        int[][] m = new int[values.length + 1][capacity + 1];
        
        for (int j = 0; j <= capacity; j++) {
            m[0][j] = 0;
        }
        
        for (int i = 1; i <= values.length; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (weights[i-1] > j) {
                    m[i][j] = m[i-1][j];
                }
                else {
                    m[i][j] = Math.max(m[i-1][j], m[i-1][j-weights[i-1]] + values[i-1]);
                }
            }
        }

        return m[values.length][capacity];
    }
    
    public static void main(String[] args) {
        System.out.println(zeroOneKnapsack(5, new int[]{3, 4, 5, 6}, new int[]{2, 3, 4, 5}));

    }
}
