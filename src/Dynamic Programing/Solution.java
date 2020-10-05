public class Solution {
    // 暴力解法
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
            right++;
        }
        return true;
    }

    public static void main(String[] args) {
        String longestPalindromic = new Solution().longestPalindrome("");

    }
}
