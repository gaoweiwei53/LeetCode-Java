package p125_Valid_Palindrome;

import java.util.Locale;

public class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        String lowerCase= s.toLowerCase();
        while (left < right){
            if (('a'<= lowerCase.charAt(left) && lowerCase.charAt(left) <= 'z')
                    ||( '0'<= lowerCase.charAt(left) && lowerCase.charAt(left) <='9')){
                if (('a'<= lowerCase.charAt(right) && lowerCase.charAt(right)<= 'z')
                || ( '0'<= lowerCase.charAt(right) && lowerCase.charAt(right) <='9')){
                    if (lowerCase.charAt(left) != lowerCase.charAt(right)){
                        return false;
                    }
                    else {
                        left++;
                        right--;
                    }
                }
                else {
                    right--;
                }
            }
            else {
                left ++;
            }
        }
        return true;
    }

    // s = "A man, a plan, a canal: Panama"
    public static void main(String[] args) {
        String s = "0P";
        System.out.println(new Solution().isPalindrome(s));
    }

}
