package net.asifhossain.hackerrank.LuckBalance;

import java.util.*;

/**
 * @author asif.hossain
 * @since 10/11/17.
 */
public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        int luckBalance = 0;
        PriorityQueue<Integer> important = new PriorityQueue<>();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        for(int i = 0; i < n; i++) {
            int luck = sc.nextInt();
            int importance = sc.nextInt();

            if(importance == 1) {
                important.add(luck);
            }

            luckBalance += luck;
        }

        while(important.size() > k) {
            luckBalance -= important.poll() * 2;
        }

        System.out.println(luckBalance);
    }
}