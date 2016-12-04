package net.asifhossain.hackerrank.GameWithCells;

import java.util.Scanner;

/**
 *  Problem Link https://www.hackerrank.com/contests/w26/challenges/game-with-cells
 *  @author asif.hossain
 *  @since November 28, 2016
 */
public class Solution {

    public static int calc(int x, int y) {
        if(x == 0 || y == 0) {
            return 0;
        }

        if(x == 1) {
            if(y%2 == 0) {
                return y/2;
            } else {
                return y/2 + 1;
            }
        }

        if(y == 1) {
            if(x%2 == 0) {
                return x/2;
            } else {
                return x/2 + 1;
            }
        }

        if(x % 2 != 0) {
            return calc(x - 1, y) + calc(1, y);
        }

        if(y % 2 != 0) {
            return calc(x, y - 1) + calc(x, 1);
        }

        return x * y / 4;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        System.out.println(calc(n, m));
    }
}
