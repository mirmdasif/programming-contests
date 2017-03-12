package net.asifhossain.leetcode.P04MedianOfTwoSortedArrays;

import net.asifhossain.codeforces.utils.ArrayUtils;

/**
 * @author asif.hossain
 * @since 3/2/17.
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] num = new int[nums1.length + nums2.length];

        for (int i = 0, j = 0, k = 0; (i < nums1.length || j < nums2.length) && k <= (num.length - 1) / 2 + 1; k++) {
            if(i >= nums1.length) {
                num[k] = nums2[j++];
            } else if(j >= nums2.length) num[k++] = nums1[i++];
            else {
                if(nums1[i] <= nums2[j]) {
                    num[k] = nums1[i++];
                } else {
                    num[k] = nums2[j++];
                }
            }
        }

        if (num.length == 0) return 0;
        if (num.length % 2 == 0) {
            return ((double) num[(num.length - 1) / 2] + (double) num[(num.length - 1) / 2 + 1])/ 2;
        } else {
            return num[(num.length - 1) / 2];
        }
    }

    private int[] merge(int[] nums1, int[] nums2) {

        int[] num = new int[nums1.length + nums2.length];

        for (int i = 0, j = 0, k = 0; i < nums1.length || j < nums2.length;) {
            if(i >= nums1.length) {
                num[k++] = nums2[j++];
            } else if(j >= nums2.length) {
                num[k++] = nums1[i++];
            } else {
                if(nums1[i] <= nums2[j]) {
                    num[k++] = nums1[i++];
                } else {
                    num[k++] = nums2[j++];
                }
            }
        }

        return num;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
        System.out.println(s.findMedianSortedArrays(new int[]{1, 3, 7}, new int[]{4, 6}));
        System.out.println(s.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(s.findMedianSortedArrays(new int[]{}, new int[]{}));
        System.out.println(s.findMedianSortedArrays(new int[]{1}, new int[]{}));
        System.out.println(s.findMedianSortedArrays(new int[]{}, new int[]{1}));

        ArrayUtils.printArray(s.merge(new int[]{1, 3}, new int[]{2}));
    }
}