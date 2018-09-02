package net.asifhossain;

import net.asifhossain.leetcode.common.ListNode;

public class Utils {

    public static ListNode createList(int[] nums) {
        ListNode head = new ListNode(nums[0]);
        ListNode current = head;

        for (int i = 1; i < nums.length; i++) {
            current.next = new ListNode(nums[i]);
            current = current.next;
        }

        return head;
    }
}
