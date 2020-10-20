package com.test.string;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 崔航
 * @date 2020/7/7 16:48
 * 771. 宝石与石头
 */
@Slf4j
public class NumJewelsInStones {

    public static void main(String[] args) {
        int count = solutionOne("aA", "aAAbbbb");
        log.info("{}", count);
    }

    private static int solutionOne(String jewels, String stones) {
        int count = 0;
        char[] chars = jewels.toCharArray();
        for (char c : chars) {
            count += stones.length() - stones.replace(String.valueOf(c), "").length();
        }
        return count;
    }
}
