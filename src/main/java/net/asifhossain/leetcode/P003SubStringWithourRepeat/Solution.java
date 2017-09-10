package net.asifhossain.leetcode.P003SubStringWithourRepeat;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> charIndex = new HashMap<>();
        int maxLength = 0;
        int currentLength = 0;
        int startOfCurrent = 0;
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (charIndex.get(ch) == null) {
                currentLength++;
            } else {
                for (int j = startOfCurrent, l = charIndex.get(ch); j <= l; j++) {
                    charIndex.remove(s.charAt(j));
                    startOfCurrent++;
                }

                currentLength = i - startOfCurrent + 1;

            }

            charIndex.put(s.charAt(i), i);
            maxLength = Math.max(currentLength, maxLength);
        }

        return maxLength;

    }
}