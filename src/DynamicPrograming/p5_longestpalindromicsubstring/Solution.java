package DynamicPrograming.p5_longestpalindromicsubstring;

public class Solution {
    // 暴力解法
    /*
    public String longestPalindrome(String s){
        int len = s.length();
        if (len < 2) return s;
        int maxLen = 1;
        int begin = 0;
        // s.charAt(i) 每次都会检查数组下标越界，因此先转换为字符数组，这一步非必须
        char[] charArray = s.toCharArray();
        //枚举所有长度严格大于1的子串
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++){
                // 可保证 j-i+1可保证得出的时最长子串
                if (j - i + 1 > maxLen && validPalindromic(charArray, i, j)){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
    //验证子串s[left .. right] 是否为回文串
    private boolean validPalindromic(char[] charArray, int left, int right){
        while (left < right){
            if (charArray[left] != charArray[right]) return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String longestPalindromic = new Solution().longestPalindrome("ba");
        System.out.println(longestPalindromic);

    }

     */
    // Dynamic Programing
    //执行用时：189 ms, 在所有 Java 提交中击败了14.11%的用户
    public String longestPalindrome(String s){
        int len = s.length();
        if (len < 2) return s;
        int maxlen = 1;
        int begin = 0;

        // dp[i][j] 表示 s[i...j] 是否是回文串
        // 默认为false
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        char[] charArray = s.toCharArray();
        // 注意：左下角先填
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

}
