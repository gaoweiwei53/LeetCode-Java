package BackTracking.p77_combinations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<List<Integer>> result = new Solution().combine(4,2);
        System.out.println(result);
    }
    /*
    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> result = new ArrayList<>();
        if ( k < 0 || n < k) return result;
        dfs(n, k, result, new ArrayList<Integer>(),1);
        return result;
    }
    private void dfs(int n, int k, List<List<Integer>> result, List<Integer> curr, int start ){
        if (curr.size() == k){
            result.add(new ArrayList<>(curr));
            return;
        }
        for (int i = start; i <= n; i++) {
            curr.add(i);
            dfs(n, k, result, curr, i + 1 );
            curr.remove(curr.size() - 1);
        }
    }
     */
    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> result = new ArrayList<>();
        if ( k < 0 || n < k) return result;
        dfs(n, k, result, new ArrayList<Integer>(),1);
        return result;
    }
    private void dfs(int n, int k, List<List<Integer>> result, List<Integer> curr, int start ){
        if (curr.size() == k){
            result.add(new ArrayList<>(curr));
            return;
        }
        // 优化 i 的上界
        for (int i = start; i <= n - (k - curr.size()) + 1; i++) {
            curr.add(i);
            dfs(n, k, result, curr, i + 1 );
            curr.remove(curr.size() - 1);
        }
    }
}
