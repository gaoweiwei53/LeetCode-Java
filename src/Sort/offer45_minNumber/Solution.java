package offer45_minNumber;

import java.util.Arrays;

class Solution {
    public String minNumber(int[] nums) {
        String[] ss = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            ss[i] = nums[i] + "";
        }
        Arrays.sort(ss, (a, b) -> {
            String ab = a + b, ba = b + a;
            return ab.compareTo(ba);
        });
        StringBuilder stringBuilder = new StringBuilder();
        for (String s:ss){
            stringBuilder.append(s);
        }

        return stringBuilder.toString();
    }
}