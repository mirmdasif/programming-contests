package net.asifhossain.leetcode.P003SubStringWithourRepeat;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        for (int subStringLength = s.length(); subStringLength >= 1; subStringLength--) {
            for (int startIndex = 0; startIndex + subStringLength - 1 < s.length(); startIndex++) {
                if (test(s, startIndex, startIndex + subStringLength - 1)) {
                    return subStringLength;
                }
            }
        }

        return 0;

    }

    private boolean test(String s, int startIndex, int endIndex) {
        Map<Character, Boolean> map = new HashMap<>();

        for (int i = startIndex; i <= endIndex; i++) {
            if (map.get(s.charAt(i)) != null) return false;
            map.put(s.charAt(i), true);
        }

        return true;
    }
}