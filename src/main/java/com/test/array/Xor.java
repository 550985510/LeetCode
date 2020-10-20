package com.test.array;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 崔航
 * @date 2020/7/3 16:43
 * 1486. 数组异或操作
 */
@Slf4j
public class Xor {

    public static void main(String[] args) {
        int n = 5; int start = 0;
        int xor = solutionOne(n, start);
        log.info("{}", xor);
    }

    private static int solutionOne(int n, int start) {
        int xor = 0;
        for (int i = 0; i < n; i++) {
            xor ^= start + 2 * i;
        }
        return xor;
    }
}
