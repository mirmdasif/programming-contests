package net.asifhossain.leetcode.P0070ClimbingStairs;

import org.junit.Assert;
import org.junit.Test;

public class ClimbingStairsTest {

    @Test
    public void climbStairs() {
        ClimbingStairs climbingStairs = new ClimbingStairs();

        Assert.assertEquals(3, climbingStairs.climbStairs(3));
    }
}