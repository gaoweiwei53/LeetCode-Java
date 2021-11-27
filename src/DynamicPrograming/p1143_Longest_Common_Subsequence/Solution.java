package p1143_Longest_Common_Subsequence;

class Solution {

    /**
     * 最长公共子序列问题是典型的二维动态规划问题
     * dp[i][j]表示的是s1[0:i-1]和 s2[0:j-1]的最长公共子序列的长度，不需要连续
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();

        int[][] dp = new int[m + 1][n + 1];
        // 当 i == 0 || j == 0 表示空字符串的匹配情况
        for (int i = 1; i <= m; i++) {
            // charAt(i - 1)
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                // charAt(j - 1)
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
    public static void main(String[] args) {
        String s = "qwer";
        System.out.println(s.charAt(0));

    }
}

