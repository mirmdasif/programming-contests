package net.asifhossain.leetcode.P0021MergeTwoSortedLinkedList;

import java.util.Objects;

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val &&
                Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }
}

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
