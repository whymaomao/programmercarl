package com.problems;

public class No75_sortColors {
    /**
     * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地 对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     *
     * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
     *
     * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [2,0,2,1,1,0]
     * 输出：[0,0,1,1,2,2]
     * 示例 2：
     *
     * 输入：nums = [2,0,1]
     * 输出：[0,1,2]
     *
     *
     * 提示：
     *
     * n == nums.length
     * 1 <= n <= 300
     * nums[i] 为 0、1 或 2
     *int n = nums.length;
     *         int p0 = 0, p2 = n - 1;
     *         for (int i = 0; i <= p2; ++i) {
     *             while (i <= p2 && nums[i] == 2) {
     *                 int temp = nums[i];
     *                 nums[i] = nums[p2];
     *                 nums[p2] = temp;
     *                 --p2;
     *             }
     *             if (nums[i] == 0) {
     *                 int temp = nums[i];
     *                 nums[i] = nums[p0];
     *                 nums[p0] = temp;
     *                 ++p0;
     *             }
     *         }
     *     }
     *
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/sort-colors/solutions/437968/yan-se-fen-lei-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * 进阶：
     *
     * 你能想出一个仅使用常数空间的一趟扫描算法吗？
     */

    public static void sortColors(int[] nums) {
        int startIndex = 0;
        int endIndex = nums.length - 1;
        int index = 0;
        while(startIndex < endIndex && index < nums.length) {
            if(nums[index] == 0) {
                nums[index] = nums[startIndex];
                nums[startIndex] = 0;
                startIndex ++;
            } else if(nums[index] == 2) {
                nums[index] = nums[endIndex];
                nums[endIndex] = 2;
                endIndex --;
            } else {
                index++;
            }
        }
    }




}
