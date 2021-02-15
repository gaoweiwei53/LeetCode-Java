package p28_Implement_strStr;

public class Solution {
    public int strStr(String haystack, String needle) {
        /*
        Input: haystack = "hello", needle = "ll"
        Output: 2
        */
        if (needle.equals("")) return 0;
        char firstChar = needle.charAt(0);
        for (int i = 0; i < haystack.length(); i++) {
            int j = 0;
            if (haystack.charAt(i) == firstChar) {
                for (; i + j < haystack.length() && j < needle.length(); j++) {
                    if (haystack.charAt(j + i) != needle.charAt(j)) {
                        break;
                    }

                }
            }
            // 查找成功
            if ( j == needle.length()){
                return i;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int ans = new Solution().strStr("aaa", "aaaaa");
        System.out.println(ans);
    }
}
