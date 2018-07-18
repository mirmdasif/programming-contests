package net.asifhossain.leetcode.P0069Sqrt;

import org.junit.Test;

import static org.junit.Assert.*;

public class SqrtTest {

    private Sqrt sqrt = new Sqrt();

    @Test
    public void mySqrt() {

        assertEquals(2, sqrt.mySqrt(4));
        assertEquals(46340, sqrt.mySqrt(2147395600));

    }
}