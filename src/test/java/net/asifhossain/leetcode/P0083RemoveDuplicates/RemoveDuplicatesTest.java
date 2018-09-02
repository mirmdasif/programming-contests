package net.asifhossain.leetcode.P0083RemoveDuplicates;

import net.asifhossain.Utils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RemoveDuplicatesTest {

    private RemoveDuplicates removeDuplicates = new RemoveDuplicates();

    @Test
    public void deleteDuplicates_1() {
        assertEquals(Utils.createList(new int[] {1, 3, 5}),
                removeDuplicates.deleteDuplicates(Utils.createList(new int[] {1, 1, 3, 5, 5, 5})));
    }
}