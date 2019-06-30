import java.util.Arrays;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=641 lang=java
 *
 * [641] Design Circular Deque
 */
// class MyCircularDeque {

//     private int capacity;
//     private int size;
//     private Node head;
//     private Node last;

//     /** Initialize your data structure here. Set the size of the deque to be k. */
//     public MyCircularDeque(int k) {
//         capacity = k;
//     }
    
//     /** Adds an item at the front of Deque. Return true if the operation is successful. */
//     public boolean insertFront(int value) {
//         if (!checkCapacity()) {
//             return false;
//         }
//         Node h = head;
//         head = new Node(value, null, h);
//         if (h == null) {
//             last = head;
//         } else {
//             h.prev = head;
//         }
//         size++;
//         return true;
//     }
    
//     /** Adds an item at the rear of Deque. Return true if the operation is successful. */
//     public boolean insertLast(int value) {
//         if (!checkCapacity()) {
//             return false;
//         }
//         Node l = last;
//         last = new Node(value, l, null);
//         if (l == null) {
//             head = last;
//         } else {
//             l.next = last;
//         }
//         size++;
//         return true;
//     }
    
//     /** Deletes an item from the front of Deque. Return true if the operation is successful. */
//     public boolean deleteFront() {
//         if (size == 0) {
//             return false;
//         }
//         head = head.next;
//         if (head == null) {
//             last = null;
//         } else {
//             head.prev = null;
//         }
//         size--;
//         return true;
//     }
    
//     /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
//     public boolean deleteLast() {
//         if (size == 0) {
//             return false;
//         }
//         last = last.prev;
//         if (last == null) {
//             head = null;
//         } else {
//             last.next = null;
//         }
//         size--;
//         return true;
//     }
    
//     /** Get the front item from the deque. */
//     public int getFront() {
//         return head == null ? -1 : head.val;
//     }
    
//     /** Get the last item from the deque. */
//     public int getRear() {
//         return last == null ? -1 : last.val;
//     }
    
//     /** Checks whether the circular deque is empty or not. */
//     public boolean isEmpty() {
//         return size == 0;
//     }
    
//     /** Checks whether the circular deque is full or not. */
//     public boolean isFull() {
//         return capacity == size;
//     }

//     private boolean checkCapacity() {
//         return capacity > size;
//     }

//     private class Node {
//         int val;
//         Node prev;
//         Node next;

//         Node (int val, Node prev, Node next) {
//             this.val = val;
//             this.prev = prev;
//             this.next = next;
//         }
//     }
// }

class MyCircularDeque {

    private int first;
    private int last;
    private int capacity;
    private int size;
    private int[] dataSet;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        dataSet = new int[k];
        capacity = k;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        first = getIndex(--first);
        dataSet[first] = value;
        size++;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        dataSet[last] = value;
        last = getIndex(++last);
        size++;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        first = getIndex(++first);
        size--;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        last = getIndex(--last);
        size--;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        return isEmpty() ? -1 : dataSet[first];
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        return isEmpty() ? -1 : dataSet[getIndex(last - 1)];
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == capacity;
    }

    private int getIndex(int idx) {
        return idx < 0 ? idx + capacity : idx % capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */

