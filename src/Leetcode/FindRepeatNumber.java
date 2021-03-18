package Leetcode;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 *     https://blog.csdn.net/ffsiwei/article/details/80424275
 *     https://www.jianshu.com/p/80332d20cf06
 *     时间复杂度：
 *     空间复杂度：
 *     题目描述： 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。数组中某些数字是重复的，
 *     但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/1/21 17:25
 */
public class FindRepeatNumber {

    public static void main(String ...args){
        int[] nums = {2, 3, 1, 0, 5, 2};
        int[] duplication = new int[1];
        duplicate(nums, nums.length, duplication);

        System.out.println("当前重复的数字："+duplication[0]);
    }

    /**
     * 1. 2 3 1 0 2 5  2 2 1 0 2 5  1 2 2 0 2 5
     * 2. 1 3 2 0 2 5
     * 3. 1 0 2 3 2 5
     * 4. 找到2和2相等
     *  2 3 1 0 5 2 -> 1 3 2 0 5 2-> 0 1 3 2 5 2 -> 0 1 3 2 5 2
     * 说明：
     *   1. nums[i] != i 的判断作用是防止出现 nums[i]和i相等的情况，如果相等了，那么这一步的比较没有意义
     *   nums[i] == nums[nums[i]]，因为比较的是同一个位置的数据，只要不是一个位置的数据相等了才是说明重复的
     *   2. 算法核心思想是比较当前这个位置的元素nums[i] 和 以这个元素的值为下标位置的值是否相等，如果不相同就换位置，相同就是找到了重复元素
     *   3. 对于这种数组元素在 [0, n-1] 范围内的问题，可以将值为 i 的元素调整到第 i 个位置上进行求解。
     *      本题要求找出重复的数字，因此在调整过程中，如果第 i 位置上已经有一个值为 i 的元素，就可以知道 i 值重复。
     *   4. 如果数组有重复元素的，那么再两两对比+互换以后，必然会出现有相等的
     * @param nums
     * @param length
     * @param duplication
     * @return
     */
    public static boolean duplicate(int[] nums, int length, int[] duplication) {
        if (nums == null || length <= 0)
            return false;
        for (int i = 0; i < length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    duplication[0] = nums[i];
                    return true;
                }
                swap(nums, i, nums[i]);
            }
        }
        return false;
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
