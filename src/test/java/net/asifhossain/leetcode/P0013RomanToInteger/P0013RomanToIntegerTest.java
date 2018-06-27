package net.asifhossain.leetcode.P0013RomanToInteger;

import org.junit.Assert;
import org.junit.Test;

public class P0013RomanToIntegerTest {

    P0013RomanToInteger solution = new P0013RomanToInteger();

    @Test
    public void test1() {
        Assert.assertEquals(1, solution.romanToInt("I"));
        Assert.assertEquals(20, solution.romanToInt("XX"));
    }
}