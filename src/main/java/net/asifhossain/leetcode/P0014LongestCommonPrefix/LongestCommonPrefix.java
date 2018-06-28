package net.asifhossain.leetcode.P0014LongestCommonPrefix;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        String prefix = "";

        for (int i = 0; strs.length > 0 && i < strs[0].length() ; i++) {

            char c = strs[0].charAt(i);
            boolean matched = true;

            for (int j = 1; j < strs.length; j++) {
                if (i < strs[j].length() && c == strs[j].charAt(i)) {
                    continue;
                } else {
                    matched = false;
                    break;
                }
            }

            if (matched) {
                prefix = prefix + c;
            } else {
                break;
            }
        }

        return prefix;
    }
}
