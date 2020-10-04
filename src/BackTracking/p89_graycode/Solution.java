package p89_graycode;


import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        List<Integer> res = new Solution().grayCode(2);
        System.out.println(res);
    }
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>() {{ add(0); }};
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--)
                res.add(head + res.get(j));
            head <<= 1;
        }
        return res;
    }
}
