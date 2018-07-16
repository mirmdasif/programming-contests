package net.asifhossain.leetcode.P0053MaximumSubArraySum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaximumSubArraySumTest {

    private MaximumSubArraySum subArraySum = new MaximumSubArraySum();

    @Test
    public void maxSubArray() {
        assertEquals(6, subArraySum.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}