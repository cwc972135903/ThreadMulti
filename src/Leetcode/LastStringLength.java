package Leetcode;

/**
 * <p>Title: xCRMS </p>
 * Description: 计算最后一个单词的长度<br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/4/16 9:25
 */
public class LastStringLength {
    public static void main(String ...args){
        String str = "Hello world";
        System.out.println(findLastWordLength(str));
    }

    public static int findLastWordLength(String str){
        // 最后一个字母的位置
        int last = str.length() - 1;

        // 找最后一个字母出现的位置，防止最后一个字母是空格
        while (last >= 0 && str.charAt(last) == ' '){
            last--;
        }

        // 找最后一个字母之前的第一个空白字符
        int pos = last - 1;
        while (pos >= 0 && str.charAt(pos) != ' '){
            pos--;
        }

        return last - pos;
    }
}
