package net.asifhossain.hackerrank.StreetParade1;

import java.util.Scanner;

/**
 * @author asif.hossain
 * @since 12/1/16.
 */
public class Solution {

    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);

        int n = sc.nextInt();
        int[] points =  new int[n];

        points[0] =  sc.nextInt();
        for (int i = 0; i < n; i++) {
            points[i] = sc.nextInt();
        }

        int startPoint = points[0];
        int lastPoint = points[n - 1];

        int totalMile = sc.nextInt();
        int min = sc.nextInt();
        int max = sc.nextInt();

        for (int i = startPoint - max; i <= startPoint - min; i++) {
            if (i + totalMile - lastPoint >= min) {
                System.out.println(i);
                return;
            }
        }
    }
}