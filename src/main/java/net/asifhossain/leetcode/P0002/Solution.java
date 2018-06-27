package net.asifhossain.leetcode.P0002;

class ListNode {
    int val;
    ListNode next;

    public ListNode(int data) {
        this.val = data;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = null;
        ListNode last = null;
        int mod = 0;
        while(l1 != null || l2 != null || mod != 0) {
            int s1 = 0;
            int s2 = 0;
            if (l1 != null) {
                s1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                s2 = l2.val;
                l2 = l2.next;
            }
            
            ListNode node = new ListNode((s1 + s2 + mod) % 10);
            if (sum == null) {
                sum = node;
                last = node;
            } else {
                last.next = node;
                last = node;
            }
            
            mod = (s1 + s2 + mod) / 10;
        } 
        
        return sum;
    }
}