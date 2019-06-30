/*
 * @lc app=leetcode id=19 lang=java
 *
 * [19] Remove Nth Node From End of List
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Deque<ListNode> deque = new LinkedList<ListNode>();
        ListNode p = head;
        ListNode pp = null;
        while (p != null) {
            if (deque.size() >= n) {
                pp = deque.removeLast();
            }
            deque.addFirst(p);
            p = p.next;
        }
        ListNode removeNode = deque.pollLast();
        if (pp == null) {
            return removeNode.next;
        }
        pp.next = removeNode.next;
        return head;
    }
}

