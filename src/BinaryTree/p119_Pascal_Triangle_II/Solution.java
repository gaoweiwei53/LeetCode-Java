package p119_Pascal_Triangle_II;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i <= rowIndex; i++) {
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
        return res.get(rowIndex);
    }
}
