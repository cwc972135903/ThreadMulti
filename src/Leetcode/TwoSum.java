package Leetcode;

/**
 * <p>Title: xCRMS </p>
 * Description: 题目描述：在有序数组中找出两个数，使它们的和为 target。
 *              Input: numbers={2, 7, 11, 15}, target=9
 *              Output: index1=1, index2=2
 * 解题思路： 使用双指针，一个指针指向值较小的元素，一个指针指向值较大的元素。指向较小元素的指针从头向尾遍历，指向较大元素的指针从尾向头遍历
 *            如果两个指针指向元素的和 sum == target，那么得到要求的结果；
 *            如果 sum > target，移动较大的元素，使 sum 变小一些；
 *            如果 sum < target，移动较小的元素，使 sum 变大一些。
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/1/23 10:40
 */
public class TwoSum {

    public static void main(String ...args){
        int[] arr = {2, 7, 11, 15};
        int[] res = new int[2];

        twoNumbers(arr,18, res);
        if(res.length == 2){
            System.out.println("index1: "+res[0]+" index2: " +res[1]);
        }else{
            System.out.println("当前没有找到结果！");
        }
    }

    public static void twoNumbers(int[] targetArray,int targetSum, int[] returnArray){
        if(targetArray.length ==0 || targetArray == null){
            return;
        }
        int arrLen = targetArray.length;
        int startIndex = 0;
        int endIndex = arrLen - 1;
        while (startIndex != endIndex){
            int curSum = targetArray[startIndex]+targetArray[endIndex];
            if (curSum == targetSum){
                returnArray[0] = startIndex;
                returnArray[1] = endIndex;
                break;
            }else if(curSum > targetSum){
                endIndex--;
            }else{
                startIndex++;
            }
        }

    }
}
