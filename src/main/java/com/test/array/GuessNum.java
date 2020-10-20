package com.test.array;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 崔航
 * @date 2020/7/7 11:24
 * LCP 01. 猜数字
 */
@Slf4j
public class GuessNum {

    public static void main(String[] args) {
        int count = solutionOne(new int[]{1, 2, 3}, new int[]{2, 2, 3});
        log.info("{}", count);
    }

    private static int solutionOne(int[] guess, int[] answer) {
        int count = 0;
        for (int i = 0; i < guess.length; i++) {
            if (guess[i] == answer[i]) {
                count++;
            }
        }
        return count;
    }
}
