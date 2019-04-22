/*
 * @lc app=leetcode id=206 lang=java
 *
 * [206] Reverse Linked List
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode parent = head;
        ListNode child = parent.next;
        parent.next = null;
        while(child != null) {
            ListNode tmp = child.next;
            child.next = parent;
            parent = child;
            child = tmp;
        }
        return parent;
    }
}

