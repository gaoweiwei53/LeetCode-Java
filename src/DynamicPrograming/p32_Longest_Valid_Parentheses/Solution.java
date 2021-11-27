package p32_Longest_Valid_Parentheses;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    // 这种写法更容易理解
    public int longestValidParentheses(String s) {
        //dp[i] 表示以下标 i 字符结尾的最长有效括号的长度
        int n = s.length();
        int[] dp = new int[n];//dp是以i处括号结尾的有效括号长度
        int max_len = 0;
        //i从1开始，一个是单括号无效，另一个是防i - 1索引越界
        for(int i = 1; i < n; i++) {
            if(s.charAt(i) == ')') { //遇见右括号才开始判断
                if(s.charAt(i - 1) == '(') { //上一个是左括号
                    if(i < 2) { //开头处
                        dp[i] = 2;
                    } else { //非开头处
                        dp[i] = dp[i - 2] + 2;
                    }
                } else { //上一个也是右括号
                    if(dp[i - 1] > 0) {//上一个括号是有效括号
//pre_left为i处右括号对应左括号下标，推导：(i-1)-dp[i-1]+1 - 1
                        int pre_left = i - dp[i - 1] - 1;
                        if(pre_left >= 0 && s.charAt(pre_left) == '(') {//左括号存在且为左括号（滑稽）
                            dp[i] = dp[i - 1] + 2;
                            //左括号前还可能存在有效括号
                            if(pre_left - 1 > 0) {
                                dp[i] = dp[i] + dp[pre_left - 1];
                            }
                        }
                    }
                }
            }
            max_len = Math.max(max_len, dp[i]);
        }
        return max_len;
        // 果s[i-1]是')'，则需要寻找一下，与当前右括号s[i]配对的左括号应该在哪里，
        // 我们把这个左括号应该在的位置定义为j，有j = i - 1 - dp[i - 1]

    }

//    s[i-1]是')'，s[i-1]和s[i]是'))'，以s[i-1]为结尾的最长有效长度为dp[i-1]，跨过这个长度，
//    来看s[i-dp[i-1]-1]这个字符：
//    s[i-dp[i-1]-1]不存在或为')'，则s[i]找不到匹配，dp[i]=0
//    s[i-dp[i-1]-1]是'('，与s[i]匹配，有效长度 = 2 + 跨过的dp[i-1]+ 前方的dp[i-dp[i-1]-2]。
//    s[i-dp[i-1]-2]要存在才行！：
//    s[i-dp[i-1]-2]存在，dp[i] = dp[i-1] + dp[i-dp[i-1]-2] + 2
//    s[i-dp[i-1]-2]不存在，dp[i] = dp[i-1] + 2
    public int longestValidParentheses2(String s) {
        int maxans = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }

    // 栈
    public int longestValidParentheses3(String s) {
        if (s == null || s.length() == 0) return 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        //System.out.println(stack);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push(i);
            else {
                stack.pop();
                if (stack.isEmpty()) stack.push(i);
                else {
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }
}
