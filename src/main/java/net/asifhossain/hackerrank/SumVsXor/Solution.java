package net.asifhossain.hackerrank.SumVsXor;

import java.util.Scanner;

/**
 * @author asif.hossain
 * @since 10/15/17.
 */
public class Solution {

    static long solve(long n) {
        // Complete this function
        int nOfZeroBits = nZeroBit(n);

        return 1L << nOfZeroBits;
    }

    private static int nZeroBit(long n) {
        int count = 0;
        while (n > 0) {
            if((n & 1) == 0) {
                count++;
            }
            n >>= 1;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long result = solve(n);
        System.out.println(result);
    }
}
