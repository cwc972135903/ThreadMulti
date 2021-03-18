package Leetcode;

/**
 * <p>Title: xCRMS </p>
 * Description: 两数平方和
 * 1. 题目描述：判断一个非负整数是否为两个整数的平方和
 * 2.   Input: 5
 *      Output: True
 *      Explanation: 1 * 1 + 2 * 2 = 5
 * 3. 解题思路： 双指针查找，最大的数肯定是在sqrt(target)范围内的，不然就会超过目标数字的大小了
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/1/23 15:50
 */
public class SumOfSquareNumbers {
    public static void main(String ...args){
        boolean res = judgeSquareSum(5);

        System.out.println("是否存在：" + res);
    }

    public static boolean judgeSquareSum(int target) {
        if (target < 0) return false;
        int i = 0, j = (int) Math.sqrt(target);
        while (i <= j) {
            int powSum = i * i + j * j;
            if (powSum == target) {
                return true;
            } else if (powSum > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
