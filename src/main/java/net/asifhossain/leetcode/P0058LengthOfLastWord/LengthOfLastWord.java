package net.asifhossain.leetcode.P0058LengthOfLastWord;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        String[] tokens = s.split("\\s");
        if (tokens == null || tokens.length < 1) {
            return 0;
        }

        return tokens[tokens.length - 1].length();
    }
}
