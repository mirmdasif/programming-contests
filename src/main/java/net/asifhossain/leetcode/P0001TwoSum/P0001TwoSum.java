package net.asifhossain.leetcode.P0001TwoSum;

import java.util.HashMap;
import java.util.Map;

public class P0001TwoSum {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> indexMap = new HashMap<>();
            Map<Integer, Integer> indexMap2 = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                if (indexMap.get(nums[i]) == null) {
                    indexMap.put(nums[i], i);
                } else {
                    indexMap2.put(nums[i], i);
                }
            }

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] * 2 == target) {
                    if(indexMap2.get(target - nums[i]) != null) {
                        return getArray(i,  indexMap2.get(target - nums[i]));
                    }
                } else if (indexMap.get(target - nums[i]) != null) {
                    return getArray(i, indexMap.get(target - nums[i]));
                }
            }

            return null;
        }

        private int[] getArray(int a, int b) {
            int[] ar = new int[2];
            ar[0] = a;
            ar[1] = b;

            return ar;
        }
    }
}
