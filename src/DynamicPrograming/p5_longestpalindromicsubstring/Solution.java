package p5_longestpalindromicsubstring;

import java.util.Scanner;

public class Solution {

    // Dynamic Programing
    public String longestPalindrome(String s){
        int len = s.length();
        if (len < 2) return s;
        int maxlen = 1;
        int begin = 0;

        // dp[i][j] 表示 s[i...j] 是否是回文串
        // 状态转移方程: dp[i][j] = dp[i+1][j-1] && (s[i] == s[j])
        // dp[i+1][j-1]表示的除去两边字符的子串情况
        // 边界条件：j - 1 - (i+1) + 1 < 2, 整理的 j - i < 3, 状态转移方程建立在子串长度大于2的前提下
        // 默认为false
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        char[] charArray = s.toCharArray();
        for (int j = 1; j < len; j++) {
            // i < j 表示只填对角线上半部分的值
            for (int i = 0; i < j; i++) {
                // 头尾字符不相等 返回 false
                if (charArray[i] != charArray[j]) dp[i][j] = false;
                else{
                    if (j - i < 3) dp[i][j] = true;
                    else dp[i][j] = dp[i+1][j-1];
                }

                // 记录最长回文字串
                // 只要 dp[i][j] == true 成立，就表示字串 s[i...j] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxlen){
                    maxlen =  j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxlen);

    }
    // 中心扩散法
    // 分为两种情况：
    // 1. 中心字符与相邻两边不相等
    // 2. 中心字符与相邻两边相等，此时要把所有相等的字符串作为中心
    // 时间复杂度O(n ^ 2)


    public String longestPalindrome1(String s) {
        if( s == null || s.length() < 2){
            return s;
        }
        int len = s.length();
        int currLen = 1;
        int maxStart = 0, maxLen = 1;
        // 将字符串转为字符数组效率会更高
        char[] charArray = s.toCharArray();
        for(int i = 0; i < len; i++){
            int left = i - 1, right = i + 1;
            while(left >= 0 && charArray[left] == charArray[i]){
                left--;
                currLen++;
            }
            while(right < len && charArray[right] == charArray[i]){
                right++;
                currLen++;
            }
            while(left >= 0 && right < len && charArray[left] == charArray[right]){
                currLen += 2;
                left--;
                right++;
            }
            if(currLen > maxLen){
                maxLen = currLen;
                maxStart = left;
            }
            currLen = 1;

        }
        return s.substring(maxStart + 1, maxStart + maxLen + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String res = new Solution().longestPalindrome1(scanner.next());
            System.out.println(res);
        }
    }
}
