package net.asifhossain.leetcode.P0066PlusOne;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlusOneTest {

    private PlusOne plusOne = new PlusOne();

    @Test
    public void plusOne() {
        assertArrayEquals(new int[]{1, 2, 4}, plusOne.plusOne(new int[]{1, 2, 3}));
        assertArrayEquals(new int[]{1, 0, 0, 0}, plusOne.plusOne(new int[]{9, 9, 9}));
        assertArrayEquals(new int[]{1}, plusOne.plusOne(new int[]{0}));
    }
}