package p3_Longest_Substring_Without_Repeating_Characters;

import java.util.HashMap;
import java.util.Map;
// 定义一个 map 数据结构存储 (k, v)，其中 key 值为字符，value 值为字符位置
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            // 取出end位置的字符
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans = new Solution().lengthOfLongestSubstring("abcabcbb");
        System.out.println(ans);
    }
}
