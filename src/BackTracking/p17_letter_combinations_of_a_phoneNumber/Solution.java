package p17_letter_combinations_of_a_phoneNumber;

import java.util.ArrayList;
import java.util.List;
// ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
public class Solution {
    //map存储数字与字母的映射关系
    private String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    private List<String> res = new ArrayList<>(); //结果集

    public static void main(String[] args) {
        List<String> res = new Solution().letterCombinations("23");
        System.out.println(res);
    }

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0 || digits == null) return res; //特判
        StringBuilder stringBuilder = new StringBuilder(); //存储中间结果
        dfs(digits,stringBuilder,0);
        return res;
    }
    public void dfs(String digits,StringBuilder stringBuilder, int pos){
        //pos为当前字符串temp的长度

        //递归出口，字符串temp的长度==digits的长度
        if(pos == digits.length()){
            res.add(stringBuilder.toString());
            return;
        }
        char c = digits.charAt(pos); //step1:len从0～digits的长度，每次递归就遍历到一个数字
        String str = map[c-'0']; //step2:获取数字对应字符串

        for(int i=0; i<str.length(); i++){ //step3:遍历数字对应的字符串
            stringBuilder.append(str.charAt(i)); //将遍历到的字母加入stringBuilder
            dfs(digits,stringBuilder,pos+1); //steo4: 调用下一层递归
            stringBuilder.deleteCharAt(stringBuilder.length()-1); //撤销选择
        }
    }
}
