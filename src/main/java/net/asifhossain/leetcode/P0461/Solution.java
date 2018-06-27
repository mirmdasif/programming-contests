package net.asifhossain.leetcode.P0461;

/**
 * @author asif.hossain
 * @since 12/18/16.
 */
public class Solution {
    public int hammingDistance(int x, int y) {
        int diff = 0;

        String s1 = Long.toBinaryString( x & 0xffffffffL | 0x100000000L ).substring(1);
        String s2= Long.toBinaryString( y & 0xffffffffL | 0x100000000L ).substring(1);
        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
        }

        return diff;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.hammingDistance(1, 1));
    }
}