package com.linle.exe.code2024.exec2401.exec240112;

import org.junit.Test;

/**
 * @description: 11. 盛最多水的容器 middle
 * @author: chendeli
 * @date: 2024-01-13 18:09
 */
public class MaxArea {
    /**
     * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
     *
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     *
     * 返回容器可以储存的最大水量。
     *
     * 说明：你不能倾斜容器。
     *
     * 示例 1：
     *
     * 输入：[1,8,6,2,5,4,8,3,7]
     * 输出：49
     * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
     * 示例 2：
     *
     * 输入：height = [1,1]
     * 输出：1
     *
     * 提示：
     *
     * n == height.length
     * 2 <= n <= 10^5
     * 0 <= height[i] <= 10^4
     */
    @Test
    public void test(){
        int[] i = new int[]{1,2,4,1};
        maxArea(i);
    }

    /**
     * 解题思路：
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int j =0,k=height.length-1;
        int max = 0;
        while(j<k){
            max = Math.max(max,Math.min(height[j],height[k])*(k-j));
           if(height[j] >= height[k]){
               k--;
           }else {
               j++;
           }
        }
        return max;
    }
}
