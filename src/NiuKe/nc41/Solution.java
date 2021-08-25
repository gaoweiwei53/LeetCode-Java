package nc41;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxLength (int[] arr) {
        // write code here
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < arr.length; i++){
            if(map.containsKey(arr[i])){
                left = Math.max(map.get(arr[i]) + 1, left);
            }
            map.put(arr[i],i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] input = new int[]{3,3,2,1,3,3,3,1};
        int res = new Solution().maxLength(input);
        System.out.println(res);
        int[][] tmp = new int[6][];
        System.out.println(tmp[0][0]);
    }
}
