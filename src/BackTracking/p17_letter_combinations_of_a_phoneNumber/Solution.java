package p17_letter_combinations_of_a_phoneNumber;

import java.util.LinkedList;
import java.util.List;
// ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
public class Solution {
    private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public static void main(String[] args) {
        List<String> ret = new Solution().letterCombinations("23");
        System.out.println(ret);
//        String str = "23";
//        char c = str.charAt(1);
//        String[] key = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    }
    public static String getType(Object o){
        return o.getClass().toString();
    }
    public List<String> letterCombinations(String digits) {
        List<String> ret = new LinkedList<>();
        if(digits == null || digits.length() == 0) return ret;
        combination("", digits, 0, ret);
        return ret;
    }

    private void combination(String prefix, String digits, int offset, List<String> ret) {
        if (offset >= digits.length()) {
            ret.add(prefix);
            return;
        }
        // - '0' can convert Character to integer type
        // + "" can Convert other type to String type

        String letters = KEYS[(digits.charAt(offset) - '0')];
        for (int i = 0; i < letters.length(); i++) {
            combination(prefix + letters.charAt(i), digits, offset + 1, ret);
        }
    }
}
