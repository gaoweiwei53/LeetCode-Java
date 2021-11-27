package p91_Decode_Ways;

public class Solution {
    // 动态规划
    public int numDecodings(String s) {
        int n = s.length();
        // 考虑空字符串
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; ++i) {
            // 只使用当前字符的情况：当前字符不为0
            if (s.charAt(i - 1) != '0') {
                f[i] = f[i - 1];
            }
            // 当前字符和前一个字符共同组成,
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                f[i] += f[i - 2];
            }
        }
        return f[n];
    }

    // 分三种情况
    // 1. s[i] == '0'时，若s[i - 1] == '1'或s[i -  1] == '2'，则
    // 2. 否则 s[i - 1] == '1' 或 s[i -  1] == '2' 且 1 <= s[i] <= '6'
    public int numDecodings10(String s) {
        char[] charArray = s.toCharArray();
        if (charArray[0] == '0') return 0;
        int pre = 1, curr = 1;
        for (int i = 1; i < charArray.length; i++) {
            int tmp = curr;
            if (charArray[i] == '0'){
                if (charArray[i - 1] == '1' || charArray[i - 1] == '2') curr = pre;
                else return 0;
            }
            else if (charArray[i-1] == '1' || (charArray[i-1] == '2' && charArray[i] >= '1' && charArray[i] <= '6'))
                curr = curr + pre;
            pre = tmp;
        }
        return curr;
    }
}

