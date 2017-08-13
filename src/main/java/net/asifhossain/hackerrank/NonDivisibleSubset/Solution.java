package net.asifhossain.hackerrank.NonDivisibleSubset;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] freq = new int[k];

        for (int i = 0; i < n; i++) {
            freq[sc.nextInt() % k]++;
        }


        int count = 0;
        System.out.println(Arrays.toString(freq));

        for (int i = 1; i < k; i++) {
            if (i + i == k) {
                if (freq[i] > 0) {
                    count++;
                }
            } else if(freq[k - i] > freq[i]) {
                count += freq[k - i];
            } else {
                count += freq[i];
            }

            freq[k - i] = 0;
            freq[i] = 0;
        }

        if (freq[0] > 0) {
            count++;
        }

        System.out.println(Arrays.toString(freq));
        System.out.println(count);
    }
}
