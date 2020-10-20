package com.test.array;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 崔航
 * @date 2020/7/6 14:03
 * 1470. 重新排列数组
 */
@Slf4j
public class Shuffle {

    public static void main(String[] args) {
        int[] nums = solutionOne(new int[]{0, 1, 2, 3, 4, 6}, 3);
        log.info("{}", nums);
    }

    private static int[] solutionOne(int[] nums, int n) {
        int[] result = new int[nums.length];
        int index = 0;
        for (int i = 0; i < n; i++) {
            result[index++] = nums[i];
            result[index++] = nums[n+i];
        }
        return result;
    }
}
