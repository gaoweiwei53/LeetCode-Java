package p155_Min_Stack;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
}

// 使用一个辅助栈记录每次插入或弹出后，当前栈中的最小值
class MinStack {
    Deque<Integer> xStack;
    Deque<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        xStack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        xStack.push(val);
        minStack.push(Math.min(minStack.peek(), val));
    }

    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

class MinStack2 {

    private Node node = null;

    private class Node {
        int val;
        // 记录当前栈中最小值
        int min;
        Node next;

        public Node(int val, int min) {
            this.val = val;
            this.min = min;
        }

        public Node(int val, int min, Node next ) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }


    /** initialize your data structure here. */
    public MinStack2() {

    }

    public void push(int val) {
        if(node == null) {
            node = new Node(val, val);
        } else {
            node = new Node(val, Math.min(node.min, val), node);
        }
    }

    public void pop() {
        node = node.next;
    }

    public int top() {
        return node.val;
    }

    public int getMin() {
        return node.min;
    }
}
class MinStack3 {
    Deque<Integer> mainStack;
    Deque<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack3() {
        mainStack = new LinkedList<>();
        minStack = new LinkedList<>();

    }

    public void push(int val) {
        mainStack.push(val);
        if(minStack.isEmpty() || minStack.peek() >= val){
            minStack.push(val);
        }
    }

    public void pop() {
        if(mainStack.peek().equals(minStack.peek())){
            minStack.pop();
        }
        mainStack.pop();
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack3 min = new MinStack3();
        min.push(512);
        min.push(-1024);
        min.push(-1024);
        min.push(512);
        min.pop();
        min.getMin();
        min.pop();
        min.getMin();
        min.pop();
        System.out.println(min.getMin());

    }
}
