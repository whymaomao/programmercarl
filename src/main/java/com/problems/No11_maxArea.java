package com.problems;

public class No11_maxArea {

    /**
     * 输入：[1,8,6,2,5,4,8,3,7]
     * 输出：49
     * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
     * Try to use two-pointers. Set one pointer to the left and one to the right of the array.
     * Always move the pointer that points to the lower line.
     */
    public static int maxArea(int[] height) {
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        int maxArea = 0;
        int width = height.length - 1;

        while(leftIndex < rightIndex) {
            maxArea = Math.max(maxArea, (Math.min(height[leftIndex], height[rightIndex])) * width);
            if(height[leftIndex] < height[rightIndex]) {
                leftIndex ++;
                width --;
            } else {
                rightIndex --;
                width --;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}
