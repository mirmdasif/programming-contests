package net.asifhossain.leetcode.P0088;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] nums = new int[m + n];

        int i = 0;
        int j = 0;
        int k = 0;

        while(j < m && k < n) {
            nums[i++] = nums1[j] < nums2[k] ? nums1[j++] : nums2[k++];
        }

        while(j < m) {
            nums[i++] = nums1[j++];
        }

        while(k < n) {
            nums[i++] = nums2[k++];
        }

        System.arraycopy(nums, 0, nums1, 0, m + n);

    }
}
