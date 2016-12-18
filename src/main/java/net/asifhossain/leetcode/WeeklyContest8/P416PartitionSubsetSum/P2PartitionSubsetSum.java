package net.asifhossain.leetcode.WeeklyContest8.P416PartitionSubsetSum;

import java.util.Arrays;

/**
 * @author asif.hossain
 * @since 10/10/16.
 */
public class P2PartitionSubsetSum {
    public boolean canPartition(int[] nums) {

        int k = Arrays.stream(nums).reduce(0, Integer::sum);
        if(k%2 == 1) {
            return false;

        } else {
            boolean[][] table = new boolean[nums.length][k / 2 + 1];

            for (int i = 0; i < nums.length; i++) {
                table[i][0] = true;
            }

            for (int i = 0; i <= k / 2; i++) {
                if (nums[0] == i) {
                    table[0][i] = true;
                }
            }

            for (int i = 1; i < nums.length; i++) {
                for (int j = 1;  j <= k / 2; j++) {
                    if (table[i - 1][j] == true) {
                        table[i][j] = true;
                    } else {
                        if (j - nums[i] >= 0 && table[i - 1][j - nums[i]] == true) {
                            table[i][j] = true;
                        } else {
                            table[i][j] = false;
                        }
                    }
                }
            }
            return table[nums.length - 1][k / 2];

        }

    }

    public static void main(String[] args) {
        P2PartitionSubsetSum p = new P2PartitionSubsetSum();
        int[] set = {1, 2, 3, 5};
        System.out.println(p.canPartition(set));
    }
}
