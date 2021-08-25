package nc121;

import java.util.*;

public class Solution {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        int len = str.length();
        if(str == null || len == 0) return res;
        boolean[] visited = new boolean[len];
        dfs(str, res, visited, new StringBuilder());
        return res;
    }
    private void dfs(String str, ArrayList<String> res, boolean[] visited,
                     StringBuilder path){
        if(path.length() == str.length()){
            res.add(path.toString());
            return;
        }
        for(int i = 0; i < str.length(); i++){
            if(visited[i] == true) continue;
            if(i > 0 && str.charAt(i - 1) == str.charAt(i) && visited[i-1] == false){
                continue;
            }
            path.append(str.charAt(i));
            visited[i] = true;

            dfs(str, res, visited, path);
            visited[i] = false;
            path.deleteCharAt(path.length() - 1);
        }
    }
    public static void main(String[] args) {
        String str1 = new String("dahua");
        String str2 = new String("dahua");
        Set hashset = new HashSet();
        hashset.add(str1);
        hashset.add(str2);
        Iterator it = hashset.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}