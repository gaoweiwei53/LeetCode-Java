package nc90;

import java.util.*;


public class Solution {
    /**
     * return a array which include all ans for op3
     * @param op int整型二维数组 operator
     * @return int整型一维数组
     */
    Deque<Integer> stack1 = new ArrayDeque<>();
    Deque<Integer> stack2 = new ArrayDeque<>();
    public int[] getMinStack (int[][] op) {
        // write code here
        int len = 0;
        for(int i = 0; i < op.length; i++){
            if(op[i][0] == 3){
                len++;
            }
        }
        int[] res = new int[len];
        for(int i = 0, j = 0; i < op.length; i++){
            if(op[i][0] == 1){
                push(op[i][1]);
            }
            else if(op[i][0] == 2){
                pop();
            }
            else{
                res[j++] = getMin();
            }
        }
        return res;
    }
    private void push(int val){
        if(stack2.isEmpty() || val < stack2.peek()){
            stack2.push(val);
        }
        stack1.push(val);
    }
    private void pop(){
        if(stack1.peek().equals(stack2.peek())){
            stack2.pop();
        }
        stack1.pop();
    }
    private int getMin(){
        return stack2.peek();
    }
}