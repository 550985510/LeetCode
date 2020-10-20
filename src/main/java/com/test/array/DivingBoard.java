package com.test.array;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 崔航
 * @date 2020/7/8 8:57
 * 面试题 16.11. 跳水板
 */
@Slf4j
public class DivingBoard {

    public static void main(String[] args) {
        int[] result = solutionOne(1, 2, 3);
        log.info("{}", result);
    }

    private static int[] solutionOne(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }
        if (shorter == longer) {
            return new int[] {shorter * k};
        }
        int[] result = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            result[i] = shorter * (k - i) + longer * i;;
        }
        return result;
    }

}
