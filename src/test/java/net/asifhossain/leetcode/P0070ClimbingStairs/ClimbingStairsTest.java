package net.asifhossain.leetcode.P0070ClimbingStairs;

import org.junit.Assert;
import org.junit.Test;

public class ClimbingStairsTest {

    private ClimbingStairs climbingStairs = new ClimbingStairs();

    @Test
    public void climbStairs() {
        Assert.assertEquals(3, climbingStairs.climbStairs(3));
    }

    @Test
    public void climbStairsDp() {
        Assert.assertEquals(3, climbingStairs.climbStairsDp(3));
    }

    @Test
    public void climbStairsFib() {
        Assert.assertEquals(3, climbingStairs.climbStairsFib(3));
    }
}