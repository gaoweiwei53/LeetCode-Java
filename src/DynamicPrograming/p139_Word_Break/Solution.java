package p139_Word_Break;

import java.util.*;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 动态规划，dp[i]表示 s的前i位是否可以用wordDict里的单词表示
        // 主要用到了startsWith这个函数
/*        int length = s.length();
        boolean[] dp = new boolean[length + 1];
        Arrays.fill(dp, false);
        dp[0] = true;

        for (int i = 0; i < length; i++) {
            // dp[i] = false时
            if (!dp[i]) {
                continue;
            }
            // s.startsWith(prefix, index)检查字符串是否 在指定位置为开始的前缀为 prefix
            for (String word : wordDict) {
                if (word.length() + i <= s.length() && s.startsWith(word, i)) {
                    dp[i + word.length()] = true;
                }
            }
        }
        return dp[length];*/

        // 实现 2
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;


        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];

        // 自己的想法，一次遍历，不行
/*        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        int j = 0, i = 0;
        for (; i < s.length(); i++) {
            if (dp[j] && wordDictSet.contains(s.substring(j, i + 1))){
                dp[i] = true;
            }
            else {
                continue;
            }
        }
        if (j == s.length()) return true;
        return false;*/
    }

    public static void main(String[] args) {
        String s = "aaaaaaa";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("aaaaa");
        wordDict.add("aaa");
        boolean res = new Solution().wordBreak(s, wordDict);
        System.out.println(res);
        System.out.println(wordDict.contains("aa"));
    }
}
