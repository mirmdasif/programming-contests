package net.asifhossain.hackerrank.FlatLandDistence;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int c[] = new int[n];
        int[] d = new int[n];

        for (int i = 0; i < n; i++) {
            d[i] = Integer.MAX_VALUE;
        }

        for(int c_i=0; c_i < m; c_i++){
            c[c_i] = in.nextInt();
        }

        int maxDistance = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            int distence = Integer.MAX_VALUE;

            for (int j = 0; j < m; j++) {
                distence = Math.min(Math.abs(i - c[j]), distence);
            }

            maxDistance = Math.max(distence, maxDistance);
        }


        System.out.println(maxDistance);
    }
}
