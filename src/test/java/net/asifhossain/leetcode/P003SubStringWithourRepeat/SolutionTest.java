package net.asifhossain.leetcode.P003SubStringWithourRepeat;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void emptyStringReturnZero() {
        testLength(0, "");
    }

    @Test
    public void singleCharacter() {
        testLength(1, "aaa");
    }

    @Test
    public void testAllDifferentCharacter() {
        testLength(3, "abc");
    }


    @Test
    public void testSingleRepeatCharacter() {
        testLength(3, "aabc");
    }

    @Test
    public void testMultipleRepeatCharacter() {
        testLength(3, "aabacc");
        testLength(2, "aabbcc");
    }

    private void testLength(int actual, String str) {
        assertEquals(actual, new Solution().lengthOfLongestSubstring(str));
    }
}