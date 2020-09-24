package p22_Generate_Parentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<String> outcome =new Solution().generateParenthesis(3);
        System.out.println(outcome);
    }
    /*
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n <= 0){
            return res;
        }
        StringBuilder curr = new StringBuilder();
        backTracking(n, n, res, curr);
        return res;
    }
    private void backTracking(int left, int right, List<String> res, StringBuilder curr){
        if(left == 0 && right == 0){
            res.add(curr.toString());
            return;
        }
        if(left > 0){
            curr.append("(");
            backTracking(left - 1, right, res, curr);
            curr.deleteCharAt(curr.length() - 1);
        }
        if(right > left){
            curr.append(")");
            backTracking(left, right - 1, res, curr);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
    */
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generateOneByOne("", list, n, n);
        return list;
    }
    public void generateOneByOne(String sublist, List<String> list, int left, int right){
        if(left > right){
            return;
        }
        if(left > 0){
            generateOneByOne( sublist + "(" , list, left-1, right);
        }
        if(right > 0){
            generateOneByOne( sublist + ")" , list, left, right-1);
        }
        if(left == 0 && right == 0){
            list.add(sublist);
            return;
        }
    }
}
