package com.test.array;

import com.test.model.FinalVal;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 崔航
 * @date 2020/7/3 15:49
 * 1480. 一维数组的动态和
 * 动态求和 从后往前加
 */
@Slf4j
public class RunningSum {

    public static void main(String[] args) {
        int[] nums = FinalVal.ARRAY;
        int[] result = solutionOne(nums);
        log.info("{}", result);
    }

    private static int[] solutionOne(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] + nums[i];
        }
        return nums;
    }
}
