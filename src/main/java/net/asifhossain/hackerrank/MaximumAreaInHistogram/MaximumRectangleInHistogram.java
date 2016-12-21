package net.asifhossain.hackerrank.MaximumAreaInHistogram;

import java.util.Scanner;

/**
 * @author asif.hossain
 * @since 12/21/16.
 */
public class MaximumRectangleInHistogram {
    public int maxAreaBruteForce(int[] heights) {
        int maxRectangle = 0;

        for (int i = 0; i < heights.length; i++) {

            int rectangle = heights[i];
            int min = heights[i];

            for (int j = i + 1; j < heights.length; j++) {
                if (heights[j] < min) {
                    min = heights[j];
                }

                if (min * (j - i + 1) > rectangle) {
                    rectangle = min * (j - i + 1);
                }
            }
            if (maxRectangle < rectangle) {
                maxRectangle = rectangle;
            }
        }

        return maxRectangle;
    }

    static int count = 0;
    public int maxAreaDivideAndConquer(int a[], int l, int r) {
        System.out.println(++count + " Left " + l + " right " + r);
        if (r < 0) {
            System.out.println("A");
            return 0;
        }
        if (l > r) {
            System.out.println("B");
            return 0;
        }
        if (l == r)
            return a[l];

        int m = findIdxOfMinInRange(a, l, r);


        return max(
                maxAreaDivideAndConquer(a, l, m - 1),
                maxAreaDivideAndConquer(a,m + 1, r),
                (r - l + 1) * a[m]); // check for overflow and under flow
    }

    private int findIdxOfMinInRange(int[] a, int l, int r) {
        int min = l;
        for (int i = l + 1; i <= r; r++) {
            if (a[i] < a[min]) {
                min = i;
            }
        }

        return min;
    }

    int max(int x, int y, int z) {
        return Math.max(Math.max(x, y), z);
    }

    public static void main(String[] args) {
        MaximumRectangleInHistogram b = new MaximumRectangleInHistogram();
        Scanner sc = new Scanner(System.in);

        int[] a = new int[sc.nextInt()];

        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }



//      System.out.println(b.maxAreaBruteForce(a));
        System.out.println(b.maxAreaDivideAndConquer(a, 0, a.length -1));
    }
}
