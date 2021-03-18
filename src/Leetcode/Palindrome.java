package Leetcode;

/**
 * <p>Title: xCRMS </p>
 * Description: 回文字符串
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 * 解题思路：
 * 1. 左右两边指针同时移动，当两边移动到同一个位置还没出现不一样的字符，那这个字符串肯定是回文字符串
 * 2. 当左右两边当前指向的字符不一致时，这时候就需要删除其中一个了，比如 abcbfa
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/1/23 16:13
 */
public class Palindrome {
    public static void main(String ...args){
       boolean res = validPalindrome("abcbfa");
       System.out.println("是否回文字符串：" + res);
    }

    public static boolean validPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1, j);
            }
        }
        return true;
    }

    private static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
