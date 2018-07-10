package net.asifhossain.leetcode.P0035InsertPosition;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class P0035InsertPositionTest {

    private P0035InsertPosition insertPosition = new P0035InsertPosition();

    @Test
    public void searchInsert() {
        assertEquals(2, insertPosition.searchInsert(new int[]{1,3,5,6}, 5));
        assertEquals(1, insertPosition.searchInsert(new int[]{1,3,5,6}, 2));
    }
}