package com.test.array;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 崔航
 * @date 2020/7/8 14:18
 * 1389. 按既定顺序创建目标数组
 */
@Slf4j
public class CreateTargetArray {

    public static void main(String[] args) {

    }

    private static int[] solutionOne(int[] nums, int[] index) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(index[i], nums[i]);
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
