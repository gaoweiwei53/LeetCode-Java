package p3_Longest_Substring_Without_Repeating_Characters;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
// 定义一个 map 数据结构存储 (k, v)，其中 key 值为字符，value 值为字符位置
class Solution {
    // Hashmap插入key已存在的对象的时，会将新的value替换为原来的value
    // 所以这题HashMap里记录的时每个字符最新的位置
    // 右侧遇到重复的字符时，将左侧指针移到 max(最近的重复字符的位置 + 1, 当前left指针位置)
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;

    }

    public static void main(String[] args) {
        int ans = new Solution().lengthOfLongestSubstring("abcabcbb");
        System.out.println(ans);

//        Map<Character, Integer> map = new HashMap<>();
//        map.put('a', 0);
//        map.put('b', 1);
//        map.put('a', 2);
//        System.out.println(Arrays.asList(map));
    }
}
