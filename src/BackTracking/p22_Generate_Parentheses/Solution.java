package BackTracking.p22_Generate_Parentheses;

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
    /*
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
    */
    // 做加法

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        // 特判
        if (n == 0) {
            return res;
        }

        dfs("", 0, 0, n, res);
        return res;
    }

    /**
     * @param curStr 当前递归得到的结果
     * @param left   左括号已经用了几个
     * @param right  右括号已经用了几个
     * @param n      左括号、右括号一共得用几个
     * @param res    结果集
     */
    private void dfs(String curStr, int left, int right, int n, List<String> res) {
        if (left == n && right == n) {
            res.add(curStr);
            return;
        }

        // 剪枝
        if (left < right) {
            return;
        }

        if (left < n) {
            dfs(curStr + "(", left + 1, right, n, res);
        }
        if (right < n) {
            dfs(curStr + ")", left, right + 1, n, res);
        }
    }

}
