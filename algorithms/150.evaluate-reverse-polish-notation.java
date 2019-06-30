import java.util.Stack;

/*
 * @lc app=leetcode id=150 lang=java
 *
 * [150] Evaluate Reverse Polish Notation
 */
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                    Integer a = Integer.valueOf(s.pop());
                    Integer b = Integer.valueOf(s.pop());
                    s.push(a + b);
                    break;
                case "-":
                    a = Integer.valueOf(s.pop());
                    b = Integer.valueOf(s.pop());
                    s.push(b - a);
                    break;
                case "*":
                    a = Integer.valueOf(s.pop());
                    b = Integer.valueOf(s.pop());
                    s.push(a * b);
                    break;
                case "/":
                    a = Integer.valueOf(s.pop());
                    b = Integer.valueOf(s.pop());
                    s.push(b / a);
                    break;
                default:
                    s.push(Integer.valueOf(token));
                    break;
            }
        }
        return s.pop();
    }
}

