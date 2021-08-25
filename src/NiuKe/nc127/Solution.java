package nc127;

import java.util.*;


public class Solution {
    /**
     * longest common substring
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @return string字符串
     */
    public String LCS (String str1, String str2) {
        // write code here
        int m = str1.length(), n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        int maxLen = 0, end = 0;
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else
                    dp[i][j] = 0;
                if(dp[i][j] > maxLen){
                    maxLen = dp[i][j];
                    end = i;
                }
            }
        }
        return str1.substring(end - maxLen, end);
    }
    // 最长子序列唯一不同的就是当前比较的字符不相等时dp[i][j] = 0
}