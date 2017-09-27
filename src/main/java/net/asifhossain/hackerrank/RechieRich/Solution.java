package net.asifhossain.hackerrank.RechieRich;

import java.util.Scanner;

public class Solution {

    static String richieRich(String s, int n, int k){
        // Complete this function

        char[] chars = s.toCharArray();
        int[] cost = new int[n];
        for(int i = 0; i <= n/2; i++) {

            if(chars[i] != chars[n - i - 1]) {
                k--;
                chars[i] = max(chars[i], chars[n - i - 1]);
                chars[n - i - 1] = max(chars[i], chars[n - i - 1]);
                cost[i] = 1;
            } else {
                cost[i] = 2;
            }
        }

        if(k < 0) return "-1";

        if(n % 2 == 1) cost[n / 2] = 1;


        for(int i = 0; i <= n/2 && k > 0; i++) {
            if(chars[i] != '9' && cost[i] <= k) {
                chars[i] = '9';
                chars[n - i - 1] = '9';

                k = k - cost[i];
            }
        }

        return new String(chars);
    }

    private static char max(char ch, char ch2) {
        if(ch > ch2) return ch;
        return ch2;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        String s = in.next();
        String result = richieRich(s, n, k);
        System.out.println(result);
    }
}
