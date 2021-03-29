package p118_Pascal_Triangle;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> res = new LinkedList<>();
            for (int i = 0; i < numRows; i++) {
                List<Integer> list = new LinkedList<>();
                for (int j = 0; j <= i; j++) {
                    if (j == 0 || j == i){
                        list.add(1);
                    }
                    else{
                        list.add(res.get(i-1).get(j - 1) + res.get(i-1).get(j));
                    }
                }
                res.add(list);
            }
            return res;
    }

    // 注意i, j的值
}
