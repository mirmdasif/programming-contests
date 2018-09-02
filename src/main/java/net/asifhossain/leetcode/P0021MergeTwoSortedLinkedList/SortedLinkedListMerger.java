package net.asifhossain.leetcode.P0021MergeTwoSortedLinkedList;

import net.asifhossain.leetcode.common.ListNode;

public class SortedLinkedListMerger {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode current = null;
        while (l1 != null || l2 != null) {
            ListNode node;
            if (l1 == null) {
                node = new ListNode(l2.val);
                l2 = l2.next;
            } else if (l2 == null) {
                node = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                if (l1.val <= l2.val) {
                    node = new ListNode(l1.val);
                    l1 = l1.next;
                } else {
                    node = new ListNode(l2.val);
                    l2 = l2.next;
                }
            }

            if (head == null) {
                current = node;
                head = node;
            } else {
                current.next = node;
                current = node;
            }
        }

        return head;
    }
}
