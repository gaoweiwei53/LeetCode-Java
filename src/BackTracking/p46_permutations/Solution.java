package p46_permutations;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// attention！ 该题给定的数据没有  重复的序列
public class Solution {

    public static void main(String[] args) {
        int[] nums  = {1,2,3};
        List<List<Integer>> res = new Solution().permute(nums);

        System.out.println(res);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        int[] visited = new int[nums.length];
        backtrack(res, nums, new ArrayList<>(), visited);
        return res;

    }
    // 四个参数 击败96%
    private void backtrack(List<List<Integer>> res, int[] nums, ArrayList<Integer> tmp, int[] visited) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) continue;
            visited[i] = 1;
            tmp.add(nums[i]);
            backtrack(res, nums, tmp, visited);

            // 回溯，退出后，将当前的元素移除, 状态重置
            visited[i] = 0;
            tmp.remove(tmp.size() - 1);
        }
    }

    //三个参数， 击败10% 太慢了
/*    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(res, list, nums);
        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> list, int[] nums) {
        if(list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int num : nums) {
            // contains() 有重复的序列时就用不了了
            if(!list.contains(num)) {
                list.add(num);
                backtrack(res, list, nums);
                list.remove(list.size() - 1);
            }
        }
    }*/
    public List<List<Integer>> permute3(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        dfs3(nums, new ArrayList<Integer>(), res, 0);
        return res;
    }

    private void dfs3(int[] nums, ArrayList<Integer> path, List<List<Integer>> res, int resLen){
        if(resLen == nums.length  ){
            res.add(new ArrayList(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(path.contains(nums[i])) continue;
            path.add(nums[i]);
            dfs3(nums, path, res, resLen + 1);
            path.remove(path.size()-1);
        }
    }

}
