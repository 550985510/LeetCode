package com.test.num;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 崔航
 * @date 2020/7/8 9:47
 * 1342. 将数字变成 0 的操作次数
 */
@Slf4j
public class NumberOfSteps {

    public static void main(String[] args) {
        int steps = solutionOne(14);
        log.info("{}", steps);
    }

    private static int solutionOne(int num) {
        int steps = 0;
        while (num != 0) {
            if ((num & 1) == 1) {
                num--;
            } else {
                num = num >> 1;
            }
            steps++;
        }
        return steps;
    }
}
