package net.asifhossain.hackerrank.FlatLandDistence;

import java.util.Arrays;
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
            c[in.nextInt()] = 1;
        }

        Integer currentStation = null;

        for (int i = 0; i < n; i++) {
            if(c[i] == 1) {
                currentStation = i;
            }

            if(currentStation != null) {
                d[i] = Math.min(i - currentStation, d[i]);
            }
        }

        currentStation = null;

        for (int i = n - 1; i >= 0; i--) {
            if(c[i] == 1) {
                currentStation = i;
            }

            if(currentStation != null) {
                d[i] = Math.min(currentStation - i, d[i]);
            }
        }

        int maxDistance = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            maxDistance = Math.max(maxDistance, d[i]);
        }

        System.out.println(maxDistance);
        System.out.println(Arrays.toString(d));
    }
}
