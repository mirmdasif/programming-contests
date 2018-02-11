package net.asifhossain.hackerrank.TheGridSearch;

import org.junit.Test;

import static org.junit.Assert.*;

public class TheGridSearchSolutionTest {

    private TheGridSearchSolution solution = new TheGridSearchSolution();

    @Test
    public void containsPattern() {
        assertTrue(solution.containsPattern(new int[][]{{1, 2, 3}}, new int[][]{{1, 2}}));
    }
}