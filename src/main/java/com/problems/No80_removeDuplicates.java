package com.problems;

import java.io.IOException;
import java.io.PrintWriter;

public class No80_removeDuplicates {

    /**
     * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     *
     *
     *
     * 说明：
     *
     * 为什么返回数值是整数，但输出的答案是数组呢？
     *
     * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
     *
     * 你可以想象内部操作如下:
     *
     * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
     * int len = removeDuplicates(nums);
     *
     * // 在函数里修改输入数组对于调用者是可见的。
     * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
     * for (int i = 0; i < len; i++) {
     *     print(nums[i]);
     * }
     *
     *
     * 示例 1：
     *
     * 输入：nums = [1,1,1,2,2,3]
     * 输出：5, nums = [1,1,2,2,3]
     * 解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3。 不需要考虑数组中超出新长度后面的元素。
     * 示例 2：
     *
     * 输入：nums = [0,0,1,1,1,1,2,3,3]
     * 输出：7, nums = [0,0,1,1,2,3,3]
     * 解释：函数应返回新长度 length = 7, 并且原数组的前七个元素被修改为 0, 0, 1, 1, 2, 3, 3。不需要考虑数组中超出新长度后面的元素。
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 3 * 104
     * -104 <= nums[i] <= 104
     * nums 已按升序排列
     */


    public int removeDuplicates1(int[] nums) {
        if(nums.length <= 2) return nums.length;

        int cnt = 2; // 先计入 nums[0], nums[1]
        int v1 = nums[0]; // 前面第二个元素
        int v2 = nums[1]; // 前面第一个元素

        for(int i = 2; i < nums.length; i++){
            // nums[i] != v2, 说明不是重复两次以上的后续元素。
            // 因为数组有序，v1 <= v2。nums[i] 如果 == v1，那么也 == v2
            if(nums[i] != v1) {
                cnt++; // 计数
                nums[cnt - 1] = nums[i]; // 放入 cnt - 1 处
                // 以上两行可以合并简化，但个人更倾向于可读性
            }
            v1 = v2;
            v2 = nums[i];
        }

        return cnt;
    }

    public static void main(String[] args) {
        String filePath = "ru_device_id.csv";
        try (PrintWriter writer = new PrintWriter(filePath)) {
            for(int j = 0; j < 5; j ++) {
                for (int i = 1; i <= 3000; i++) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(i);
                    sb.append('\n');

                    writer.write(sb.toString());
                }
            }
            System.out.println("Data written to the CSV file successfully!");

        } catch (IOException e) {
            System.out.println("An error occurred while writing to the CSV file");
            e.printStackTrace();
        }
    }

}
