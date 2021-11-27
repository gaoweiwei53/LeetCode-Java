package p128_Longest_Consecutive_Sequence;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hash = new HashSet<>();
        for(int x : nums) hash.add(x);
        int res = 0;
        for(int x : hash)
        {
            // 如果当前数x的前驱x-1不存在，我们就以当前数x为起点向后枚举
            // 表示从一个连续序列的最小数开始查找
            if(!hash.contains(x-1))
            {
                int y = x;   //以当前数x向后枚举
                while(hash.contains(y + 1)) y++;
                res = Math.max(res, y - x + 1);  //更新答案
            }
        }
        return res;
    }
}
