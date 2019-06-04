import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode id=32 lang=java
 *
 * [32] Longest Valid Parentheses
 */
class Solution {
    // private LinkedList<Object> list = new LinkedList<>();

    // public int longestValidParentheses(String s) {
    //     int result = 0;
    //     for (int i = 0; i < s.length(); i++) {
    //         if (s.charAt(i) == '(') {
    //             list.addFirst('(');
    //         } else {
    //             if (!list.isEmpty()) {
    //                 int tmp = 0;
    //                 Object element = list.pollFirst();
    //                 if (element.equals('(')) {
    //                     tmp = 2;
    //                     tmp = addNumber(tmp);
    //                 } else {
    //                     tmp = (Integer) element;
    //                     if (!list.isEmpty()) {
    //                         list.pollFirst();
    //                         tmp += 2;
    //                         tmp = addNumber(tmp);
    //                     }
    //                 }
    //                 result = result > tmp ? result : tmp;
    //             }
    //         }
    //     }
    //     return result;
    // }

    // private int addNumber(int number) {
    //     if (!list.isEmpty()) {
    //         Object element = list.pollFirst();
    //         if (element.equals('(')) {
    //             list.addFirst('(');
    //         } else {
    //             number += (Integer) element;
    //         }
    //     }
    //     list.addFirst(number);
    //     return number;
    // }

    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int max=0;
        int left = -1;
        for(int j=0;j<s.length();j++){
            if(s.charAt(j)=='(') stack.push(j);            
            else {
                if (stack.isEmpty()) left=j;
                else{
                    stack.pop();
                    if(stack.isEmpty()) max=Math.max(max,j-left);
                    else max=Math.max(max,j-stack.peek());
                }
            }
        }
        return max;
    }
}

