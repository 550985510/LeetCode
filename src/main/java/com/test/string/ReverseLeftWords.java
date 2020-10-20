package com.test.string;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 崔航
 * @date 2020/7/6 16:39
 * 剑指 Offer 58 - II. 左旋转字符串
 */
@Slf4j
public class ReverseLeftWords {

    public static void main(String[] args) {
       String s = "abcdefg"; int k = 2;
        String solutionOne = solutionOne(s, k);
        log.info("{}", solutionOne);
    }

    private static String solutionOne(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);
    }
}
