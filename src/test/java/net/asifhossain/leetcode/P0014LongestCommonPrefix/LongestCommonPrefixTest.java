package net.asifhossain.leetcode.P0014LongestCommonPrefix;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LongestCommonPrefixTest {

    LongestCommonPrefix solution;

    @Before
    public void setUp() {
        solution = new LongestCommonPrefix();
    }

    @Test
    public void test() {
        Assert.assertEquals("fl", solution.longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }

    @Test
    public void test2() {
        Assert.assertEquals("", solution.longestCommonPrefix(new String[]{"dog","racecar","car"}));
        Assert.assertEquals("r", solution.longestCommonPrefix(new String[]{"r","racecar","rar"}));
        Assert.assertEquals("aaa", solution.longestCommonPrefix(new String[]{"aaaa","aaa","aaa"}));
        Assert.assertEquals("", solution.longestCommonPrefix(new String[]{}));
    }
}