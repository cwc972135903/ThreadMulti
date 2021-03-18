package Leetcode;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *给你一个整数数组 arr 和两个整数 k 和 threshold 。
 *
 * 请你返回长度为 k 且平均值大于等于 threshold 的子数组数目。
 * 示例 1：
 *
 * 输入：arr = [2,2,2,2,5,5,5,8], k = 3, threshold = 4
 * 输出：3
 * 解释：子数组 [2,5,5],[5,5,5] 和 [5,5,8] 的平均值分别为 4，5 和 6 。其他长度为 3 的子数组的平均值都小于 4 （threshold 的值)。
 * 示例 2：
 *
 * 输入：arr = [1,1,1,1,1], k = 1, threshold = 0
 * 输出：5
 * 示例 3：
 *
 * 输入：arr = [11,13,17,23,29,31,7,5,2,3], k = 3, threshold = 5
 * 输出：6
 * 解释：前 6 个长度为 3 的子数组平均值都大于 5 。注意平均值不是整数。
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/6/9 13:15
 */
public class numOfSubarrays {
    public static void main(String[] args) {
        int[] arr = {2,2,2,2,5,5,5,8};
        System.out.println(numOfSubarrays(arr, 3, 4));
    }

    /**
     * 解题思路
     * 子数组，说明是要连续的几位数字才可以，需要通过滑动时间窗口方法进行，尽量减少乘除的操作，用加减替代，运算更快
     * step1 ：取出前k个数求和，然后减去k*threshold ，如果结果大于0，说明符合要求。
     * step2 ： 指针后移一位，用后移一位的值减去移动之前的第一位的值，再加上上次减法的结果，如果大于0，说明符合要求
     * @param arr
     * @param k
     * @param threshold
     * @return
     */
    public static int numOfSubarrays(int[] arr, int k, int threshold) {
        int num = 0;
        //处理极端情况
        if(arr.length < k || k==0){
            return 0;
        }
        int sumTarget = k*threshold;
        int sum = 0;
        int pos = k;
        //滑动窗口
        for(int i=0; i<k; ++i){
            sum+=arr[i];
        }
        int addr = sum-sumTarget;
        if(addr >= 0){
            ++num;
        }
        //arr.length-k的原因是因为pos是从k开始加的，不然就数组越界了
        for(int i=0; i<arr.length-k; ++i){
            addr = addr + arr[pos] - arr[i];
            if(addr >= 0){
                ++num;
            }
            ++pos;
        }

        return num;
    }

}
