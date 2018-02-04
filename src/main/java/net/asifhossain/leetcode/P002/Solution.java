package net.asifhossain.leetcode.P002;

class ListNode {
    int val;
    ListNode next;

    public ListNode(int data) {
        this.val = data;
    }
}

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addNumber(l1, l2, 0);
    }

    private ListNode addNumber(ListNode l1, ListNode l2, int remainder) {
        if(l1 == null && l2 == null) {
            if(remainder == 0) return null;

            return new ListNode(remainder);
        }

        int n1 = 0;

        if(l1 != null) {
            n1 = l1.val;
            l1 = l1.next;
        }

        int n2 = 0;

        if(l2 != null) {
            n2 = l2.val;
            l2 = l2.next;
        }

        ListNode node = new ListNode((n1 + n2 + remainder) % 10);
        node.next = addNumber(l1, l2, (n1 + n2 + remainder) / 10);

        return node;
    }
}