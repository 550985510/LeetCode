package com.test.array;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 崔航
 * @date 2020/7/6 12:42
 * 1431. 拥有最多糖果的孩子
 */
@Slf4j
public class KidsWithCandies {

    public static void main(String[] args) {
        int extraCandies = 3;
        List<Boolean> list = solutionOne(new int[]{2, 3, 5, 1, 3}, extraCandies );
        log.info("{}", list);
    }

    private static List<Boolean> solutionOne(int[] candies, int extraCandies) {
        List<Boolean> list = new ArrayList<>(candies.length);
        int max = Arrays.stream(candies).max().orElse(0);
        for (int candy : candies) {
            list.add(candy + extraCandies >= max);
        }
        return list;
    }
}
