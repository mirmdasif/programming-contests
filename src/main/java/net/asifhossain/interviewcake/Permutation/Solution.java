package net.asifhossain.interviewcake.Permutation;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author asif.hossain
 * @since 11/1/17.
 */
public class Solution {
    public static void main(String[] args) {
        Set<String> perms = permutation("ABC");
        System.out.println(perms);
    }

    private static Set<String> permutation(String str) {
        Set<String> permutations = new LinkedHashSet<>();

        if(str == null) return permutations;

        if("".equals(str)) {
            permutations.add("");
            return permutations;
        }

        char first = str.charAt(0);
        for (String s : permutation(str.substring(1))) {
            for (int i = 0; i <= s.length(); i++) {
                permutations.add(insertChar(s, first, i));
            }
        }

        return permutations;
    }

    private static String insertChar(String s, char ch, int i) {
        String begin = s.substring(0, i);
        String end = s.substring(i);

        return begin + ch + end;
    }
}
