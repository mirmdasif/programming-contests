package net.asifhossain.hackerrank.BestDivisor;

import java.util.Scanner;

public class Solution {

    private static int digitSum(int n) {
        int sum = 0;

        while(n > 0) {
            sum += n % 10;
            n = n / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        if(n == 0) {
            System.out.println(0);
            return;
        }

        int x = n / 2;

        int bestDivisor = 1;
        int sumOfBestDivisor = 1;

        for(int i = 2; i <= x; i++) {
            if(n % i == 0) {
                int sum = digitSum(i);
                if(sum > sumOfBestDivisor) {
                    bestDivisor = i;
                    sumOfBestDivisor = sum;
                }
            }
        }

        int i = n;
        int sum = digitSum(i);
        if(sum > sumOfBestDivisor) {
            bestDivisor = i;
        }

        System.out.println(bestDivisor);
    }
}
