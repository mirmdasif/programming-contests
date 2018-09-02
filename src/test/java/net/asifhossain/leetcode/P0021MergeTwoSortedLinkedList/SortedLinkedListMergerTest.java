package net.asifhossain.leetcode.P0021MergeTwoSortedLinkedList;

import org.junit.Assert;
import org.junit.Test;

import static net.asifhossain.Utils.createList;

public class SortedLinkedListMergerTest {

    SortedLinkedListMerger merger = new SortedLinkedListMerger();
    @Test
    public void mergeTwoLists() {
        Assert.assertEquals(createList(new int[]{1, 2, 2 , 3, 5, 6, 9}),
                merger.mergeTwoLists(createList(new int[]{1, 3, 9}), createList(new int[]{2, 2, 5, 6})));
    }
}