package net.asifhossain.leetcode.P002;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SolutionTest {

    Solution solution = new Solution();
    @Test
    public void addTwoZeroReturnsZero() {
        assertTrue(solution.addTwoNumbers(new ListNode(0), new ListNode(0)).val == 0);
    }
}