import java.util.*;

/*
 * @lc app=leetcode id=225 lang=java
 *
 * [225] Implement Stack using Queues
 */
class MyStack {

    private Queue<Integer> store;

    /** Initialize your data structure here. */
    public MyStack() {
        store = new ArrayDeque<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        store.add(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int size = store.size();
        for (int i = 1; i < size; i++) {
            store.add(store.poll());
        }
        return store.poll();
    }
    
    /** Get the top element. */
    public int top() {
        Integer val = pop();
        push(val);
        return val;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return store.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

