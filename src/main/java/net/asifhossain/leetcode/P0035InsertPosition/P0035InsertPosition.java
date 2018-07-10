package net.asifhossain.leetcode.P0035InsertPosition;

public class P0035InsertPosition {

    public int searchInsert(int[] nums, int target) {

        int l  = 0;
        int r = nums.length - 1;

        while(l <= r) {
            int m = (l + r) / 2;
            if (nums[m] > target) {
                r = m - 1;

            } else if (nums[m] <  target) {
                l = m + 1;
            } else {
                return m;
            }
        }

        if (r < 0) {
            if (nums[l] < target) {
                return l + 1;
            } else {
                return l;
            }
        } else {
            if (nums[r] < target) {
                return r + 1;
            } else {
                return r;
            }

        }
    }
}
