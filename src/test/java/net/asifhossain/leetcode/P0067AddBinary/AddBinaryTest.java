package net.asifhossain.leetcode.P0067AddBinary;

import org.junit.Test;

import static org.junit.Assert.*;

public class AddBinaryTest {

    private AddBinary addBinary = new AddBinary();
    @Test
    public void addBinary() {
        assertEquals("100", addBinary.addBinary("11", "1"));
        assertEquals("10101", addBinary.addBinary("1010", "1011"));
    }
}