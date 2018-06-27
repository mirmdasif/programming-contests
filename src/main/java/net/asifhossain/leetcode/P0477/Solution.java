package net.asifhossain.leetcode.P0477;

/**
 * @author asif.hossain
 * @since 12/18/16.
 */
public class Solution {

    public int totalHammingDistance(int[] nums) {
        int count = 0;
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = intTo32BitBinaryString(nums[i]);
        }

        for (int i = 0; i <= 31; i++) {
            int x = 0;
            int y =0;
            for (int j = 0; j < nums.length; j++) {
                if (strings[j].charAt(i) == '0') {
                    x++;
                } else {
                    y++;
                }
            }

            count = count + x * y;
        }

        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.totalHammingDistance(new int[]{4, 14, 2}));
    }

    private String intTo32BitBinaryString(int number) {
        return Long.toBinaryString( number & 0xffffffffL | 0x100000000L ).substring(1);
    }
}
