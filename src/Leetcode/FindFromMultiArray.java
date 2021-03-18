package Leetcode;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * 1. 题目：
 * 给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中
 *   [[1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]]
 * 2. 解题思路：
 *    该二维数组中的一个数，小于它的数一定在其左边，大于它的数一定在其下边。因此，从右上角开始查找，
 *    就可以根据 target 和当前元素的大小关系来缩小查找区间，当前元素的查找区间为左下角的所有元素
 *
 * 3. 要求时间复杂度O(M+N),如果采用遍历的方式，时间复杂度肯定的M*N了
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/1/22 9:45
 */
public class FindFromMultiArray {
    public static void main(String ...args){
        int [][] matrix =  {{1,   4,  7, 11, 15},
                            {2,   5,  8, 12, 19},
                            {3,   6,  9, 16, 22},
                            {10, 13, 14, 17, 24},
                            {18, 21, 23, 26, 30}};
        int target = 9;
        findTargetExist(target, matrix);
    }

    public static boolean findTargetExist(int targetNum, int[][] matrix){
        //从右上角开始遍历，如果当前目标值大于当前值，就往下一个，小于就往左一个寻找
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int rows = matrix.length, cols = matrix[0].length;
        int r = 0, c = cols - 1; // 从右上角开始
        while (r <= rows - 1 && c >= 0) {
            if (targetNum == matrix[r][c])
                return true;
            else if (targetNum > matrix[r][c])
                r++;
            else
                c--;
        }
        return false;
    }
}
