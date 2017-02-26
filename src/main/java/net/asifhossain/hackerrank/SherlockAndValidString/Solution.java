package net.asifhossain.hackerrank.SherlockAndValidString;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author asif.hossain
 * @since 2/6/17.
 */
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int[] frq = new int[26];

        for (int i = 0; i < str.length(); i++) {
            frq[str.charAt(i) - 'a'] = frq[str.charAt(i) - 'a'] + 1;
        }


        if (isValid(frq)) {
            System.out.println("YES");
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (frq[i] == 0) continue;

            frq[i] = frq[i] - 1;

            if (isValid(frq)) {
                System.out.println("YES");
                return;
            }

            frq[i] = frq[i] + 1;
        }

        System.out.println("NO");
    }

    private static boolean isValid(int[] frq) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            if (frq[i] == 0) continue;
            set.add(frq[i]);
        }

        return set.size() <= 1;
    }
}