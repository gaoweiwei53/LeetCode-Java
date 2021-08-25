package p46_permutations;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// attention！ 该题给定的数据没有  重复的序列
public class Solution {
    
    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        int[] visited = new int[nums.length];
        backtrack(res, nums, new ArrayList<>(), visited);
        return res;
    }
    // 四个参数 击败96%
    private void backtrack(List<List<Integer>> res, int[] nums, ArrayList<Integer> path, int[] visited) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) continue;

            path.add(nums[i]);
            visited[i] = 1;

            backtrack(res, nums, path, visited);

            // 回溯，退出后，将当前的元素移除, 状态重置
            visited[i] = 0;
            path.remove(path.size() - 1);
        }
    }
    
    public List<List<Integer>> permute2(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        dfs3(nums, new ArrayList<>(), res, 0);
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
    public static void main(String[] args) {
        int[] nums  = {1,2,3};
        List<List<Integer>> res = new Solution().permute1(nums);

        System.out.println(res);
    }


}
