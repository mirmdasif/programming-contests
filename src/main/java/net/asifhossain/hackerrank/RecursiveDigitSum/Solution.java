package net.asifhossain.hackerrank.RecursiveDigitSum;

import java.util.Scanner;

public class Solution {

    private static int calcSuperDigitSum(String n) {
        int sum = 0;
        int i = 0;
        while (i < n.length()) {
            sum = sum + n.charAt(i++) - '0';

            while (sum >= 10) {
                sum = sum % 10 + sum / 10;
            }
        }

        return sum;
    }

    static int digitSum(String n, int k) {
        // Complete this function
        int sum = calcSuperDigitSum(n);
        return calcSuperDigitSum((sum * k) + "");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String n = in.next();
        int k = in.nextInt();
        int result = digitSum(n, k);
        System.out.println(result);
        in.close();
    }
}
