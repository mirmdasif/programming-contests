package net.asifhossain.leetcode.P0070ClimbingStairs;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {

    private static Map<Integer, Integer> steps = new HashMap<>();

    static {
        steps.put(0, 1);
        steps.put(1, 1);
    }

    // Approach 2: Recursion with memorization
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public int climbStairs(int n) {
        if (steps.get(n) != null) {
            return steps.get(n);
        }

        steps.put(n, climbStairs(n - 2) + climbStairs(n - 1));

        return steps.get(n);
    }

    // Approach 3: Dynamic Programming
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public int climbStairsDp(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    // Approach 4: Fibonacci Number
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int climbStairsFib(int n) {

        if (n == 1) return 1;
        if (n ==  2) return 2;

        int first = 1;
        int second = 2;

        for (int i = 3; i <= n; i++) {
            int third =  first + second;
            first = second;
            second = third;
        }

        return second;
    }
}
