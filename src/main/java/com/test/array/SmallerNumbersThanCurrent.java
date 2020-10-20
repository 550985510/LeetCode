package com.test.array;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 崔航
 * @date 2020/7/9 17:17
 * 1365. 有多少小于当前数字的数字
 */
@Slf4j
public class SmallerNumbersThanCurrent {

    public static void main(String[] args) {
        String a = "select * from abc where a = {abc}";
        if (a.contains("{abc}")) {
            String s = a.replaceAll("\\{abc}", "1");
            log.info(s);
        }
    }

    private static int[] solutionOne(int[] nums) {
        int[] result = new int[nums.length];
        return result;
    }
}
