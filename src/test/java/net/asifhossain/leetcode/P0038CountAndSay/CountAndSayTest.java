package net.asifhossain.leetcode.P0038CountAndSay;

import org.junit.Test;

import static org.junit.Assert.*;

public class CountAndSayTest {

    CountAndSay countAndSay = new CountAndSay();

    @Test
    public void countAndSay() {
        assertEquals("1", countAndSay.countAndSay(1));
        assertEquals("11", countAndSay.countAndSay(2));
        assertEquals("21", countAndSay.countAndSay(3));
        assertEquals("1211", countAndSay.countAndSay(4));
    }
}