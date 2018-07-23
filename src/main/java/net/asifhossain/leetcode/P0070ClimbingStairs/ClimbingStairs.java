package net.asifhossain.leetcode.P0070ClimbingStairs;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {

    private static Map<Integer, Integer> steps = new HashMap<>();

    static {
        steps.put(0, 1);
        steps.put(1, 1);
    }

    public int climbStairs(int n) {
        if (steps.get(n) != null) {
            return steps.get(n);
        }

        steps.put(n, climbStairs(n - 2) + climbStairs(n - 1));

        return steps.get(n);
    }
}
