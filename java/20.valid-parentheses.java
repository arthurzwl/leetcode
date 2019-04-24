/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */
class Solution {
    public boolean isValid(String s) {
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (deque.size() == 0) {
                deque.addFirst(s.charAt(i));
            } else {
                char c = s.charAt(i);
                char cInDeque = deque.pollFirst();
                int x = c - cInDeque;
                if (x <= 0 || x > 2) {
                    deque.addFirst(cInDeque);
                    deque.addFirst(c);
                }
            }
        }
        return deque.size() == 0;
    }
}

